import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Minimum{
    @JsonProperty("Value")
    public double getValue() {
                return this.value;
    }
    public void setValue(double value) {
                this.value = value;
    }
    double value;
    @JsonProperty("Unit")
    public String getUnit() {
                return this.unit;
    }
    public void setUnit(String unit) {
                this.unit = unit;
    }
    String unit;
    @JsonProperty("UnitType")
    public int getUnitType() {
                return this.unitType;
    }
    public void setUnitType(int unitType) {
                this.unitType = unitType;
    }
    int unitType;
}