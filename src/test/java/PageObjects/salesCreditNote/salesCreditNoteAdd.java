package PageObjects.salesCreditNote;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class salesCreditNoteAdd {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    WebDriverWait extendedWait;



    public salesCreditNoteAdd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js  = (JavascriptExecutor) driver;
        extendedWait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    //saleslist
    @FindBy(xpath = "//a[@role='button'][normalize-space()='Sales']")
    WebElement saleslist;

    //salesinvoice tab
    @FindBy(xpath = "//*[@id=\"menu1\"]/div/div/div[2]/div[7]/ul/li[1]/a")
    WebElement salescreditNotetab;



    public void setSCNAdd() {
        //saleslist click
        saleslist.click();

        //add salesinvoicetab
        wait.until(ExpectedConditions.elementToBeClickable(salescreditNotetab));
        salescreditNotetab.click();


    }
}
