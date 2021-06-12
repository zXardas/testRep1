package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewMyProjectPage extends Base {

    @FindBy(name = "crm_project[name]")
    private WebElement newProjectNameInput;

    public NewMyProjectPage enterProjectName(String description) {
        newProjectNameInput.sendKeys(description);
        return this;
    }

    @FindBy(xpath = "//a[@class='select2-choice select2-default']")
    private WebElement newProjectOrganization;

    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    private WebElement newProjectOrganizationInput;

    public NewMyProjectPage enterOrganizationName(String description) {
        newProjectOrganization.click();
        newProjectOrganizationInput.sendKeys(description);
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='select2-result-label']"))));
        newProjectOrganizationInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement newProjectDepartmentInput;

    public NewMyProjectPage enterDepartamentName(int value) {
        Select departmentUnitDropDown = new Select(newProjectDepartmentInput);
        departmentUnitDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    private WebElement newProjectCuratorInput;

    public NewMyProjectPage enterCuratorName(int value) {
        Select curatorUnitDropDown = new Select(newProjectCuratorInput);
        curatorUnitDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    private WebElement newProjectDirectInput;

    public NewMyProjectPage enterDirectName(int value) {
        Select directUnitDropDown = new Select(newProjectDirectInput);
        directUnitDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    private WebElement newProjectManagerInput;

    public NewMyProjectPage enterManagerName(int value) {
        Select managerUnitDropDown = new Select(newProjectManagerInput);
        managerUnitDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @FindBy(xpath = "//div[@class='select2-container select2']")
    private WebElement newProjectContactInput;

    public NewMyProjectPage enterContactName() {
        newProjectContactInput.click();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='select2-drop']/ul[2]/li[1]/div"))));
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement newProjectCreateButton;

    public AllMyProjectPage createMyProjectButtonClick() {
        newProjectCreateButton.click();
        return new AllMyProjectPage(driver);
    }

    public NewMyProjectPage(WebDriver driver) {
        super(driver);
    }

}
