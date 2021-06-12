package Pages;

import org.openqa.selenium.WebDriver;

public class ContactSubMenu    extends SubMenu{
    public ContactSubMenu (WebDriver driver) {super (driver);}

    @Override
    public Base clickSubMenuButton (SubMenuButtons buttons){
        if (buttons instanceof ContactSubMenuButtons) {
            switch ((ContactSubMenuButtons)buttons) {
                case CONTACT:
                    driver.findElement(((ContactSubMenuButtons)buttons).getBy()).click();
                    return new AllContactsPage(driver);

                default:
                    throw new IllegalArgumentException("не назначаен");
            }
        } else {throw new IllegalArgumentException("Incorrect button type");}
    }
}