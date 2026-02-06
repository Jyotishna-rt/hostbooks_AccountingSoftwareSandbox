package PageObjects.deliveryChallan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class deliveryChallanCopy {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    WebDriverWait extendedWait;

    public deliveryChallanCopy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js  = (JavascriptExecutor) driver;
        extendedWait = new WebDriverWait(driver, Duration.ofSeconds(40));

    }

    //delete lisiting page number click
    @FindBy(xpath = "(//*[@id=\"TEXT\"]/div/div)[8]")
    WebElement deliverychallanlist;

    //delivery challan option click
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-view-delivery-challan/div/hb-header-strip/div[1]/div[1]/div[3]/hb-split-button[3]/div/p-splitbutton/div/button[2]")
    WebElement challanoptions;

    //copy btn click
    @FindBy(xpath = "//a[.//span[normalize-space()='Copy']]")
    WebElement copybtn;

    //all data to appear
    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[4]")
    WebElement customercode;


    //scroll line items
    @FindBy(xpath = "//*[@id=\"itemFocus\"]")
    WebElement lineitemscroll;


    //approve dropdown
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-add-edit-delivery-challan/div/div[2]/div/hb-split-button/div/p-splitbutton/div/button[2]")
    WebElement approvedropdownbtn;

    //approve btn
    @FindBy(xpath = "//span[@data-pc-section='label' and text()='Approve']")
    WebElement approvebtn;

    //okbtn
    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement okbtn;



    public void setDeliverychallancopy() {

        deliverychallanlist.click();
        //quick options click
        wait.until(ExpectedConditions.elementToBeClickable(challanoptions));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", challanoptions);

        //edit click
        wait.until(ExpectedConditions.elementToBeClickable(copybtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", copybtn);


    }

    public void scrolllineitems() throws InterruptedException {
        //wait till all data not appear
        wait.until(ExpectedConditions.visibilityOf(customercode));

        //line item scroll
        wait.until(ExpectedConditions.visibilityOf(lineitemscroll));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", lineitemscroll);

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

        //approve button
        try {
            approvebtn.click();
            System.out.println("Clicked Approve using normal click");
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", approvebtn);
            System.out.println("Clicked Approve using JS click");
        }

        //ok btn
        extendedWait.until(ExpectedConditions.elementToBeClickable(okbtn));
        okbtn.click();

        okbtn.click();
    }
    }

