package Actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static baseClass.baseclass.driver;

public class actions {

        public void scrollxy() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0);");
        }

        public void enterAutoCompleteText(WebElement autoCompleteInput, String text) {
            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", autoCompleteInput);
            // Wait until clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(autoCompleteInput));
            //  Click and send keys
            autoCompleteInput.click();
            autoCompleteInput.clear();
            autoCompleteInput.sendKeys(text);
            //  Wait for suggestion dropdown (optional)
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pn_id_211_0\"]")));
            //Press arrow down + enter to select the first suggestion (if required)
            autoCompleteInput.sendKeys(Keys.ARROW_DOWN);
            autoCompleteInput.sendKeys(Keys.ENTER);}


    }



