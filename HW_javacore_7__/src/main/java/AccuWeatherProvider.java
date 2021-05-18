

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String DAILY_FORECAST = "daily";
    private static final String FIVE_DAYS = "5day";
    private static final String ONE_DAY = "1day";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private DatabaseRepository dB= new DatabaseRepositorySQLiteImpl();

    @Override
    public void getWeather(Periods periods) throws IOException, SQLException {
        String cityKey = detectCityKey();
        //String cityKey = "332287";
        if (periods.equals(Periods.NOW)) {

            /*рабочий вариант ДЗ, но используется другой API тоже выводящий погоду на 1 день
            HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST_ENDPOINT)
                .addPathSegment(API_VERSION)
                    .addPathSegment(DAILY_FORECAST)
                    .addPathSegment(ONE_DAY)
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language","ru")
                    .addQueryParameter("metric","true")
                .build();
            Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();
           Response response = client.newCall(request).execute();
            String body = response.body().string();
             WeatherResponse t = objectMapper.readValue(body, WeatherResponse.class);
              System.out.printf("В городе %s сегодня ожидается %s, минимальная температура %s C, максимальная температура %s C", ApplicationGlobalState.getInstance().getSelectedCity(), t.dailyForecasts.get(0).getDay().getIconPhrase(), t.dailyForecasts.get(0).temperature.getMinimum().getValue(),t.dailyForecasts.get(0).temperature.getMaximum().getValue() );
            System.out.println();  */

            //вариант работы с API взятый из готового примера

            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            String body = response.body().string();
            System.out.println(body);
            List<WeatherResponse> t = objectMapper.readValue(body,new TypeReference<List<WeatherResponse>>(){});
            System.out.printf("В городе %s сегодня  %s %s", ApplicationGlobalState.getInstance().getSelectedCity(), t.get(0).temperature.metric.value, t.get(0).temperature.getMetric().getUnit() );
            dB.saveWeatherData(new WeatherData(ApplicationGlobalState.getInstance().getSelectedCity(),t.get(0).getLocalObservationDateTime(),t.get(0).getWeatherText(),t.get(0).temperature.metric.value));
            System.out.println();

        }
        if (periods.equals(Periods.FIVE_DAYS)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(DAILY_FORECAST)
                    .addPathSegment(FIVE_DAYS)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language","ru")
                    .addQueryParameter("details","false")
                    .addQueryParameter("metric","true")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            String body = response.body().string();
            System.out.println("js "+body);
            DecimalFormat format= new DecimalFormat("##.#");
            WeatherResponse t = objectMapper.readValue(body, WeatherResponse.class);
            for(DailyForecast l:t.dailyForecasts) {
                dB.saveWeatherData(new WeatherData(ApplicationGlobalState.getInstance().getSelectedCity(),l.getDate(),l.getDay().getIconPhrase(),(((l.getTemperature().getMaximum().getValue()+l.getTemperature().getMinimum().getValue())/2))));
                System.out.println();
                System.out.printf("В городе %s на дату %s ожидается %s, максимальная температура %s%s, минимальная температура %s%s",ApplicationGlobalState.getInstance().getSelectedCity(), l.getDate(),l.getDay().getIconPhrase(),l.getTemperature().getMaximum().getValue(),l.getTemperature().getMaximum().getUnit(),l.getTemperature().getMinimum().getValue(),l.getTemperature().getMinimum().getUnit());
                System.out.println(", Средняя "+format.format((l.getTemperature().getMaximum().getValue()+l.getTemperature().getMinimum().getValue())/2)+l.getTemperature().getMaximum().getUnit());
            }


        }
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
            .scheme("http")
            .host(BASE_HOST)
            .addPathSegment("locations")
            .addPathSegment(API_VERSION)
            .addPathSegment("cities")
            .addPathSegment("autocomplete")
            .addQueryParameter("apikey", API_KEY)
            .addQueryParameter("q", selectedCity)
            .build();

        Request request = new Request.Builder()
            .addHeader("accept", "application/json")
            .url(detectLocationURL)
            .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);
        System.out.println(jsonResponse);
        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }
}
