package PageObjects.salesInvoice;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class salesInvoiceEdit {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    WebDriverWait extendedWait;
    boolean clicked ;


    public salesInvoiceEdit(WebDriver driver) {
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
    @FindBy(xpath = "//a[.//span[normalize-space()='Edit']]")
    WebElement editbtn;

    //all data to appear
    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[4]")
    WebElement customercode;

    //scroll
    @FindBy(xpath = "//input[@id='itemFocus']")
    WebElement scrolllineitems;

    //new line item
    @FindBy(xpath = "//span[normalize-space()='Line']")
    WebElement Linebtn;

    //item name click it will popup dropdown
    @FindBy(xpath = "//td[@data-index='1']//input[contains(@class, 'p-autocomplete-input')]")
    WebElement itemrowslectdown;

    //item select which you want to
    @FindBy(xpath = "//li[@role='option' and @aria-label='Iphone 13 - Iphone 13']")
    WebElement itemselect;

    //inventory popup
    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement inventoryokbtn;


    //scroll towards right
    @FindBy(xpath = "//th[text()='Total (INR)']")
    WebElement gst;

    //approve dropdown
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-add-edit-invoice/div/div[2]/hb-split-button/div/p-splitbutton/div/button[2]")
    WebElement approvedropdownbtn;

    //approve btn
    @FindBy(xpath = "//span[@data-pc-section='label' and text()='Approve']")
    WebElement approvebtn;

    //okbtn
    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement okbtn;



    // Helper method to wait for loader to disappear
    private void waitForLoaderToDisappear() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.className("loader-warpper")));
        } catch (TimeoutException e) {
            System.out.println("Loader not found or already disappeared");
        }
    }



    // Helper method to wait for any modal/popup to disappear
    private void waitForModalToDisappear() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(".swal2-container.swal2-backdrop-show")));
        } catch (TimeoutException e) {
            System.out.println("Modal not found or already disappeared");
        }
    }

    // Helper method to safely click element
    private void safeClick(WebElement element, String elementName) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            System.out.println("Clicked " + elementName + " using normal click");
        } catch (Exception e) {
            try {
                js.executeScript("arguments[0].click();", element);
                System.out.println("Clicked " + elementName + " using JS click");
            } catch (Exception ex) {
                System.out.println("Failed to click " + elementName + ": " + ex.getMessage());
                throw ex;
            }
        }
    }




    public void setSIEdit(){

        System.out.println("=== Starting Sales Invoice Edit ===");

        waitForLoaderToDisappear();

        // Click on sales invoice listing
        wait.until(ExpectedConditions.elementToBeClickable(salesinvoicelisting));
        safeClick(salesinvoicelisting, "Sales Invoice Listing");

        waitForLoaderToDisappear();

        // Click invoice options dropdown
        wait.until(ExpectedConditions.elementToBeClickable(invoiceoptions));
        safeClick(invoiceoptions, "Invoice Options");

        // Click edit button
        wait.until(ExpectedConditions.elementToBeClickable(editbtn));
        safeClick(editbtn, "Edit Button");

        waitForLoaderToDisappear();

        System.out.println("✓ Sales invoice opened in edit mode");

    }


    public void setScrolllineitems(){
        // Wait for customer data to appear
        wait.until(ExpectedConditions.visibilityOf(customercode));

        // Scroll to line items section
        wait.until(ExpectedConditions.visibilityOf(scrolllineitems));
        js.executeScript("arguments[0].scrollIntoView({block:'end'});", scrolllineitems);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✓ Scrolled to line items section");
    }




    public void setLineitem() throws InterruptedException {

        System.out.println("=== Adding New Line Item ===");

        waitForLoaderToDisappear();

        // Scroll to bottom to see Line button
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click Line button to add new row
        wait.until(ExpectedConditions.elementToBeClickable(Linebtn));
        safeClick(Linebtn, "Line Button");

        System.out.println("✓ New line added, waiting for row to appear");

        try {
            Thread.sleep(1000); // Wait for new row to be created
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // **KEY FIX: Dynamically find the LAST (newly added) row's item input**
        WebElement newRowItemInput = null;
        try {
            // Find the last autocomplete input in the table (the newly added row)
            newRowItemInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("(//td[@data-index]//input[contains(@class, 'p-autocomplete-input')])[last()]")
            ));

            System.out.println("✓ Found new row item input field");

        } catch (Exception e) {
            System.out.println("✗ Could not find new row item field");
            throw e;
        }

        // Scroll to the new row item field
        js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", newRowItemInput);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click the item field to activate it
        wait.until(ExpectedConditions.elementToBeClickable(newRowItemInput));
        safeClick(newRowItemInput, "New Row Item Field");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clear and enter item name
        newRowItemInput.clear();
        newRowItemInput.sendKeys("Iphone");

        System.out.println("✓ Entered 'Iphone' in search field");

        // Wait for dropdown to appear
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//li[@role='option']")
            ));
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click the iPhone 13 option from dropdown
        WebElement iphoneOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@role='option' and @aria-label='Iphone 13 - Iphone 13']")
        ));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", iphoneOption);
        safeClick(iphoneOption, "iPhone 13 Option");

        System.out.println("✓ Selected iPhone 13 from dropdown");

        // Handle inventory popup if it appears
        try {
            wait.until(ExpectedConditions.elementToBeClickable(inventoryokbtn));
            Thread.sleep(300);
            safeClick(inventoryokbtn, "Inventory OK Button");

            waitForModalToDisappear();
            waitForLoaderToDisappear();

            System.out.println("✓ Inventory popup handled");

        } catch (TimeoutException e) {
            System.out.println("No inventory popup appeared");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Scroll table horizontally to see GST column
        try {
            WebElement scrollableTable = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector(".p-datatable-scrollable-body, .p-datatable-wrapper")
            ));
            js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollableTable);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Could not scroll table horizontally");
        }

        // Scroll to GST/Total column
        js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", gst);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Scroll to approve section
        js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", approvedropdownbtn);
        extendedWait.until(ExpectedConditions.elementToBeClickable(approvedropdownbtn));

        // Click approve dropdown
        safeClick(approvedropdownbtn, "Approve Dropdown");

        // Wait for dropdown to expand
        extendedWait.until(ExpectedConditions.attributeToBe(
                approvedropdownbtn, "aria-expanded", "true"
        ));

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click approve button
        wait.until(ExpectedConditions.elementToBeClickable(approvebtn));
        safeClick(approvebtn, "Approve Button");

        // Handle final OK popup (FIXED: Single click)
        try {
            extendedWait.until(ExpectedConditions.elementToBeClickable(okbtn));

            if (okbtn.isDisplayed() && okbtn.isEnabled()) {
                safeClick(okbtn, "OK Button");

                waitForModalToDisappear();
                waitForLoaderToDisappear();
            }
        } catch (Exception e) {
            System.out.println("OK button not found or already handled");
        }

        wait.until(ExpectedConditions.elementToBeClickable(okbtn));
        okbtn.click();
        System.out.println("=== Sales Invoice Edited Successfully ===");
    }
}
