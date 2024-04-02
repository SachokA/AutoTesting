package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage extends BasePage {

    private static final Logger log = LogManager.getLogger(FooterPage.class);
    @FindBy(xpath = "//a[contains(@href,'contact') or contains(text(),'contact') or contains(text(),'Контакти') ]")
    WebElement elementContact;

    @FindBy(css = "By.cssSelector('head > link[rel='icon'], head > link[rel='shortcut icon']')")
    WebElement elementFavicon;
    @FindBy(xpath = "//a[contains(@href,'privacy-policy') or contains(text(),'Політика конфіденційності') or contains(text(),'Privacy Policy')]")
    WebElement elementPrivacyPolicy;

    @FindBy(xpath = "//a[contains(@href,'terms-of-service') or contains(text(),'Умови користування веб-сайтом') or contains(text(),'Terms of Service')]")
    WebElement elementTermsOfService;

    @FindBy(xpath = "//a[contains(@href,'sitemap') or contains(text(),'Сайтмап') or contains(text(),'Sitemap')]")
    WebElement elementSiteMap;

    public FooterPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isEnabledPrivatePolicy() {
        try {
            log.info("Checking element privacy policy is displayed");
            return elementPrivacyPolicy.isDisplayed();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Private policy link is not found", e);
        }
    }

    public boolean isEnabledTermsAndConditions() {
        try {
            log.info("Checking element terms and conditions is displayed");
            return elementTermsOfService.isDisplayed();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Terms and conditions link is not found", e);
        }
    }

    public boolean isEnabledSiteMap() {
        try {
            log.info("Checking element site map is displayed");
            return elementSiteMap.isDisplayed();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Site map link is not found", e);
        }
    }

    public void clickElementContact () {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", elementContact);
    }
}
