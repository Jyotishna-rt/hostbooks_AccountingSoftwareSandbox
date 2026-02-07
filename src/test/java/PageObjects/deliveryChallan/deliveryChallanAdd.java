package PageObjects.deliveryChallan;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.thread.IThreadWorkerFactory;

import java.security.interfaces.XECPrivateKey;
import java.time.Duration;

public class deliveryChallanAdd {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    WebDriverWait extendedWait;



    public deliveryChallanAdd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js  = (JavascriptExecutor) driver;
        extendedWait = new WebDriverWait(driver, Duration.ofSeconds(40));

    }


    //salesordeselect
    @FindBy(xpath = "//a[@role='button'][normalize-space()='Sales']")
    WebElement saleslist;

    //delivery challan list
    @FindBy(xpath = "//*[@id=\"menu1\"]/div/div/div[2]/div[5]/ul/li[1]/a")
    WebElement deliverychallanlist;


    //deliverychallan add
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-master-transaction/hb-header-strip/div[1]/div[1]/div[3]/hb-button[3]")
    WebElement deliverychallanadd;

    //customer field
    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[5]")
    WebElement consigneeadd;

    //customername
    @FindBy(xpath = "//*[@id=\"pn_id_222_1\"]")
    WebElement customername;

    //data filled all
    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[4]")
    WebElement customercode;

    //scroll
    @FindBy(xpath = "//*[@id=\"itemFocus\"]")
    WebElement scrolllineitems;

    //item dropdown
    @FindBy(xpath = "(//input[@id='float-autoComplete'])[6]")
    WebElement lineitem;

    //item
    @FindBy(xpath = "//li[@role='option' and @aria-label='A10001 - Airpodes']")
    WebElement item;


    //inventory popup
    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement inventoryokbtn;

    //scroll towards right
    @FindBy(xpath = "//*[@id=\"pn_id_252-table\"]/tbody/tr/td[15]")
    WebElement gst;

    //approve dropdown
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-add-edit-delivery-challan/div/div[2]/div/hb-split-button/div/p-splitbutton/div/button[2]")
    WebElement approvedropdownbtn;

    //approve btn
    @FindBy(xpath = "//span[@data-pc-section='label' and text()='Approve']")
    WebElement approvebtn;

    //okbtn
    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement okbtn;



    public void setDCnadd() throws InterruptedException {
        //saleslist click
        saleslist.click();

        //add delivery challan
        wait.until(ExpectedConditions.elementToBeClickable(deliverychallanlist));
        deliverychallanlist.click();

        // **KEY FIX: Extended wait for the Add button to load**
      // Wait for page to fully load
        extendedWait.until(driver ->
                js.executeScript("return document.readyState").equals("complete")
        );
        // Wait for any loading spinners to disappear (if present)
        try {
            extendedWait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(".loading, .spinner, [class*='loading']")
            ));
        } catch (Exception e) {
            // No spinner found, continue
        }

            extendedWait.until(ExpectedConditions.elementToBeClickable(deliverychallanadd));
            deliverychallanadd.click();

            //customer add
            wait.until(ExpectedConditions.elementToBeClickable(consigneeadd));
            consigneeadd.click();
          //s  consigneeadd.sendKeys("Amazon");

        // Scroll to make dropdown visible
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", consigneeadd);
        Thread.sleep(300); // Small wait for scroll to complete


            js.executeScript("arguments[0].scrollIntoView({block:'end'});", consigneeadd);

            wait.until(ExpectedConditions.elementToBeClickable(customername));
            customername.click();
        }


    public void scrollToItemLineDetails() {
        wait.until(ExpectedConditions.visibilityOf(customercode ));
        wait.until(ExpectedConditions.visibilityOf(scrolllineitems));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'end'});", scrolllineitems);
    }


    public void deliverchallanlinitems() throws InterruptedException {

        extendedWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(lineitem));
        try {
            lineitem.click();
        } catch (Exception e) {
            // Fallback to JavaScript click
            js.executeScript("arguments[0].click();", lineitem);
        }
        lineitem.clear();
        lineitem.sendKeys("Airpodes");

        //item click
        extendedWait.until(ExpectedConditions.elementToBeClickable(item));
       // js.executeScript("arguments[0].click();", item);
        item.click();

//inventory pop up
        extendedWait.until(ExpectedConditions.elementToBeClickable(inventoryokbtn));
        inventoryokbtn.click();
        // **ADD THIS: Wait for the SweetAlert modal to disappear**
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".swal2-container.swal2-backdrop-show")
        ));


        // Click GST
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", gst);
        Thread.sleep(500);
        extendedWait.until(ExpectedConditions.elementToBeClickable(gst));
        js.executeScript("arguments[0].click();", gst);
        Thread.sleep(500);

        // Approve section
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", approvedropdownbtn);
        Thread.sleep(300);
        extendedWait.until(ExpectedConditions.elementToBeClickable(approvedropdownbtn));

        // Method 2: JavaScript click
        boolean clicked = false;
        if (!clicked) {
            try {
                js.executeScript("arguments[0].click();", approvedropdownbtn);
                clicked = true;
                System.out.println("Clicked approve dropdown using JS click");
            } catch (Exception e) {
                System.out.println("JS click failed: " + e.getMessage());
            }
        }
        extendedWait.until(ExpectedConditions.attributeToBe(
                approvedropdownbtn, "aria-expanded", "true"
        ));
        Thread.sleep(300);

        try {
            approvebtn.click();
            System.out.println("Clicked Approve using normal click");
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", approvebtn);
            System.out.println("Clicked Approve using JS click");
        }

        extendedWait.until(ExpectedConditions.elementToBeClickable(okbtn));
        okbtn.click();

        okbtn.click();
    }
    }


