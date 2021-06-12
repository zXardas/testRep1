package Pages;

import org.openqa.selenium.By;

public enum NavigationBarTabs {
    COUNTER_PARTIES(".//span[@class='title' and text()='Контрагенты']"),
    PROJECTS(".//span[@class='title' and text()='Проекты']"),
    PRE_SALES(".//span[@class='title' and text()='Предпродажи']"),
    EXPENSES(".//span[@class='title' and text()='Расходы']"),
   // EXPENSES("//*[@id='main-menu']/ul/li[6]/a/span"),

    PREMIUMS(".//span[@class='title' and text()='Премии']"),
    DICTIONARIES(".//span[@class='title' and text()='Справочники']"),
    REPORTS(".//span[@class='title' and text()='Отчеты']"),
    SYSTEM(".//li[@class='mobile-hide dropdown']/a/span[@class='title']"),
    HELP(".//span[@class='title' and text()='Помощь']");

    private final By by;
    NavigationBarTabs(String xpath) {this.by= By.xpath(xpath);}

    public By getBy() {return by;}
}
