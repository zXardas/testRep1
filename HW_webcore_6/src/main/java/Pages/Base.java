package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;




public abstract class Base {

protected WebDriver driver;

public Base(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver,this);
}
}