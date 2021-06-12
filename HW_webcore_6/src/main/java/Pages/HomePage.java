package Pages;

import Navigation.NavigationBar;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base{

    private NavigationBar navigationBar;

    public HomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
        }

        public void checkUrl(String url) {
            Assertions.assertEquals(driver.getCurrentUrl(),url);}

            public void checkTitle (String title){
        Assertions.assertEquals(driver.getTitle(),title);
            }

        public NavigationBar getPageNavigation() {return navigationBar;}

}
