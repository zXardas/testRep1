import Pages.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class testcase1CreateNewMyProjectPositiv extends BaseTest {

    @Test
    public void createNewMyProjectPositiveTest(){
        driver.get(Configuration.BASE_URL+ Configuration.LOGIN_PATH);
        Random r = new Random();
        String s = "user" + r.nextInt(100000000);

        AllMyProjectPage myProjectsScreen = (AllMyProjectPage) new LoginPage(driver)
                .loginScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.PROJECTS)
                .clickSubMenuButton(ProjectsSubMenuButtons.MYPROJECTS);

        myProjectsScreen
                .clickOnCreateNewExpenseButton()
                .enterProjectName(s)
                .enterOrganizationName("1234")
                .enterDepartamentName(1)
                .enterCuratorName(115)
                .enterCuratorName(115)
                .enterDirectName(115)
                .enterManagerName(115)
                .enterContactName()
                .createMyProjectButtonClick()
                .checkNewMyProjectPopUp();


    }
}