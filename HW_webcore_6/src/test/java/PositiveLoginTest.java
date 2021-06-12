import Pages.LoginPage;
import org.junit.jupiter.api.Test;

public class PositiveLoginTest extends BaseTest {

    @Test
    public void loginWithBaseUserTest(){
        new LoginPage(driver)
                .enterLogin(Configuration.STUDENT_LOGIN)
                .enterPassword(Configuration.STUDENT_PASSWORD)
                .clickLoginButton()
                .checkUrl(Configuration.BASE_URL);

    }
}
