package Navigation;

import Pages.*;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class NavigationBar extends Base {
    public NavigationBar(WebDriver driver){ super (driver);}

    public SubMenu moveCursorToNavigationTab (NavigationBarTabs tab){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(tab.getBy()))
                .build()
                .perform();
        switch (tab) {
            case EXPENSES:
                return new ExpenseSubMenu(driver);

            case PROJECTS:
                return new ProjectSubMenu(driver);

            case COUNTER_PARTIES:
                return new ContactSubMenu(driver);

            default:
                throw new IllegalArgumentException("Другие вкладки не обработаны");
        }
    }

    public NavigationBar checkTabVisibility (NavigationBarTabs tab) {

        Assertions.assertTrue(driver.findElement(tab.getBy()).isDisplayed());
        return this;
    }
}
