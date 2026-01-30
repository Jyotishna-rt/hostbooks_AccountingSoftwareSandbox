package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowUtils {
    public WindowUtils(WebDriver driver) {
    }

    public static void switchToNewWindowIfPresent(WebDriver driver) {
        String currentWindow = driver.getWindowHandle();
        Set<String> allwindows = driver.getWindowHandles();

        for (String window : allwindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(currentWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(String sample) {
    }
}

