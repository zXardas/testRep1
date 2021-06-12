import Pages.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class testcase3CheckNewsBarElements extends BaseTest {

    @Test
    public void createNewMyProjectPositiveTest() {
        driver.get(Configuration.MAIL_URL);

        NewsBar mailHomePage = new MailHomePage(driver)
                .getNewsBar()
                .checkTabVisibility(NewsBarTabs.NEWS)
                .checkTabVisibility(NewsBarTabs.AUTO)
                .checkTabVisibility(NewsBarTabs.CHILDS)
                .checkTabVisibility(NewsBarTabs.CINEMA)
                .checkTabVisibility(NewsBarTabs.GAMES)
                .checkTabVisibility(NewsBarTabs.HEALTH)
                .checkTabVisibility(NewsBarTabs.HITECH)
                .checkTabVisibility(NewsBarTabs.HOUSE)
                .checkTabVisibility(NewsBarTabs.LADY)
                .checkTabVisibility(NewsBarTabs.PETS)
                .checkTabVisibility(NewsBarTabs.SPORT);
    }
}