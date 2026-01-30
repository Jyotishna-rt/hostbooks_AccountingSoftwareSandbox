package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AngularNavigationonUtil {

    public static void waitForAngular(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(d ->
                ((JavascriptExecutor) d)
                        .executeScript(
                                "return (window.getAllAngularTestabilities && " +
                                        "window.getAllAngularTestabilities().every(x => x.isStable())) || true;"
                        ).equals(true)
        );
    }

    public static void navigateSameTab(WebDriver driver, String url) {
        waitForAngular(driver);
        driver.navigate().to(url);
        waitForAngular(driver);
    }
}




