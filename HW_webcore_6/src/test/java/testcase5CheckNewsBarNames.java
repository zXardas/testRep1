import Pages.MailHomePage;
import Pages.NewsBar;
import Pages.NewsBarTabs;
import org.junit.jupiter.api.Test;

public class testcase5CheckNewsBarNames extends BaseTest {

    @Test
    public void createNewMyProjectPositiveTest() {
        driver.get(Configuration.MAIL_URL);

        NewsBar mailHomePage = new MailHomePage(driver)
                .getNewsBar()

                .checkTabName(NewsBarTabs.NEWS,"Новости")
                .checkTabName(NewsBarTabs.AUTO,"Авто")
                .checkTabName(NewsBarTabs.CHILDS,"Дети")
                .checkTabName(NewsBarTabs.CINEMA,"Кино")
                .checkTabName(NewsBarTabs.GAMES,"Игры")
                .checkTabName(NewsBarTabs.HEALTH,"Здоровье")
                .checkTabName(NewsBarTabs.HITECH,"Hi-Tech")
                .checkTabName(NewsBarTabs.HOUSE,"Дом")
                .checkTabName(NewsBarTabs.LADY,"Леди")
                .checkTabName(NewsBarTabs.PETS,"Питомцы")
                .checkTabName(NewsBarTabs.SPORT,"Спорт");
    }
}