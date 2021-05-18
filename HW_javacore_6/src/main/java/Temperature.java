import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    @JsonProperty("Minimum")
    public Minimum getMinimum() {
        return this.minimum; }
    public void setMinimum(Minimum minimum) {
        this.minimum = minimum; }
    Minimum minimum;
    @JsonProperty("Maximum")
    public Maximum getMaximum() {
        return this.maximum; }
    public void setMaximum(Maximum maximum) {
        this.maximum = maximum; }
    Maximum maximum;
}
