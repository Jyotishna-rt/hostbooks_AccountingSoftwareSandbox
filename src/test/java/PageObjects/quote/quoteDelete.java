package PageObjects.quote;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class quoteDelete {

    WebDriver driver;
    WebDriverWait wait;

    public quoteDelete(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //quote select from listing page
    @FindBy(xpath = "(//*[@id=\"TEXT\"]/div/div)[5]")
    WebElement quotetxndelete;

    // quote quote options select
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-view-quote/div/hb-header-strip/div[1]/div[1]/div[3]/hb-split-button[3]/div/p-splitbutton/div/button[2]")
    WebElement quotedeletequoteoptions;


    //popup mark as accepted
    @FindBy(xpath = "//a[.//span[normalize-space()='Delete']]")
    WebElement deletebtn;

    //popup for changes
    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement quotepopupbtn;

    @FindBy(xpath = "//button[contains(text(), 'OK')]")
    WebElement quotedeletebtn;


    public void setquoteDelete(){

        quotetxndelete.click();

        wait.until(ExpectedConditions.elementToBeClickable(quotedeletequoteoptions));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", quotedeletequoteoptions);


        wait.until(ExpectedConditions.elementToBeClickable(deletebtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deletebtn);

        wait.until(ExpectedConditions.elementToBeClickable(quotepopupbtn));
        quotepopupbtn.click();
        quotedeletebtn.click();

    }
}
