package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
//  public static String baseUrl = "https://liastudio.store";
//  public static String baseUrl = "https://accept.devocean.pro/";
//  public static String baseUrl = "https://ahz.vn.ua/";
  public static String baseUrl = "https://topki.devocean.pro";
//  public static String baseUrl = "https://piddubnyi.devocean.pro";
//  public static String baseUrl = "https://devocean.pro/";

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void waitWebElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

