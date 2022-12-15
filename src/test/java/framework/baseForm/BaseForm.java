package framework.baseForm;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

abstract public class BaseForm extends Form {

    protected static final IElementFactory elementFactory = AqualityServices.getElementFactory();

    protected BaseForm(By locator, String name) {
        super(locator, name);
    }
}
