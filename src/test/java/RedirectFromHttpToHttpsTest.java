import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import static pages.BasePage.*;

public class RedirectFromHttpToHttpsTest extends BaseTest{
    @Feature("Safety testing")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to check to redirect from http to https")
    @Test
    public void checkRedirectFromHttpToHttps () {
        openPage(urlWithoutS);
        Assert.assertTrue(getCurrentUrl().startsWith("https"));
    }
}
