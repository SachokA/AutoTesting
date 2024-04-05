import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;


public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get(BasePage.baseUrl);
        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(390, 1000));
        BasePage.setDriver(driver);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            // Get browser console logs
            LogEntries logs = driver.manage().logs().get("browser");
            for (LogEntry entry : logs) {
                System.out.println("Console log: " + entry.getMessage());
                // You can further process the log entries as needed
            }
            driver.quit();
        }
    }

//    @DataProvider(name = "urls")
//    public static Object[][] urlsProvider() {
//        return new Object[][] {
//                {"https://liastudio.store"},
//                {"https://accept.devocean.pro/"},
//                {"https://ahz.vn.ua/"},
//                {"https://topki.devocean.pro"},
//                {"https://piddubnyi.devocean.pro"}
//        };
//    }
}
