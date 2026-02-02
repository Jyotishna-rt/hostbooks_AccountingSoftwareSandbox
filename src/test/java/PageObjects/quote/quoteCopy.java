package PageObjects.quote;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class quoteCopy {
    WebDriver driver;
    WebDriverWait wait;

    public quoteCopy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //quote select from listing page
    @FindBy(xpath = "(//*[@id=\"TEXT\"]/div/div)[5]")
    WebElement quotetxncopy;

    // quote quote options select
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-view-quote/div/hb-header-strip/div[1]/div[1]/div[3]/hb-split-button[3]/div/p-splitbutton/div/button[2]")
    WebElement quotecopyquoteoptions;


    //popup mark as accepted
    @FindBy(xpath = "//a[.//span[normalize-space()='Copy']]")
    WebElement markcopybtn;

    @FindBy(xpath = "//*[@id=\"textField\"]")
    WebElement quoteno;

    //all data to appear
    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[5]")
    WebElement customercode;


    //scrolldown
    @FindBy(xpath = "//*[@id=\"itemFocus\"]")
    WebElement scrolllineitems;


    @FindBy(xpath = "//button[contains(., 'Approve and Send')]")
    WebElement quotecopyapprovebtn;

    //popup for changes
//    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
//    WebElement quotepopupbtn;
//
//    //ok
    @FindBy(xpath = "//button[contains(text(), 'OK')]")
    WebElement quoteeupdatebtn;


    public void setquotecopy() {

        quotetxncopy.click();
        //quick options click
        wait.until(ExpectedConditions.elementToBeClickable(quotecopyquoteoptions));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", quotecopyquoteoptions);

        //edit click
        wait.until(ExpectedConditions.elementToBeClickable(markcopybtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", markcopybtn);

    }


    public void scrollToItemLineDetails() {

        wait.until(ExpectedConditions.visibilityOf(customercode));
        wait.until(ExpectedConditions.visibilityOf(quoteno));

        wait.until(ExpectedConditions.visibilityOf(scrolllineitems));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", scrolllineitems);

        wait.until(ExpectedConditions.visibilityOf(quotecopyapprovebtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", quotecopyapprovebtn);
        quoteeupdatebtn.click();
    }
}
