import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactUsPage;
import pages.FooterPage;
import pages.HomePage;

import java.util.Set;


public class FirstTest extends BaseTest {
    @Feature("Checks that have be done on all pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify is H1 only one on the page")
    @Test
    public void checkH1ShouldBeOneTest() {
        // Створюємо екземпляр домашньої сторінки
        HomePage homePage = new HomePage();
        SoftAssert softAssert = new SoftAssert();

        // Отримуємо список посилань на сторінки сайту
        Set<String> pageUrls = homePage.getAllPageUrls();

        // Перевіряємо кожну сторінку
        for (String url : pageUrls) {
            // Відвідуємо сторінку
            openPage(url);
            softAssert.assertEquals(homePage.getCountH1inThePage(),
                    1,
                    "Кількість тегів <h1> на сторінці " + url + " не дорівнює одному");
        }
        softAssert.assertAll();
    }

    @Test
    public void getAllUrl() {
        HomePage homePage = new HomePage();
        System.out.println(homePage.getAllPageUrls());
        System.out.println(homePage.getAllPageUrls().size());
    }


    @Test
    public void isPresentValueAttributeAltImg() {
        HomePage homePage = new HomePage();
        System.out.println(homePage.isAltValue());
        Assert.assertTrue(homePage.isImagContainsAltValue());
    }
    @Feature("Checks that have be done on all pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify isn't Loren Ipson")
    @Test()
    public void isPresentLorenIpsonTest() {
        HomePage homePage = new HomePage();
        Assert.assertFalse(homePage.isUrlsContainedLoremIpsum(homePage.getAllPageUrls()));
    }

    @Test
    public void isPresentContactUsPage() {
        FooterPage footerPage = new FooterPage();
        ContactUsPage contactUsPage = new ContactUsPage();
        footerPage.clickElementContact();

        Assert.assertEquals(contactUsPage.getTitleContactUs(),"vhvhj");
    }

    @Feature("Search page")
    @Description("Test to verify is present search page")
    @Test
    public void isPresentSearchPageTest() {
        HomePage homePage = new HomePage();
        homePage.isPresentSearchPage();
        Assert.assertTrue(homePage.isPresentSearchPage(),"Input search is not enabled on this page");
    }
    @Test
    public void checkShouldNotHaveHorizontalScrollbar () {
        HomePage homePage = new HomePage();
        Assert.assertFalse(homePage.isHorizontalScrollBarPresent());
    }

//    @Test
//    public void isEmptySearchTerm() {
//        HomePage homePage = new HomePage();
//        homePage.openSearchPage();
//        homePage.setInputSearch("hjhb");
////        Assert.assertEquals();
//    }
//
//    @Test
//    public void testHeadingOrder() {
//        List<WebElement> headers = driver.findElements(By.xpath("//h1|//h2|//h3|//h4|//h5|//h6"));
//
//        for (int i = 1; i < headers.size(); i++) {
//            WebElement previousHeader = headers.get(i - 1);
//            WebElement currentHeader = headers.get(i);
//
//            int previousLevel = Integer.parseInt(previousHeader.getTagName().substring(1));
//            int currentLevel = Integer.parseInt(currentHeader.getTagName().substring(1));
//
//            Assert.assertTrue(currentLevel > previousLevel, "Headings are not in sequential order");
//        }
    }


