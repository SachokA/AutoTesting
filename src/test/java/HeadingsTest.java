import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HeadingsTest extends BaseTest {
    @Feature("Sequential Headings Order")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify is Sequential Headings Order")
    @Test
    public void testSequentialHeadingsOrder() {
        HomePage homePage = new HomePage();
        boolean headingsInOrder = homePage.areHeadingsInSequentialOrder();
        System.out.println(homePage.getListH());
        Assert.assertTrue(headingsInOrder, "Headings are not in sequential order.");
    }
}
