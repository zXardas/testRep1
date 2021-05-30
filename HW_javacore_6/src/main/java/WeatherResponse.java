import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty("Headline")
    public Headline getHeadline() {
        return this.headline; }
    public void setHeadline(Headline headline) {
        this.headline = headline; }
    Headline headline;
    @JsonProperty("DailyForecasts")
    public List<DailyForecast> getDailyForecasts() {
        return this.dailyForecasts; }
    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts; }
    List<DailyForecast> dailyForecasts;
}
