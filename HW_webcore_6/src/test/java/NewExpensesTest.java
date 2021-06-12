import Pages.*;
import org.junit.jupiter.api.Test;

public class NewExpensesTest extends BaseTest {

    @Test
    public void createNewExpensePositiveTest(){
        AllExpensesPage expensesScreen = (AllExpensesPage) new LoginPage(driver)
                .loginScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.EXPENSES)
                .clickSubMenuButton(ExpenseSubMenuButtons.EXPENSE_REQUEST);

        expensesScreen
                .clickOnCreateNewExpenseButton()
                .enterDescription("test1234")
                .selectBusinessUnit(1)
                .selectExpenditure(87)
                .setExpenseSum(10000000)
                .clickNotifyDateChangedCheckBox()
                .selectDateInDatePicker(20)
                .clickSubmit()
                .checkNewExpensePopUp();

    }
}
