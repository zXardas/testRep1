import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, Exception {
System.setProperty("webdriver.chrome.driver","P:\\gamedev\\Тестирование\\Java\\HW3_webcore\\src\\main\\resources\\chromedriver\\chromedriver.exe");
        Random r = new Random();
        String s = "user"+r.nextInt(100000000);
        int number = r.nextInt();
WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).click();
        driver.findElement(By.id("prependedInput")).sendKeys("user");
        driver.findElement(By.id("prependedInput2")).click();
        driver.findElement(By.id("prependedInput2")).sendKeys("1234");
        driver.findElement(By.id("_submit")).click();
        if (!driver.getTitle().equals("Панель инструментов")) throw new Exception("Title страницы не совпадает с заданным в тесткейс") ;

        //System.out.println(driver.getTitle().equals("Панель инструментов"));
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/a/span")).click();
        driver.findElement(By.xpath("//div[@class='main-menu-top']//a[@href='/project/my']")).click();
        driver.findElement(By.xpath("//div[@id='main']//a[@href='/project/create/']")).click();
        driver.findElement(By.name("crm_project[name]")).click();
        driver.findElement(By.name("crm_project[name]")).sendKeys(s);
        driver.findElement(By.xpath("//a[@class='select2-choice select2-default']")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("1234");
        Thread.sleep(5000L);
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);
        Select select = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.name("crm_project[curator]")));
        select.selectByValue("115");
        select = new Select(driver.findElement(By.name("crm_project[rp]")));
        select.selectByValue("115");
        select = new Select(driver.findElement(By.name("crm_project[manager]")));
        select.selectByValue("115");
        driver.findElement(By.xpath("//div[@class='select2-container select2']")).click();
        Thread.sleep(5000L);
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        Thread.sleep(5000L);
        driver.findElement(By.xpath("//*[@id='flash-messages']/div/div/div/div"));
        driver.findElement(By.xpath("//*[@id='breadcrumb']/ul/li[2][contains(text(),'Все проекты')]"));
        System.out.println("Тест -кейс CRM1 выполнен, запуск теста CRM2 ");

        driver.quit();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).click();
        driver.findElement(By.id("prependedInput")).sendKeys("user");
        driver.findElement(By.id("prependedInput2")).click();
        driver.findElement(By.id("prependedInput2")).sendKeys("1234");
        driver.findElement(By.id("_submit")).click();
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/a/span")).click();
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/ul/li[5]/a/span")).click();
        driver.findElement(By.xpath("//*[@id='breadcrumb']/ul/li[2][contains(text(),'Контактные лица')]"));
        driver.findElement(By.className("oro-datagrid"));
        driver.findElement(By.xpath("//*[@id='container']/div[1]/div/div/div[2]/div/div/a")).click();
        Thread.sleep(2000);
        if (!driver.getTitle().contains("Создать контактное лицо")) throw new Exception("Title страницы не совпадает с заданным в тесткейс") ;
        driver.findElement(By.name("crm_contact[lastName]")).click();
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys(s);
        driver.findElement(By.name("crm_contact[firstName]")).click();
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys(s);

        driver.findElement(By.xpath("//a[@class='select2-choice select2-default']")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("1234");
        Thread.sleep(5000L);
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("crm_contact[jobTitle]")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys(s);

        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        driver.findElement(By.xpath("//*[@id='flash-messages']/div/div/div/div"));

        driver.quit();
        System.out.println("Тест -кейс CRM2 выполнен, запуск пользовательских тестов ");

        System.out.println("проверка наличия новостных рзделов");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://mail.ru");
        driver.findElement(By.xpath("//a[@href='//news.mail.ru/']"));
        driver.findElement(By.xpath("//a[@href='//sportmail.ru/']"));
        driver.findElement(By.xpath("//a[@href='//lady.mail.ru/']"));
        driver.findElement(By.xpath("//a[@href='//auto.mail.ru/']"));
        driver.findElement(By.xpath("//a[@href='//kino.mail.ru/']"));
        driver.findElement(By.xpath("//a[@href='//hi-tech.mail.ru/']"));
        driver.findElement(By.xpath("//a[@href='//games.mail.ru/pc/']"));
        driver.findElement(By.xpath("//a[@href='//deti.mail.ru/']"));
        driver.findElement(By.xpath("//a[@href='//health.mail.ru/']"));
        driver.findElement(By.xpath("//a[@href='//dom.mail.ru/?fromprefix=1']"));
        driver.findElement(By.xpath("//a[@href='//pets.mail.ru/']"));
        driver.quit();
        System.out.println("Тест -кейс наличия новостных разделов выполнн ");

        System.out.println("Тест-кейс проверка прогноза пгоды в определенном городе");

        ChromeOptions op = new ChromeOptions();
        op.addArguments("--disable-notifications");
        op.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(op);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
         driver.get("https://mail.ru");
         driver.findElement(By.name("clb1283825")).click();
        ArrayList<String>  tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath("//input[@name='name']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Москва");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//h1[@class='information__header__left__place__city'][contains(text(),'Москве')]"));
        driver.quit();
        System.out.println("Тест -кейс прогноза погоды в определенном городе выплнен ");
    }
}
