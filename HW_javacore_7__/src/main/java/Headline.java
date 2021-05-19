import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline{
    @JsonProperty("EffectiveDate")
    public Date getEffectiveDate() {
        return this.effectiveDate; }
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate; }
    Date effectiveDate;
    @JsonProperty("EffectiveEpochDate")
    public int getEffectiveEpochDate() {
        return this.effectiveEpochDate; }
    public void setEffectiveEpochDate(int effectiveEpochDate) {
        this.effectiveEpochDate = effectiveEpochDate; }
    int effectiveEpochDate;
    @JsonProperty("Severity")
    public int getSeverity() {
        return this.severity; }
    public void setSeverity(int severity) {
        this.severity = severity; }
    int severity;
    @JsonProperty("Text")
    public String getText() {
        return this.text; }
    public void setText(String text) {
        this.text = text; }
    String text;
    @JsonProperty("Category")
    public String getCategory() {
        return this.category; }
    public void setCategory(String category) {
        this.category = category; }
    String category;
    @JsonProperty("EndDate")
    public Date getEndDate() {
        return this.endDate; }
    public void setEndDate(Date endDate) {
        this.endDate = endDate; }
    Date endDate;
    @JsonProperty("EndEpochDate")
    public int getEndEpochDate() {
        return this.endEpochDate; }
    public void setEndEpochDate(int endEpochDate) {
        this.endEpochDate = endEpochDate; }
    int endEpochDate;
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