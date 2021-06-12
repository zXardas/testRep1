package Pages;

import org.openqa.selenium.By;

public enum ProjectsSubMenuButtons implements SubMenuButtons{
    MYPROJECTS ("//div[@class='main-menu-top']//a[@href='/project/my']");

    private final By by;
    ProjectsSubMenuButtons( String xpath) {this.by= By.xpath(xpath);}

    public By getBy() {return by;}
}
