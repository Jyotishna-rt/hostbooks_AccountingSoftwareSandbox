package PageObjects.salesInvoice;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class salesInvoiceAdd {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    WebDriverWait extendedWait;



    public salesInvoiceAdd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js  = (JavascriptExecutor) driver;
        extendedWait = new WebDriverWait(driver, Duration.ofSeconds(40));

    }

    //invoice dropdown
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-master-transaction/hb-header-strip/div[1]/div[1]/div[3]/hb-split-button[1]/div/p-splitbutton/div/button[2]")
    WebElement salesinvoicedropdown;

    //sales
    @FindBy(xpath = "//span[normalize-space()='Sale']")
    WebElement addinvoicebtn;

    //customer select
    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[5]")
    WebElement customerfield;

    //cuustomer name select
    @FindBy(xpath = "//li[@role='option']//div[contains(text(),'FLIPKART INTERNET PRIVATE LIMITED')]")
    WebElement customer;

    //all data to appear
    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[4]")
    WebElement customercode;

    //scroll
    @FindBy(xpath = "//*[@id=\"itemFocus\"]")
    WebElement scrolllineitems;

    //item dropdown
    @FindBy(xpath = "(//input[@id='float-autoComplete'])[7]")
    WebElement lineitem;

    //item
    @FindBy(xpath = "//li[@role='option' and @aria-label='samsung galaxy pro - samsung galaxy pro']")
    WebElement item;


    //inventory popup
    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement inventoryokbtn;

    //scroll towards right
    @FindBy(xpath = "//th[text()='Total (INR)']")
    WebElement total;

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

    public void setSIAdd(){
        waitForLoaderToDisappear();

       // Click sales invoice dropdown
        safeClick(salesinvoicedropdown, "Sales Invoice Dropdown");
        extendedWait.until(ExpectedConditions.attributeToBe(salesinvoicedropdown, "aria-expanded", "true"));

        // Click add invoice button
        wait.until(ExpectedConditions.elementToBeClickable(addinvoicebtn));
        safeClick(addinvoicebtn, "Add Invoice Button");
        // Wait for page to load
        waitForLoaderToDisappear();

        // Select customer
        wait.until(ExpectedConditions.visibilityOf(customerfield));
        safeClick(customerfield, "Customer Field");

        wait.until(ExpectedConditions.elementToBeClickable(customer));
        safeClick(customer, "Customer Option");

        System.out.println("Customer selected successfully");

    }


    public void setScrolllineitems(){


        // Wait for customer data to populate
        wait.until(ExpectedConditions.visibilityOf(customercode));

        // Scroll to line items section
        wait.until(ExpectedConditions.visibilityOf(scrolllineitems));
        js.executeScript("arguments[0].scrollIntoView({block:'end'});", scrolllineitems);

        // Small pause for smooth scroll to complete
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Scrolled to line items section");
    }


    public void setLineitem(){

        waitForLoaderToDisappear();

        // Click and fill line item
        wait.until(ExpectedConditions.elementToBeClickable(lineitem));
        safeClick(lineitem, "Line Item Field");

        lineitem.clear();
        lineitem.sendKeys("samsung");
        System.out.println("Entered item search text");

        // Wait for dropdown options to appear
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Select item from dropdown
        extendedWait.until(ExpectedConditions.elementToBeClickable(item));
        safeClick(item, "Item Option");

        // Handle inventory popup (single click with proper wait)
        extendedWait.until(ExpectedConditions.elementToBeClickable(inventoryokbtn));
        safeClick(inventoryokbtn, "Inventory OK Button");

        // Wait for popup to disappear completely
        waitForModalToDisappear();
        waitForLoaderToDisappear();

        System.out.println("Inventory popup handled");

        // Scroll to total column
        js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", total);
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
                approvedropdownbtn, "aria-expanded", "true"));

        // Click approve button
        wait.until(ExpectedConditions.elementToBeClickable(approvebtn));
        safeClick(approvebtn, "Approve Button");

        // Handle final confirmation popup (FIXED: Single click with validation)
        try {
            extendedWait.until(ExpectedConditions.elementToBeClickable(okbtn));

            // Check if popup is actually visible before clicking
            if (okbtn.isDisplayed() && okbtn.isEnabled()) {
                safeClick(okbtn, "OK Button");
                System.out.println("Clicked OK button once");

                // Wait for popup to disappear
                waitForModalToDisappear();
                waitForLoaderToDisappear();
            }
        } catch (Exception e) {
            System.out.println("OK button not found or already handled: " + e.getMessage());
        }

        okbtn.click();

        System.out.println("Sales invoice creation completed successfully");
    }
}
//        extendedWait = new WebDriverWait(driver, Duration.ofSeconds(40));
//
//        wait.until(ExpectedConditions.elementToBeClickable(lineitem));
//        try {
//            lineitem.click();
//        } catch (Exception e) {
//            // Fallback to JavaScript click
//            js.executeScript("arguments[0].click();", lineitem);
//        }
//
//        lineitem.clear();
//        lineitem.sendKeys("samsung");
//
//        //item click
//        extendedWait.until(ExpectedConditions.elementToBeClickable(item));
//        // js.executeScript("arguments[0].click();", item);
//        item.click();
//
//
//        //inventory pop up
//        extendedWait.until(ExpectedConditions.elementToBeClickable(inventoryokbtn));
//        inventoryokbtn.click();
//        // **ADD THIS: Wait for the SweetAlert modal to disappear**
////        wait.until(ExpectedConditions.invisibilityOfElementLocated(
////                By.cssSelector(".swal2-container.swal2-backdrop-show")
////        ));
//
//
//        // Click GST
//        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", total);
//        extendedWait.until(ExpectedConditions.elementToBeClickable(total));
//        // Approve section
//        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", approvedropdownbtn);
//        extendedWait.until(ExpectedConditions.elementToBeClickable(approvedropdownbtn));
//        // Method 2: JavaScript click
//        boolean clicked = false;
//        if (!clicked) {
//            try {
//                js.executeScript("arguments[0].click();", approvedropdownbtn);
//                clicked = true;
//                System.out.println("Clicked approve dropdown using JS click");
//            } catch (Exception e) {
//                System.out.println("JS click failed: " + e.getMessage());
//            }
//        }
//        extendedWait.until(ExpectedConditions.attributeToBe(
//                approvedropdownbtn, "aria-expanded", "true"
//        ));
//        try {
//            approvebtn.click();
//            System.out.println("Clicked Approve using normal click");
//        } catch (Exception e) {
//            js.executeScript("arguments[0].click();", approvebtn);
//            System.out.println("Clicked Approve using JS click");
//        }
//        //popup
//        okbtn.click();
//        wait.until(ExpectedConditions.elementToBeClickable(okbtn));
//        okbtn.click();





