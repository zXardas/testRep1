 import com.fasterxml.jackson.databind.JsonNode;
 import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
 import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
 import java.text.DecimalFormat;
 import java.util.List;

 public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/332287?apikey=wbnvcE2y8flilPclVjmcoP29uAdJK3NC&language=ru&details=false&metric=true").build();
        Response response = client.newCall(request).execute();
        String body = response.body().string();
        DecimalFormat format= new DecimalFormat("##.#");

/* HW6
С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени, пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
Подобрать источник самостоятельно. Можно использовать api accuweather, порядок следующий: зарегистрироваться, зарегистрировать тестовое приложение для получения api ключа, найдите нужный endpoint и изучите документацию. Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед (этого достаточно для выполнения д/з).
 */
        System.out.println("HW6");
         WeatherResponse t = objectMapper.readValue(body, WeatherResponse.class);
        System.out.println(body);

/* HW7
        Реализовать корректный вывод информации о текущей погоде. Создать класс WeatherResponse и десериализовать ответ сервера. Выводить пользователю только текстовое описание погоды и температуру в градусах цельсия.
        Реализовать корректный выход из программы
        Реализовать вывод погоды на следующие 5 дней в формате
*/
        System.out.println("HW7");

        /*получение города через отдельном запросе апи в ридтри
        Request request1 = new Request.Builder().url("http://dataservice.accuweather.com/locations/v1/332287?apikey=wbnvcE2y8flilPclVjmcoP29uAdJK3NC").build();
        Response response1 = client.newCall(request1).execute();
        String body1 = response1.body().string();
        ObjectMapper objectMapper1 = new ObjectMapper();
        JsonNode cityWhere = objectMapper1.readTree(body1).at("/LocalizedName");
    */
        for(DailyForecast l:t.dailyForecasts) {
            System.out.printf("В городе %s на дату %s ожидается %s, максимальная температура %s%s, минимальная температура %s%s",l.getMobileLink().split("/")[5].substring(0,l.getMobileLink().split("/")[5].length()-3), l.getDate(),l.getDay().getIconPhrase(),l.getTemperature().getMaximum().getValue(),l.getTemperature().getMaximum().getUnit(),l.getTemperature().getMinimum().getValue(),l.getTemperature().getMinimum().getUnit());
            System.out.println(", Средняя "+format.format((l.getTemperature().getMaximum().getValue()+l.getTemperature().getMinimum().getValue())/2)+l.getTemperature().getMaximum().getUnit());
        }
    }
}
