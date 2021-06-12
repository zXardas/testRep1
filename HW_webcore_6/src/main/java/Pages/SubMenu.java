package Pages;

import org.openqa.selenium.WebDriver;

public abstract class SubMenu extends Base{

    public SubMenu(WebDriver driver) {super(driver);}

    abstract public Base clickSubMenuButton (SubMenuButtons buttons);

}
