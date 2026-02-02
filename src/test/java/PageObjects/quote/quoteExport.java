package PageObjects.quote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class quoteExport {
    WebDriver driver;
    WebDriverWait wait;

    public quoteExport(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-master-transaction/hb-header-strip/div[1]/div[1]/div[3]/hb-button[5]/button")
    WebElement quotexportbtn;


}
