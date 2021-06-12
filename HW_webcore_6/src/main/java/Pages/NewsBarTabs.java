package Pages;

import org.openqa.selenium.By;

public enum NewsBarTabs {
    NEWS("//a[@href='//news.mail.ru/']", "Новости" ),
    SPORT("//a[@href='//sportmail.ru/']", "Спорт"),
    LADY("//a[@href='//lady.mail.ru/']", "Леди"),
    AUTO("//a[@href='//auto.mail.ru/']", "Авто"),
    CINEMA("//a[@href='//kino.mail.ru/']", "Кино"),

    HITECH("//a[@href='//hi-tech.mail.ru/']", "Hi-Tech"),
    GAMES("//a[@href='//games.mail.ru/pc/']", "Игры"),
    CHILDS("//a[@href='//deti.mail.ru/']", "Дети"),
    HEALTH("//a[@href='//health.mail.ru/']", "Здоровье"),
    HOUSE("//a[@href='//dom.mail.ru/?fromprefix=1']", "Дом"),
    PETS("//a[@href='//pets.mail.ru/']", "Питомцы");

    private final By by;
    private final String name;

    NewsBarTabs(String xpath, String name) {this.by= By.xpath(xpath); this.name=name;}

    public By getBy() {return by;}

    public String getName() {return name;}
}