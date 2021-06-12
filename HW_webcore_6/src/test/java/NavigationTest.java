import Pages.LoginPage;
import Pages.NavigationBarTabs;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class NavigationTest extends BaseTest {
    @ParameterizedTest
    @MethodSource("navigationTabProvider")
    public void checkMainNavigationTabsTest(NavigationBarTabs barTab){
        new LoginPage(driver)
                .loginScenario(Configuration.STUDENT_LOGIN,Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .checkTabVisibility(barTab);
    }

    static NavigationBarTabs[] navigationTabProvider() {return NavigationBarTabs.values();}
}
