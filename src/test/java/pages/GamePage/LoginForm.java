package pages.GamePage;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import framework.baseForm.BaseForm;
import framework.helpers.RandomHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class LoginForm extends BaseForm {

    public final int FORM_NUMBER = 1;

    private static final ILabel loginFormLabel = elementFactory.getLabel(By.xpath("//div[contains(@class,'login-form__container')]/parent::div[contains(@class, 'login-form')]"), "LoginFormLabel");

    private static final String BOXES = "//input[contains(@placeholder,'%s')]";
    private final ITextBox passwordTextBox = elementFactory.getTextBox(By.xpath(String.format(BOXES, "Password")), "PasswordBox");
    private final ITextBox emailTextBox = elementFactory.getTextBox(By.xpath(String.format(BOXES, "email")), "EmailBox");
    private final ITextBox domainTextBox = elementFactory.getTextBox(By.xpath(String.format(BOXES, "Domain")), "DomainBox");
    private final IButton dropdownButton = elementFactory.getButton(By.xpath("//div[contains(@class,'dropdown--gray')]"), "DropdownBtn");
    private final IButton nextButton = elementFactory.getButton(By.xpath("//a[@class='button--secondary']"), "NextBtn");
    private final ICheckBox notAcceptCheckBox = elementFactory.getCheckBox(By.xpath("//span[contains(@class,'checkbox__check')]"), "NotAcceptCheckBox");
    private final List<ILabel> dropdownElements = elementFactory.findElements(By.xpath("//div[@class='dropdown__list-item']"), ElementType.LABEL, ElementsCount.MORE_THEN_ZERO, ElementState.EXISTS_IN_ANY_STATE);

    public LoginForm() {
        super(loginFormLabel.getLocator(), "LoginForm");
    }

    public void setPassword(String password) {
        passwordTextBox.clearAndType(password);
    }

    public void setEmail(String email) {
        emailTextBox.clearAndType(email);
    }

    public void setDomain(String domain) {
        domainTextBox.clearAndType(domain);
    }

    public void clickDropdownBtn(){
        dropdownButton.clickAndWait();
    }

    public void clickNextBtn() {
        nextButton.clickAndWait();
    }

    public void clickNotAccept() {
        notAcceptCheckBox.click();
    }

    public void clickRandomDropdownElement() {
        int FIRST_ELEMENT_IN_DROPDOWN_LIST = 0;
        Actions action = new Actions(AqualityServices.getBrowser().getDriver());
        int random = RandomHelper.getRandomInt(dropdownElements.size());
        action.moveToElement(AqualityServices.getBrowser().getDriver().findElement(dropdownElements.get(FIRST_ELEMENT_IN_DROPDOWN_LIST).getLocator())).perform();
        dropdownElements.get(random).getJsActions().scrollToTheCenter();
        dropdownElements.get(random).click();
    }
}
