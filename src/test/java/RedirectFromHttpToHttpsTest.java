import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import static pages.BasePage.getCurrentUrl;

public class RedirectFromHttpToHttpsTest extends BaseTest{
    @Test
    public void checkRedirectFromHttpToHttps () {
        openPage("http://liastudio.store");
        Assert.assertEquals(getCurrentUrl(),"https://liastudio.store/");
    }
}
