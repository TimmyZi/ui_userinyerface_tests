package pages.GamePage;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import framework.baseForm.BaseForm;
import org.openqa.selenium.By;

public class CookieForm extends BaseForm {

    private static final ILabel cookieFormLabel = elementFactory.getLabel(By.xpath("//div[contains(@class,'cookies')]"), "CookieFormLabel");

    private final IButton noButton = elementFactory.getButton(By.xpath("//button[contains(@class,'button--transparent')]"), "NoButton");

    protected CookieForm() {
        super(cookieFormLabel.getLocator(), "CookieForm");
    }

    public void clickNoBtn() {
        noButton.click();
    }

}
