import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FooterPage;
import pages.HomePage;

public class FooterTest extends BaseTest {
    @Feature("Footer")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify is Private Policy in home page")
    @Test
    public void isEnabledPrivatePolicyTest() {
        FooterPage footerPage = new FooterPage();
        Assert.assertTrue(footerPage.isEnabledPrivatePolicy(), "Private policy link is not enabled");
    }

    @Feature("Footer")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify is Terms And Conditions in home page")
    @Test
    public void isEnabledTermsAndConditionsTest() {
        FooterPage footerPage = new FooterPage();
        Assert.assertTrue(footerPage.isEnabledTermsAndConditions(), "Terms and conditions link is not enabled");
    }

    @Feature("Footer")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify is site map in home page")
    @Test
    public void isEnabledSiteMapTest() {
        FooterPage footerPage = new FooterPage();
        Assert.assertTrue(footerPage.isEnabledSiteMap(), "Site map link is not enabled");
    }

    @Feature("Footer")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify is present input search in home page")
    @Test
    public void isPresentSearchInputOnHomePageTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isEnabledInputSearchOnHomePage(), "Input search is not enabled");
    }
}
