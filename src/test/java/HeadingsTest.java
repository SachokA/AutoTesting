import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HeadingsTest extends BaseTest {
    @Test
    public void testSequentialHeadingsOrder() {
        HomePage homePage = new HomePage();
        boolean headingsInOrder = homePage.areHeadingsInSequentialOrder();
        System.out.println(homePage.getListH());
        Assert.assertTrue(headingsInOrder, "Headings are not in sequential order.");
    }
}
