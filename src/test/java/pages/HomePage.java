package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import framework.baseForm.BaseForm;
import org.openqa.selenium.By;

public class HomePage extends BaseForm {

    private final static IButton startButton = elementFactory.getButton(By.xpath("//button[contains(@class,'start__button')]"), "StartButton");
    private final ILink startLink = elementFactory.getLink(By.xpath("//a[contains(@class,'start__link')]"), "StartLink");

    public HomePage() {
        super(startButton.getLocator(), "HomePage");
    }

    public void clickStartLink() {
        startLink.click();
    }
}
