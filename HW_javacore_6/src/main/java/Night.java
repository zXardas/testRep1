import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Night {
    @JsonProperty("Icon")
    public int getIcon() {
        return this.icon; }
    public void setIcon(int icon) {
        this.icon = icon; }
    int icon;
    @JsonProperty("IconPhrase")
    public String getIconPhrase() {
        return this.iconPhrase; }
    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase; }
    String iconPhrase;
    @JsonProperty("HasPrecipitation")
    public boolean getHasPrecipitation() {
        return this.hasPrecipitation; }
    public void setHasPrecipitation(boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation; }
    boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    public String getPrecipitationType() {
        return this.precipitationType; }
    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType; }
    String precipitationType;
    @JsonProperty("PrecipitationIntensity")
    public String getPrecipitationIntensity() {
        return this.precipitationIntensity; }
    public void setPrecipitationIntensity(String precipitationIntensity) {
        this.precipitationIntensity = precipitationIntensity; }
    String precipitationIntensity;
}
