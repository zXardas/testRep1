import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;



public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeAll
    public static void setupWebDriverManager() {
        System.setProperty("webdriver.chrome.driver", "P:\\Java\\HW5_webcore\\src\\main\\resources\\chromedriver.exe");

    }

    @BeforeEach
    public void beforeTest() {

        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

    }

    @AfterEach
    public void tearDown() { if (driver != null) driver.quit(); }
}

