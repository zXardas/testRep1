import Pages.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class testcase2CreateNewContactPositiv extends BaseTest {

    @Test
    public void createNewMyProjectPositiveTest(){
        driver.get(Configuration.BASE_URL+ Configuration.LOGIN_PATH);
        Random r = new Random();
        String s = "user" + r.nextInt(100000000);

        AllContactsPage contactsScreen = (AllContactsPage) new LoginPage(driver)
                .loginScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.COUNTER_PARTIES)
                .clickSubMenuButton(ContactSubMenuButtons.CONTACT);

        contactsScreen.clickOnCreateNewContactButton()
                .enterContactFirstName(s)
                .enterContactLastName(s)
                .enterOrganization("1234")
                .enterContactJob(s)
                .createNewContactButton()
                .checkNewContactPopUp();


    }
}