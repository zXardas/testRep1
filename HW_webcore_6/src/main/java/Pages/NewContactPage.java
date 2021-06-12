package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewContactPage extends Base {

    @FindBy(name = "crm_contact[lastName]")
    private WebElement newContactLastNameInput;

    public NewContactPage enterContactLastName(String description) {
        newContactLastNameInput.sendKeys(description);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    private WebElement newContactFirstNameInput;

    public NewContactPage enterContactFirstName(String description) {
        newContactFirstNameInput.sendKeys(description);
        return this;
    }

    @FindBy(xpath = "//a[@class='select2-choice select2-default']")
    private WebElement newContactOrganization;

    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    private WebElement newContactOrganizationInput;

    public NewContactPage enterOrganization(String description) {
        newContactOrganization.click();
        newContactOrganizationInput.sendKeys(description);
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='select2-drop']/ul[2]/li[1]/div"))));
        newContactOrganizationInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(name = "crm_contact[jobTitle]")
    private WebElement newContactJob;

    public NewContactPage enterContactJob(String description) {
        newContactJob.sendKeys(description);
        return this;
    }

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement createNewContactButton;

    public AllContactsPage createNewContactButton( ) {
        createNewContactButton.click();
        return new AllContactsPage(driver);
    }


    public NewContactPage(WebDriver driver) {
        super(driver);
    }

}
