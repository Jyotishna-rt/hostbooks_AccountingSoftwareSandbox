package PageObjects.quote;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class quoteAccepted {

    WebDriver driver;
    WebDriverWait wait;

    public quoteAccepted(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //quote click view
    @FindBy(xpath = "(//*[@id=\"TEXT\"]/div/div)[5]")
    WebElement quoteview;

    //quoteaccept
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-view-quote/div/hb-header-strip/div[1]/div[1]/div[3]/hb-split-button[3]/div/p-splitbutton/div/button[2]")
    WebElement quickoptionbtn;

    //popup mark as accepted
    @FindBy(xpath = "//a[.//span[normalize-space()='Mark as Accepted']]")
    WebElement markacceptedbtn;

    //popup for changes
    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement quotepopupbtn;

    //ok
    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement quoteaccepetedbtn;

    public void setQuoteview(){
        wait.until(ExpectedConditions.elementToBeClickable(quoteview));
        quoteview.click();

//            // Wait for and click the options dropdown
        wait.until(ExpectedConditions.elementToBeClickable(quickoptionbtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", quickoptionbtn);

        //markaccepted click
        wait.until(ExpectedConditions.visibilityOf(markacceptedbtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", markacceptedbtn);

        //popup click
        wait.until(ExpectedConditions.visibilityOf(quotepopupbtn));
        quotepopupbtn.click();

        //update click
        wait.until(ExpectedConditions.elementToBeClickable(quoteaccepetedbtn));
        quoteaccepetedbtn.click();

    }
}
