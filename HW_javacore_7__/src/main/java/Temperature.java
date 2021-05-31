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

    ////// код для получения прогноза на 1 день
    @JsonProperty("Metric")
    public Metric getMetric() {
        return this.metric; }
    public void setMetric(Metric metric) {
        this.metric = metric; }
   Metric metric;
    @JsonProperty("Imperial")
    public Imperial getImperial() {
        return this.imperial; }
    public void setImperial(Imperial imperial) {
        this.imperial = imperial; }
    Imperial imperial;
}
