package Pages;

import org.openqa.selenium.WebDriver;

public class ProjectSubMenu extends SubMenu{
    public ProjectSubMenu (WebDriver driver) {super (driver);}

    @Override
    public Base clickSubMenuButton (SubMenuButtons buttons){
        if (buttons instanceof ProjectsSubMenuButtons) {
            switch ((ProjectsSubMenuButtons)buttons) {
                case MYPROJECTS:
                    driver.findElement(((ProjectsSubMenuButtons)buttons).getBy()).click();
                    return new AllMyProjectPage(driver);

                default:
                    throw new IllegalArgumentException("не назначаен");
            }
        } else {throw new IllegalArgumentException("Incorrect button type");}
    }
}
