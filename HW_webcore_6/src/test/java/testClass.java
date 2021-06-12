import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class testClass {
    private final String URLCRM = "https://crm.geekbrains.space/user/login";
    private final String URLMAIL = "https://mail.ru";
    private WebDriver driver;

    //локаторы
private String urlElementMainMenuProject = "//*[@id='main-menu']/ul/li[3]/a/span"; //проекты
    private String urlElementMainMenuMyProject = "//div[@class='main-menu-top']//a[@href='/project/my']"; //мои проекты
    private String urlElementCreateProjectButton = "//div[@id='main']//a[@href='/project/create/']"; //создать проект
    private String urlElementNewProjectName = "crm_project[name]"; // наименование
    private String urlElementNewProjectOrg = "//a[@class='select2-choice select2-default']" ; //организация
    private String urlElementNewProjectOrgName = "//*[@id='select2-drop']/div/input"; ; //значение
    private String urlElementNewProjectDepartment = "crm_project[businessUnit]";  //подразделение
    private String urlElementNewProjectCurator = "crm_project[curator]"; //куратор
    private String urlElementNewProjectDirect= "crm_project[rp]"; //руководитель
    private String urlElementNewProjectManger = "crm_project[manager]"; //менеджер
    private String urlElementNewProjectContact = "//div[@class='select2-container select2']";
    private String urlElementNewProjectSave= "//button[@class='btn btn-success action-button']";
    private String urlElementMainMenuContragents = "//*[@id='main-menu']/ul/li[1]/a/span";
    private String urlElementMainMenuContragentsContacts = "//*[@id='main-menu']/ul/li[1]/ul/li[5]/a/span";
    private String urlElementCreateContactButton = "//*[@id='container']/div[1]/div/div/div[2]/div/div/a";
    private String urlElementContactLastName = "crm_contact[lastName]";
    private String urlElementContactFirstName = "crm_contact[firstName]";
    private String urlElementContactOrganization = "//a[@class='select2-choice select2-default']";
    private String urlElementContactOrganizationInput = "//*[@id='select2-drop']/div/input";
    private String urlElementContactJob = "crm_contact[jobTitle]";
    private String urlElementContactCreate = "//button[@class='btn btn-success action-button']";
    @BeforeAll
    public static void setupWebDriverManager() {
        System.setProperty("webdriver.chrome.driver", "P:\\gamedev\\Тестирование\\Java\\HW5_webcore\\src\\main\\resources\\chromedriver.exe");

    }

    @BeforeEach
    public void beforeTest() {
        setUpDriverSession();
    }

    private void setUpDriverSession() {
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    private void loginCRM() {
        driver.get(URLCRM);
        driver.findElement(By.id("prependedInput")).click();
        driver.findElement(By.id("prependedInput")).sendKeys("user");
        driver.findElement(By.id("prependedInput2")).click();
        driver.findElement(By.id("prependedInput2")).sendKeys("1234");
        driver.findElement(By.id("_submit")).click();
    }



@Test
@DisplayName("Создание проекта")
public void testCase1() {
    loginCRM();
    Random r = new Random();
    String s = "user" + r.nextInt(100000000);
    Assertions.assertEquals("Панель инструментов",driver.getTitle());
    driver.findElement(By.xpath(urlElementMainMenuProject)).click();
    driver.findElement(By.xpath(urlElementMainMenuMyProject)).click();
    driver.findElement(By.xpath(urlElementCreateProjectButton)).click();
    driver.findElement(By.name(urlElementNewProjectName)).click();
    driver.findElement(By.name(urlElementNewProjectName)).sendKeys(s);
    driver.findElement(By.xpath(urlElementNewProjectOrg)).click();
    driver.findElement(By.xpath(urlElementNewProjectOrgName)).sendKeys("1234");
    new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='select2-result-label']"))));
    driver.findElement(By.xpath(urlElementNewProjectOrgName)).sendKeys(Keys.ENTER);
    Select select = new Select(driver.findElement(By.name(urlElementNewProjectDepartment)));
    select.selectByValue("1");
    select = new Select(driver.findElement(By.name(urlElementNewProjectCurator)));
    select.selectByValue("115");
    select = new Select(driver.findElement(By.name(urlElementNewProjectDirect)));
    select.selectByValue("115");
    select = new Select(driver.findElement(By.name(urlElementNewProjectManger)));
    select.selectByValue("115");

    driver.findElement(By.xpath(urlElementNewProjectContact)).click();
    new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='select2-drop']/ul[2]/li[1]/div"))));
    driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath(urlElementNewProjectSave)).click();
    new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='flash-messages']/div/div/div/div"))));
    Assertions.assertEquals(true,driver.findElement(By.xpath("//*[@id='flash-messages']/div/div/div/div")).isDisplayed());
    Assertions.assertEquals(true,driver.findElement(By.xpath("//*[@id='breadcrumb']/ul/li[2][contains(text(),'Все проекты')]")).isDisplayed());
}

    @Test
    @DisplayName("Создание контактного лица")
    public void testCase2() {
    loginCRM();
    Random r = new Random();
    String s = "user" + r.nextInt(100000000);
    int number = r.nextInt();
    driver.findElement(By.xpath(urlElementMainMenuContragents)).click();
    driver.findElement(By.xpath(urlElementMainMenuContragentsContacts)).click();
    Assertions.assertEquals(true, driver.findElement(By.xpath("//*[@id='breadcrumb']/ul/li[2][contains(text(),'Контактные лица')]")).isDisplayed());
    Assertions.assertEquals(true, driver.findElement(By.className("oro-datagrid")).isDisplayed());
    driver.findElement(By.xpath(urlElementCreateContactButton)).click();
    driver.findElement(By.name(urlElementContactLastName)).click();
    driver.findElement(By.name(urlElementContactLastName)).sendKeys(s);
    driver.findElement(By.name(urlElementContactFirstName)).click();
    driver.findElement(By.name(urlElementContactFirstName)).sendKeys(s);
    driver.findElement(By.xpath(urlElementContactOrganization)).click();
    driver.findElement(By.xpath(urlElementContactOrganizationInput)).sendKeys("1234");
    new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='select2-drop']/ul[2]/li[1]/div"))));
    driver.findElement(By.xpath(urlElementContactOrganizationInput)).sendKeys(Keys.ENTER);
    driver.findElement(By.name(urlElementContactJob)).click();
    driver.findElement(By.name(urlElementContactJob)).sendKeys(s);
    Assertions.assertTrue(driver.getTitle().contains("Создать контактное лицо"));
    driver.findElement(By.xpath(urlElementContactCreate)).click();
    new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='flash-messages']/div/div/div/div"))));
    Assertions.assertEquals(true,driver.findElement(By.xpath("//*[@id='flash-messages']/div/div/div/div")).isDisplayed());
}

    @Test
    @DisplayName("Проверка присутствия новостных разделов")
    public void testCase3() {
        driver.get(URLMAIL);
        ArrayList<String> menuElement = new ArrayList<>(Arrays.asList("//a[@href='//news.mail.ru/']",
       "//a[@href='//sportmail.ru/']",
        "//a[@href='//lady.mail.ru/']",
        "//a[@href='//auto.mail.ru/']",
        "//a[@href='//kino.mail.ru/']",
        "//a[@href='//hi-tech.mail.ru/']",
        "//a[@href='//games.mail.ru/pc/']",
        "//a[@href='//deti.mail.ru/']",
        "//a[@href='//health.mail.ru/']",
        "//a[@href='//dom.mail.ru/?fromprefix=1']",
        "//a[@href='//pets.mail.ru/']"
                      ));
        menuElement.forEach(menuElements->{WebElement element = driver.findElement(By.xpath(menuElements));
        Assertions.assertTrue(element.isDisplayed());});

    }

    @Test
    @DisplayName("Проверка прогноза погоды в Москве")
    public void testCase4() {
        driver.get(URLMAIL);
        driver.findElement(By.name("clb1283825")).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath("//input[@name='name']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Москва");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Keys.ENTER);
        Assertions.assertTrue(driver.findElement(By.xpath("//h1[@class='information__header__left__place__city'][contains(text(),'Москве')]")).isDisplayed());
    }

    @Test
    @DisplayName("Проверка корректности названий новостных разделов")
    public void testCase5() {
        driver.get(URLMAIL);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@data-testid='news-tabs']//a")); // получаю элементы меню
        List<String> menuElements = new ArrayList<>(Arrays.asList("Новости","Спорт","Леди","Авто","Кино","Hi-Tech","Игры","Дети","Здоровье","Дом","Питомцы")); //их названия
        Assertions.assertEquals(elements.size(),menuElements.size());
        int i=0;
        for (WebElement el:elements) {
            Assertions.assertEquals(el.getText(), menuElements.get(i++));
        }
    }

    @Test
    @DisplayName("Проверка корректности отображения раздела Почта")
    public void testCase6() {
        driver.get(URLMAIL);
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@id='mailbox']")).isDisplayed()); //div для оъектов почт
        Assertions.assertTrue(driver.findElement(By.xpath("//input[@name='login']")).isDisplayed()); //поле ввода ящика
        Assertions.assertEquals("Имя ящика",driver.findElement(By.xpath("//input[@name='login']")).getAttribute("placeholder")); //плейсхолдер поле ввода ящика
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='domain-text__wrapper svelte-1eyrl7y']")).isDisplayed()); //выбор домена
        Select select = new Select(driver.findElement(By.xpath("//select[@name='domain']"))); //проверка элементов выбора домена
        String values = "@mail.ru"+"\n"+"@inbox.ru"+"\n"+"@list.ru"+"\n"+"@bk.ru"+"\n"+"@internet.ru";
        List<WebElement> allOptions = driver.findElements(By.xpath("//select[@name='domain']"));
        for (WebElement options : allOptions) {
            Assertions.assertEquals(options.getText(),values);
            Assertions.assertEquals(options.getText().length(),values.length());
        }

        Assertions.assertTrue(driver.findElement(By.xpath("//button[@data-testid='enter-password']")).isDisplayed()); //кнопка ввести пароль

        Assertions.assertEquals("Ввести пароль",driver.findElement(By.xpath("//*[@id='mailbox']/form[1]/button[1]")).getText()); //текст кнопка ввести пароль

        Assertions.assertTrue(driver.findElement(By.xpath("//label[@data-testid='mail-remember']")).isDisplayed()); //чекбокс запомнить
        Assertions.assertEquals("Запомнить", driver.findElement(By.xpath("//label[@data-testid='mail-remember']")).getText()); //текст чекбокс запомнить
        Assertions.assertTrue(driver.findElement(By.xpath("//input[@id='saveauth']")).isSelected()); //чекбокс выбран
        Assertions.assertTrue(driver.findElement(By.xpath("//a[@data-testid='mailbox-recovery-link']")).isDisplayed()); //кнопка забыли пароль
        Assertions.assertEquals("Забыли пароль?",driver.findElement(By.xpath("//a[@data-testid='mailbox-recovery-link']")).getText()); //текст кнопка забыли пароль

        Assertions.assertTrue(driver.findElement(By.xpath("//a[@data-testid='mailbox-head-mail']")).isDisplayed()); //кнопка почта
        Assertions.assertEquals("Почта",driver.findElement(By.xpath("//a[@data-testid='mailbox-head-mail']")).getText()); //текст кнопка почта

        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id='mailbox']/div[1]/div/a[1]")).isDisplayed()); //кнопка камера
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id='mailbox']/div[1]/div/a[2]")).isDisplayed()); //кнопка облако
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id='mailbox']/div[1]/div/a[3]")).isDisplayed()); //кнопка страница


    }
}

