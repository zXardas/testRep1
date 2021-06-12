package Pages;

import org.openqa.selenium.WebDriver;

public class ExpenseSubMenu extends SubMenu{
    public ExpenseSubMenu (WebDriver driver) {super (driver);}

    @Override
    public Base clickSubMenuButton (SubMenuButtons buttons){
        if (buttons instanceof ExpenseSubMenuButtons) {
            switch ((ExpenseSubMenuButtons)buttons) {
                case EXPENSE_REQUEST:
                    driver.findElement(((ExpenseSubMenuButtons)buttons).getBy()).click();
                    return new AllExpensesPage(driver);

                default:
                    throw new IllegalArgumentException("не назначаен");
            }
        } else {throw new IllegalArgumentException("Incorrect button type");}
    }
}
