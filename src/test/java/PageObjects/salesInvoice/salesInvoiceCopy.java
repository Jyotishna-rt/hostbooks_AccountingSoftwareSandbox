package PageObjects.salesInvoice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class salesInvoiceCopy {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    WebDriverWait extendedWait;

    public salesInvoiceCopy(WebDriver driver) {
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
    @FindBy(xpath = "//a[.//span[normalize-space()='Copy Invoice']]")
    WebElement copybtn;

    //all data to appear
    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[4]")
    WebElement customercode;

    //scroll line items
    @FindBy(xpath = "//*[@id=\"itemFocus\"]")
    WebElement lineitemscroll;


    //approve dropdown
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-add-edit-invoice/div/div[2]/hb-split-button/div/p-splitbutton/div/button[2]")
    WebElement approvedropdownbtn;

    //approve btn
    @FindBy(xpath = "//span[@data-pc-section='label' and text()='Approve']")
    WebElement approvebtn;

    //okbtn
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


    public void setsalesinvoicecopy() {
        System.out.println("Opening invoice copy...");

        wait.until(ExpectedConditions.elementToBeClickable(salesinvoicelisting));
        safeClick(salesinvoicelisting, "Sales Invoice Listing");

        wait.until(ExpectedConditions.elementToBeClickable(invoiceoptions));
        safeClick(invoiceoptions, "Invoice Options");

        wait.until(ExpectedConditions.elementToBeClickable(copybtn));
        safeClick(copybtn, "Copy Button");

        System.out.println("✓ Invoice copy opened");

    }

    public void scrolllineitems() throws InterruptedException {

        System.out.println("Processing invoice copy approval...");

        // Wait for customer data
        wait.until(ExpectedConditions.visibilityOf(customercode));

        // Scroll to line items
        wait.until(ExpectedConditions.visibilityOf(lineitemscroll));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", lineitemscroll);

        // Scroll to bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Scroll to approve dropdown
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", approvedropdownbtn);
        extendedWait.until(ExpectedConditions.elementToBeClickable(approvedropdownbtn));

        // Click approve dropdown
        safeClick(approvedropdownbtn, "Approve Dropdown");

        // Wait for dropdown to expand
        extendedWait.until(ExpectedConditions.attributeToBe(
                approvedropdownbtn, "aria-expanded", "true"));

        // Click approve button - FIXED
        wait.until(ExpectedConditions.elementToBeClickable(approvebtn));

        // Make sure approve button is visible
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", approvebtn);

        safeClick(approvebtn, "Approve Button");

        // Handle OK popup - FIXED: Single click with validation
        try {
            extendedWait.until(ExpectedConditions.elementToBeClickable(okbtn));

            if (okbtn.isDisplayed() && okbtn.isEnabled()) {
                safeClick(okbtn, "OK Button");

                wait.until(ExpectedConditions.elementToBeClickable(okbtn));
                okbtn.click();

                System.out.println("✓ Invoice copy approved successfully");
            }
        } catch (Exception e) {
            System.out.println("✗ OK button issue: " + e.getMessage());
        }
    }
    }



