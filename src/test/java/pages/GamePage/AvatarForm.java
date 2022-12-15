package pages.GamePage;

import aquality.selenium.elements.interfaces.*;
import framework.baseForm.BaseForm;
import framework.helpers.RandomHelper;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class AvatarForm extends BaseForm {

    public final int FORM_NUMBER = 2;

    private static final ILabel avatarFormLabel = elementFactory.getLabel(
            By.xpath("//div[contains(@class,'avatar-and-interests-page__buttons-row')]/preceding-sibling::div[contains(@class,'avatar-and-interests')]"), "AvatarFormLbl");

    private static final String INTERESTS_CHECKBOXES = "//label[contains(@for,'%s')]";
    private final ICheckBox poniesCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "ponies")), "PoniesCheckBox");
    private final ICheckBox poloCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "polo")), "PoloCheckBox");
    private final ICheckBox doughCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "dough")), "doughCheckBox");
    private final ICheckBox snailsCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "snails")), "SnailsCheckBox");
    private final ICheckBox ballsCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "balls")), "BallsCheckBox");
    private final ICheckBox postitsCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "postits")), "PostitsCheckBox");
    private final ICheckBox faucetsCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "faucets")), "FaucetsCheckBox");
    private final ICheckBox enveloppesCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "enveloppes")), "EnveloppesCheckBox");
    private final ICheckBox cablesCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "cables")), "CablesCheckBox");
    private final ICheckBox questionsCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "questions")), "QuestionsCheckBox");
    private final ICheckBox squaresCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "squares")), "SquaresCheckBox");
    private final ICheckBox purpleCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "purple")), "PurpleCheckBox");
    private final ICheckBox cottonCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "cotton")), "CottonCheckBox");
    private final ICheckBox drywallCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "drywall")), "DrywallCheckBox");
    private final ICheckBox closetsCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "closets")), "ClosetsCheckBox");
    private final ICheckBox tiresCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "tires")), "TiresCheckBox");
    private final ICheckBox windowsCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "windows")), "WindowsCheckBox");
    private final ICheckBox selectallCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "selectall")), "SelectallCheckBox");
    private final ICheckBox mulletsCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "mullets")), "MulletsCheckBox");
    private final ICheckBox cinnamonCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "cinnamon")), "CinnamonCheckBox");
    private final ICheckBox unselectAllCheckBox = elementFactory.getCheckBox(By.xpath(String.format(INTERESTS_CHECKBOXES, "unselectall")), "UnselectAllCheckBox");

    private final ILink uploadLink = elementFactory.getLink(By.xpath("//a[contains(@class,'upload-button')]"), "Upload");
    private final IButton nextButton = elementFactory.getButton(By.xpath("//button[contains(@class,'button--stroked')]"), "NextBtn");
    private final ILabel avatarImageLabel = elementFactory.getLabel(By.xpath("//div[contains(@class,'avatar-image')]"), "AvatarImage");

    protected AvatarForm() {
        super(avatarFormLabel.getLocator(), "AvatarForm");
    }

    public void clickUnselectAll() {
        unselectAllCheckBox.click();
    }

    public void clickUpload() {
        uploadLink.click();
    }

    public void clickNextBtn() {
        nextButton.clickAndWait();
    }

    public boolean isAvatarImagePresent() {
        return avatarImageLabel.state().isExist();
    }

    public void clickRandomInterestsCheckBoxes(int count) {

        List<ICheckBox> interestsCheckBoxes = new ArrayList<>();
        interestsCheckBoxes.add(poniesCheckBox);
        interestsCheckBoxes.add(poloCheckBox);
        interestsCheckBoxes.add(doughCheckBox);
        interestsCheckBoxes.add(snailsCheckBox);
        interestsCheckBoxes.add(ballsCheckBox);
        interestsCheckBoxes.add(postitsCheckBox);
        interestsCheckBoxes.add(faucetsCheckBox);
        interestsCheckBoxes.add(enveloppesCheckBox);
        interestsCheckBoxes.add(cablesCheckBox);
        interestsCheckBoxes.add(questionsCheckBox);
        interestsCheckBoxes.add(squaresCheckBox);
        interestsCheckBoxes.add(purpleCheckBox);
        interestsCheckBoxes.add(cottonCheckBox);
        interestsCheckBoxes.add(drywallCheckBox);
        interestsCheckBoxes.add(closetsCheckBox);
        interestsCheckBoxes.add(tiresCheckBox);
        interestsCheckBoxes.add(windowsCheckBox);
        interestsCheckBoxes.add(mulletsCheckBox);
        interestsCheckBoxes.add(cinnamonCheckBox);

        for (int i = 0; i < count; i++) {
            int random = RandomHelper.getRandomInt(interestsCheckBoxes.size());
            interestsCheckBoxes.get(random).click();
            interestsCheckBoxes.remove(random);
        }
    }
}
