package pages.GamePage;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import framework.baseForm.BaseForm;
import org.openqa.selenium.By;


public class HelpForm extends BaseForm {

    private static final ILabel helpFormLabel = elementFactory.getLabel(By.xpath("//div[contains(@class,'help-form__container')]/parent::div[contains(@class,'help-form')]"), "HelpFormLbl");

    private final IButton sendToBottomButton = elementFactory.getButton(By.xpath("//button[contains(@class,'send-to-bottom')]"), "SendToBottomBtn");
    private final ILabel titleLabel = elementFactory.getLabel(By.xpath("//h2[contains(@class,'help-form__title')]"), "Title");

    protected HelpForm() {
        super(helpFormLabel.getLocator(), "HelpForm");
    }

    public void clickSendToBottomBtn() {
        sendToBottomButton.click();
    }

    public void waitForHideHelpForm() {
        AqualityServices.getConditionalWait().waitFor(this::isHelpFormHidden);
    }

    public boolean isHelpFormHidden() {
        return !titleLabel.state().isDisplayed();
    }
}
