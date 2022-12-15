package pages.GamePage;

import aquality.selenium.elements.interfaces.ILabel;
import framework.baseForm.BaseForm;
import org.openqa.selenium.By;

public class GamePage extends BaseForm {

    private final LoginForm loginForm = new LoginForm();
    private final AvatarForm avatarForm = new AvatarForm();
    private final HelpForm helpForm = new HelpForm();
    private final CookieForm cookieForm = new CookieForm();
    private final PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();

    private static final ILabel whiteTimerLabel = elementFactory.getLabel(By.xpath("//div[contains(@class,'timer--white')]"), "WhiteTimer");

    private final ILabel pageIndicator = elementFactory.getLabel(By.xpath("//div[contains(@class,'page-indicator')]"), "PageIndicator");

    public GamePage() {
        super(whiteTimerLabel.getLocator(), "GamePage");
    }

    public LoginForm getLoginForm() {
        return this.loginForm;
    }

    public AvatarForm getAvatarForm() {
        return this.avatarForm;
    }

    public HelpForm getHelpForm() {
        return this.helpForm;
    }

    public CookieForm getCookieForm() {
        return this.cookieForm;
    }

    public PersonalDetailsForm getPersonalDetailsForm() {
        return this.personalDetailsForm;
    }

    public String getTimerHHMM() {
        int TIMER_FORMAT_HHMM = 5;
        return whiteTimerLabel.getText().substring(0, TIMER_FORMAT_HHMM);
    }

    public boolean isTimerStartParameterCorrect() {
        String CORRECT_TIMER_START_PARAMETER = "00:00";
        return getTimerHHMM().equals(CORRECT_TIMER_START_PARAMETER);
    }

    public boolean isPresentFormNumberCorrect(int pageNumber) {
        int actualPage = Integer.parseInt(pageIndicator.getText().substring(0, 1));
        return pageNumber == actualPage;
    }
}
