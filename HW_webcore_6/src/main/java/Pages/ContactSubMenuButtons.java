package Pages;

import org.openqa.selenium.By;

public enum ContactSubMenuButtons implements SubMenuButtons{
    CONTACT("//*[@id='main-menu']/ul/li[1]/ul/li[5]/a/span");

    private final By by;
    ContactSubMenuButtons( String xpath) {this.by= By.xpath(xpath);}

    public By getBy() {return by;}
}
