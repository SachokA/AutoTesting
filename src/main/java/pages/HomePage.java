package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class HomePage extends BasePage {
    private static final Logger log = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//input[@type='search']")
    WebElement inputSearch;
    @FindBy(tagName = "a")
    List<WebElement> listLinks;

    @FindBy(tagName = "h1")
    List<WebElement> elementsH1;
    @FindBy(xpath = "//h1 | //h2 | //h3 | //h4 | //h5 | //h6")
    List<WebElement> elementsH;
    @FindBy(tagName = "img")
    List<WebElement> listElementImages;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isUrlsContainedLoremIpsum(Set<String> urls) {
        boolean foundLoremIpsum = false;

        for (String link : urls) {

            getDriver().get(link);
            if (getDriver().getPageSource().contains("Lorem Ipsum")) {
                System.out.println("Слова 'Lorem Ipsum' знайдено на сторінці: " + link);
                foundLoremIpsum = true;
            }
        }
        return foundLoremIpsum;
    }
    public boolean isLoremIpsumPresent() {
        return getDriver().getPageSource().contains("Lorem Ipsum");
    }

    public Set<String> getAllPageUrls() {
        log.info("Get all urls from home page");
        String baseUrlRegex = baseUrl + "(?!.*add-to-cart)(?!.*blog-post-)\\S+/?$";
        Set<String> allUrls = new HashSet<>();
        List<WebElement> allLinks = listLinks;
        for (WebElement link : allLinks) {
            String url = link.getAttribute("href");
            if (url != null && url.matches(baseUrlRegex)) {
                url = url.replaceAll("/$", "");
                allUrls.add(url);
            }
        }
        return allUrls;
    }

    public int getCountH1inThePage() {
        log.info("Count element H1 on the page");
        return elementsH1.size();
    }

    public boolean isEnabledInputSearchOnHomePage() {
        try {
            log.info("Checking the input field is enabled on the home page");
            return inputSearch.isEnabled();
        } catch (NoSuchElementException e) {
            // Відловлюємо випадок, коли елемент не знайдено
            System.out.println("Помилка: елемент inputSearch не знайдено.");
            return false;
        }
    }

    public List<String> isAltValue() {
        List<String> value = new ArrayList<>();
        log.info("Getting all value from element with attribute ALT");
        for (WebElement image : listElementImages) {
            value.add(image.getAttribute("alt"));
        }
        return value;

    }

    public boolean isImagContainsAltValue() {
        log.info("Verify all imag contain alt value ");
        boolean allImagesHaveAlt = true; // Логічний флаг, що всі зображення мають атрибут alt

        for (WebElement image : listElementImages) {
            String altText = image.getAttribute("alt");
            if (altText == null || altText.isEmpty()) {
                allImagesHaveAlt = false; // Встановлюємо флаг в false, якщо знайдено хоча б одне зображення без атрибута alt
                break; // Зупиняємо перевірку, якщо знайдено хоча б одне зображення без атрибута alt
            }
        }
        return allImagesHaveAlt; // Повертаємо результат перевірки
    }

    public void openSearchPage() {
        log.info("Open search page");
        getDriver().get(baseUrl + "?s=");
    }

    public boolean isPresentSearchPage() {
        openSearchPage();
        log.info("Input search is enabled");
        return inputSearch.isEnabled();
    }

    public void setInputSearch(String search) {
        try {
            inputSearch.sendKeys(search);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Input search is not clickable", e);
        }
    }

    public static boolean isHorizontalScrollBarPresent() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        boolean isHorizontalScrollPresent = (Boolean) js.executeScript(
                "return document.body.scrollWidth > document.body.clientWidth");
        return isHorizontalScrollPresent;
    }

    public boolean areHeadingsInSequentialOrder() {
        String lastHeading = "";
        for (WebElement heading : elementsH) {
            String currentHeading = heading.getTagName();
            if (currentHeading.compareToIgnoreCase(lastHeading) < 0) {
                System.out.println("Headings are not in sequential order: " + lastHeading + " -> " + currentHeading);
                return false;
            }
            lastHeading = currentHeading;
        }
        return true;
    }

    public List<String> getListH() {
        List<String> list = new ArrayList<>();
        for (WebElement item : elementsH) {
            list.add(item.getTagName());
        }
        return list;
    }
}




