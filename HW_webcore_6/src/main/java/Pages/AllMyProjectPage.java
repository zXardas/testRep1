package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllMyProjectPage extends Base {

    @FindBy(xpath = "//div[@id='main']//a[@href='/project/create/']")
    private WebElement createNewProjectButton;

    public AllMyProjectPage(WebDriver driver) {
        super(driver);
    }

    public NewMyProjectPage clickOnCreateNewExpenseButton() { //проверить тип
        createNewProjectButton.click();
        return new NewMyProjectPage(driver);
    }

    public AllMyProjectPage checkNewMyProjectPopUp() {
        String message = new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='message']"))).getText();
        Assertions.assertTrue(message.contains("Проект сохранен"));
        return this;
    }
}
