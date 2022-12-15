package tests;

import framework.Config.ConfigManager;
import framework.baseTest.BaseTest;
import framework.helpers.RandomHelper;
import framework.helpers.RobotHelper;
import pages.GamePage.GamePage;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CardsTest extends BaseTest {

    @Test
    public void cardsTest() {
        browser.goTo(ConfigManager.getUrl());
        browser.waitForPageToLoad();
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().isDisplayed(), "HomePage is not open");

        homePage.clickStartLink();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isPresentFormNumberCorrect(gamePage.getLoginForm().FORM_NUMBER), "Page number incorrect");

        String randomEmail = RandomHelper.getRandomString(Integer.parseInt(ConfigManager.getTestData().getValue("/emailLength").toString()));
        String randomDomain = RandomHelper.getRandomString(Integer.parseInt(ConfigManager.getTestData().getValue("/domainLength").toString()));
        String randomPassword = RandomHelper.getRandomString(
                Integer.parseInt(ConfigManager.getTestData().getValue("/passwordMinLength").toString())
                , Integer.parseInt(ConfigManager.getTestData().getValue("/capitalLetter").toString())
                , Integer.parseInt(ConfigManager.getTestData().getValue("/numeral").toString())
                , Integer.parseInt(ConfigManager.getTestData().getValue("/cyrillic").toString())
                , randomEmail);
        gamePage.getLoginForm().setPassword(randomPassword);
        gamePage.getLoginForm().setEmail(randomEmail);
        gamePage.getLoginForm().setDomain(randomDomain);
        gamePage.getLoginForm().clickDropdownBtn();
        gamePage.getLoginForm().clickRandomDropdownElement();
        gamePage.getLoginForm().clickNotAccept();
        gamePage.getLoginForm().clickNextBtn();
        Assert.assertTrue(gamePage.isPresentFormNumberCorrect(gamePage.getAvatarForm().FORM_NUMBER), "Page number incorrect");

        gamePage.getAvatarForm().clickUnselectAll();
        gamePage.getAvatarForm().clickRandomInterestsCheckBoxes(Integer.parseInt(ConfigManager.getTestData().getValue("/checkBoxesCount").toString()));
        gamePage.getAvatarForm().clickUpload();
        RobotHelper.uploadMediaByRobotForOS(ConfigManager.getSettings().getValue("/avatarPathname").toString());
        Assert.assertTrue(gamePage.getAvatarForm().isAvatarImagePresent(), "Avatar not loaded");
        gamePage.getAvatarForm().clickNextBtn();
        Assert.assertTrue(gamePage.isPresentFormNumberCorrect(gamePage.getPersonalDetailsForm().FORM_NUMBER), "Page number incorrect");
    }
}
