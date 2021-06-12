package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NewsBar   extends Base {
    public NewsBar(WebDriver driver){ super (driver);}

     public NewsBar checkTabVisibility (NewsBarTabs tab) {

        Assertions.assertTrue(driver.findElement(tab.getBy()).isDisplayed());
        return this;
    }

    public NewsBar checkTabName (NewsBarTabs tab, String name) {

        Assertions.assertEquals(driver.findElement(tab.getBy()).getText(),name);

        return this;
    }
}