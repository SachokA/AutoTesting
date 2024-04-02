package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage {
//    @FindBy(xpath = "//h2[@class='contact-form__title']")
    @FindBy(xpath = "//h1")
    WebElement elementTitleContactUs;

    public ContactUsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getTitleContactUs() {
        return elementTitleContactUs.getText();
    }
}
