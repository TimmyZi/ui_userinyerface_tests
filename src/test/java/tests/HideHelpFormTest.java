package tests;

import framework.Config.ConfigManager;
import pages.GamePage.GamePage;
import pages.HomePage;
import framework.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HideHelpFormTest extends BaseTest {

    @Test
    public void hideHelpFormTest() {
        browser.goTo(ConfigManager.getUrl());
        browser.waitForPageToLoad();
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().isDisplayed(), "HomePage is not open");

        homePage.clickStartLink();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().isDisplayed(), "GamePage is not open");
        gamePage.getHelpForm().clickSendToBottomBtn();
        gamePage.getHelpForm().waitForHideHelpForm();
        Assert.assertTrue(gamePage.getHelpForm().isHelpFormHidden(), "Help Form is not hidden");
    }
}
