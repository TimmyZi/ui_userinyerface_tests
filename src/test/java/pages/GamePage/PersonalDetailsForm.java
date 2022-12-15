package pages.GamePage;

import aquality.selenium.elements.interfaces.ILabel;
import framework.baseForm.BaseForm;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends BaseForm {

    public final int FORM_NUMBER = 3;

    private static final ILabel personalDetailsFormLabel = elementFactory.getLabel(By.xpath("//div[contains(@class,'personal-details__content')]"), "PersonalDetailsFormLabel");

    protected PersonalDetailsForm() {
        super(personalDetailsFormLabel.getLocator(), "PersonalDetailsForm");
    }
}
