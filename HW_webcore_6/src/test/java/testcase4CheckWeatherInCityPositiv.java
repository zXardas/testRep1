import Pages.MailHomePage;
import Pages.MailWeatherPredictionPage;
import Pages.NewsBar;
import Pages.NewsBarTabs;
import org.junit.jupiter.api.Test;

public class testcase4CheckWeatherInCityPositiv extends BaseTest {

    @Test
    public void checkWeatherInCity() {
        driver.get(Configuration.MAIL_URL);

        MailWeatherPredictionPage weatherPredictionPage = new MailHomePage(driver)
                .WeatherPredictionButtonClick(driver)
                .checkWeatherInCity("Москва");
    }
}
