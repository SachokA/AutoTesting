import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.Assert;

import org.testng.annotations.Ignore;
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

        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.getCountH1inThePage(),1,
                "Кількість тегів <h1> на сторінці  не дорівнює одному");
//        SoftAssert softAssert = new SoftAssert();
//
//        Set<String> pageUrls = homePage.getAllPageUrls();
//
//        for (String url : pageUrls) {
//
//            openPage(url);
//            softAssert.assertEquals(homePage.getCountH1inThePage(),
//                    1,
//                    "Кількість тегів <h1> на сторінці " + url + " не дорівнює одному");
//        }
//        softAssert.assertAll();
    }

    @Ignore
    @Test
    public void getAllUrl() {
        HomePage homePage = new HomePage();
        System.out.println(homePage.getAllPageUrls());
        System.out.println(homePage.getAllPageUrls().size());
    }

    @Feature("Checks that have be done on all pages")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify attribute Alt contains value")
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
        Assert.assertFalse(homePage.isLoremIpsumPresent(), "Loren Ipsum was finding on home page");
    }
    @Feature("Search page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Present contact us page and check title this page")
    @Test
    public void isPresentContactUsPage() {
        FooterPage footerPage = new FooterPage();
        ContactUsPage contactUsPage = new ContactUsPage();
        footerPage.clickElementContact();

        Assert.assertEquals(contactUsPage.getTitleContactUs(), "КОНТАКТИ");

    }

    @Feature("Search page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify is present search page")
    @Test
    public void isPresentSearchPageTest() {
        HomePage homePage = new HomePage();
        homePage.isPresentSearchPage();

        Assert.assertTrue(homePage.isPresentSearchPage(), "Input search is not enabled on this page");
    }
    @Feature("Should not have horizontal scrollbar")
    @Severity(SeverityLevel.NORMAL)
    @Description("Checks should not have horizontal scrollbar")
    @Test
    public void checkShouldNotHaveHorizontalScrollbar() {
        HomePage homePage = new HomePage();
        Assert.assertFalse(homePage.isHorizontalScrollBarPresent());
    }


}


