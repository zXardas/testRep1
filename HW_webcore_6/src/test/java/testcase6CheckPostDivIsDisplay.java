import Pages.MailHomePage;
import Pages.MailPostDomain;
import Pages.NewsBar;
import Pages.NewsBarTabs;
import org.junit.jupiter.api.Test;

public class testcase6CheckPostDivIsDisplay extends BaseTest {

    @Test
    public void checkPostDivIsDisplay() {
        driver.get(Configuration.MAIL_URL);

        MailHomePage mailHomePage = new MailHomePage(driver)
                .checkAllPostElementsDisplay();
    }
}