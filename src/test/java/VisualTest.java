import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VisualTest extends BaseTest {
    @Ignore
    @Test
    public void testWebsiteLayout() throws IOException {

        // Зняття знімка веб-сторінки
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        BufferedImage expectedImage = screenshot.getImage();

        // Збереження знімка як референсного зображення
        ImageIO.write(expectedImage, "PNG", new File("expected1.png"));

        // Загрузка референсного зображення
        BufferedImage actualImage = ImageIO.read(new File("expected.png"));

        // Порівняння знімків
        ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

        // Перевірка, чи немає різниць
        if (diff.hasDiff()) {
            // Якщо є різниці, збереження знімків з відзначенням різниць
            BufferedImage diffImage = diff.getMarkedImage();
            ImageIO.write(diffImage, "PNG", new File("diff.png"));
        }
    }
}
