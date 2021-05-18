import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
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

    ////// код для получения прогноза на 1 день
    @JsonProperty("LocalObservationDateTime")
    public String getLocalObservationDateTime() {
        return this.localObservationDateTime; }
    public void setLocalObservationDateTime(String localObservationDateTime) {
        this.localObservationDateTime = localObservationDateTime; }
    String localObservationDateTime;
    @JsonProperty("EpochTime")
    public int getEpochTime() {
        return this.epochTime; }
    public void setEpochTime(int epochTime) {
        this.epochTime = epochTime; }
    int epochTime;
    @JsonProperty("WeatherText")
    public String getWeatherText() {
        return this.weatherText; }
    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText; }
    String weatherText;
    @JsonProperty("WeatherIcon")
    public int getWeatherIcon() {
        return this.weatherIcon; }
    public void setWeatherIcon(int weatherIcon) {
        this.weatherIcon = weatherIcon; }
    int weatherIcon;
    @JsonProperty("HasPrecipitation")
    public boolean getHasPrecipitation() {
        return this.hasPrecipitation; }
    public void setHasPrecipitation(boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation; }
    boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    public Object getPrecipitationType() {
        return this.precipitationType; }
    public void setPrecipitationType(Object precipitationType) {
        this.precipitationType = precipitationType; }
    Object precipitationType;
    @JsonProperty("IsDayTime")
    public boolean getIsDayTime() {
        return this.isDayTime; }
    public void setIsDayTime(boolean isDayTime) {
        this.isDayTime = isDayTime; }
    boolean isDayTime;
    @JsonProperty("Temperature")
    public Temperature getTemperature() {
        return this.temperature; }
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature; }
    Temperature temperature;
    @JsonProperty("MobileLink")
    public String getMobileLink() {
        return this.mobileLink; }
    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink; }
    String mobileLink;
    @JsonProperty("Link")
    public String getLink() {
        return this.link; }
    public void setLink(String link) {
        this.link = link; }
    String link;


}
