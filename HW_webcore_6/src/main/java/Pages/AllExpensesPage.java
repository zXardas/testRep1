package Pages;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllExpensesPage extends Base{
    @FindBy(css = "div[class='pull-left btn-group icons-holder']")
    private WebElement createNewExpenseButton;

    public AllExpensesPage(WebDriver driver) {super(driver);}

    public NewExpensePage clickOnCreateNewExpenseButton(){
        createNewExpenseButton.click();
        return new NewExpensePage(driver);
    }

    public AllExpensesPage checkNewExpensePopUp(){
        String message = new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='message']"))).getText();
        Assertions.assertTrue(message.contains("Заявка на расход сохранена"));
        return this;
    }
}
