import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {
    @JsonProperty("Date")
  /*  public Date getDate() {
        return this.date; }*/
    public void setDate(Date date) {
        this.date = date; }
    Date date;
    @JsonProperty("EpochDate")
    public int getEpochDate() {
        return this.epochDate; }
    public void setEpochDate(int epochDate) {
        this.epochDate = epochDate; }
    int epochDate;
    @JsonProperty("Temperature")
    public Temperature getTemperature() {
        return this.temperature; }
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature; }
    Temperature temperature;
    @JsonProperty("Day")
    public Day getDay() {
        return this.day; }
    public void setDay(Day day) {
        this.day = day; }
    Day day;
    @JsonProperty("Night")
    public Night getNight() {
        return this.night; }
    public void setNight(Night night) {
        this.night = night; }
    Night night;
    @JsonProperty("Sources")
    public List<String> getSources() {
        return this.sources; }
    public void setSources(List<String> sources) {
        this.sources = sources; }
    List<String> sources;
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

    public String getDate() {
        String delimeter = " ";
        String[] subS = this.date.toString().split(delimeter);
        return subS[2]+" "+ subS[1]+"("+subS[0]+")";

    }
}
