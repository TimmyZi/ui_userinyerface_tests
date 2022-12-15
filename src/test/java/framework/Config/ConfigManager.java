package framework.Config;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class ConfigManager {

    private static final ISettingsFile settings = new JsonSettingsFile("settings.json");
    private static final ISettingsFile testData = new JsonSettingsFile("testData.json");

    public static String getUrl() {
        return settings.getValue("/url").toString();
    }

    public static ISettingsFile getSettings() {
        return settings;
    }

    public static ISettingsFile getTestData() {
        return testData;
    }
}
