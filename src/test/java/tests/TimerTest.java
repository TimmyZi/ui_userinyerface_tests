package tests;

import framework.Config.ConfigManager;
import pages.GamePage.GamePage;
import pages.HomePage;
import framework.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimerTest extends BaseTest {

    @Test
    public void timerTest() {
        browser.goTo(ConfigManager.getUrl());
        browser.waitForPageToLoad();
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().isDisplayed(), "HomePage is not open");

        homePage.clickStartLink();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().isDisplayed(), "GamePage is not open");
        Assert.assertTrue(gamePage.isTimerStartParameterCorrect(), "Timer start parameter is incorrect");
    }
}
