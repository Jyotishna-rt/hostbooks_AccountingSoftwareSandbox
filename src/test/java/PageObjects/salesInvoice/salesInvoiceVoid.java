package PageObjects.salesInvoice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class salesInvoiceVoid {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    WebDriverWait extendedWait;

    public salesInvoiceVoid(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js  = (JavascriptExecutor) driver;
        extendedWait = new WebDriverWait(driver, Duration.ofSeconds(40));

    }

    //sales invoice listing page number click
    @FindBy(xpath = "(//*[@id=\"TEXT\"])[13]")
    WebElement salesinvoicelisting;


    //challan option click
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-view-invoice/div/hb-header-strip/div[1]/div[1]/div[3]/hb-split-button[3]/div/p-splitbutton/div/button[2]")
    WebElement invoiceoptions;

    //edit btn click
    @FindBy(xpath = "//a[.//span[normalize-space()='Void']]")
    WebElement voidbtn;

    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement deleteapprove;

    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement okbtn;


    // Helper method for safe click
    private void safeClick(WebElement element, String elementName) {
        try {
            element.click();
            System.out.println("✓ " + elementName + " clicked");
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", element);
            System.out.println("✓ " + elementName + " clicked (JS)");
        }
    }


    public void setsalesinvoicevoid() {
        System.out.println("Opening invoice copy...");

        wait.until(ExpectedConditions.elementToBeClickable(salesinvoicelisting));
        safeClick(salesinvoicelisting, "Sales Invoice Listing");

        wait.until(ExpectedConditions.elementToBeClickable(invoiceoptions));
        safeClick(invoiceoptions, "Invoice Options");

        wait.until(ExpectedConditions.elementToBeClickable(voidbtn));
        safeClick(voidbtn, "Void Button");

        wait.until(ExpectedConditions.elementToBeClickable(deleteapprove));
        safeClick(deleteapprove,"Yes Button");

        wait.until(ExpectedConditions.elementToBeClickable(okbtn));
        safeClick(okbtn, " OK");

        System.out.println("✓ Invoice void sucessfully");

    }

}
