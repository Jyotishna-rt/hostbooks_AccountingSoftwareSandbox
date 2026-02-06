package PageObjects.quote;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class quoteadd {
    WebDriver driver;
    WebDriverWait wait;



    public quoteadd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(linkText = "Sales")
    WebElement salesmenu;

    //quote

    @FindBy(linkText = "Delivery Challans")
    WebElement quotationmenu;

    //add quote tab
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-master-transaction/hb-header-strip/div[1]/div[1]/div[3]/hb-button[3]/button/span[1]")
    WebElement quoteadd;


    //expiry date
    @FindBy(xpath = "//*[@id=\"pn_id_150_content\"]/app-invoice-fields/div/div[1]/div/div[2]/div[7]/hb-date-picker/div/span/p-calendar/span/button")
    WebElement expirydate;

    @FindBy(xpath = "//*[@id=\"pn_id_220_panel\"]/div[2]/button[1]/span")
    WebElement today;

    //customer field
    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[6]")
    WebElement customerfield;

    // Specific customer field locator
    @FindBy(xpath = "//*[@id=\"pn_id_221_3\"]")
    WebElement customerInputField;

    //scroll
    @FindBy(xpath = "//*[@id=\"itemFocus\"]")
    WebElement scrolllineitems;


    //lineitemsdetails
    //item
    @FindBy(xpath = "//*[@id=\"pn_id_248-table\"]/tbody/tr/td[3]")
    WebElement lineitem;

    @FindBy(xpath = "//li[@role='option' and @aria-label='A10001 - Airpodes']")
    WebElement item;

    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-add-edit-quote/div/div[2]/hb-button[1]/button/span")
    WebElement approvebtn;

    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement okbtn;

   /* //quote click view
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
    WebElement quoteeupdatebtn;*/

    public void quotelist() {
        salesmenu.click();
        quotationmenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(quoteadd));
        quoteadd.click();
        expirydate.click();
        today.click();
    }

    public void setCustomerfield() {
        // Click customer dropdown
        wait.until(ExpectedConditions.elementToBeClickable(customerfield));
        customerfield.click();
        customerInputField.click();


    }

    public void scrollToItemLineDetails() {
        wait.until(ExpectedConditions.visibilityOf(scrolllineitems));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", scrolllineitems);
    }


    public void setLineitem() {
        lineitem.click();
        wait.until(ExpectedConditions.visibilityOf(item));
        item.click();
        WebElement itemOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pn_id_248-table\"]/tbody/tr/td[3]")));
        itemOption.click();

    }


    public void setScrolllineitemsright() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            // Wait for account column to be present
            WebElement gstcoolumn = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//*[@id=\"pn_id_248-table\"]/thead/tr/th[14]")
                    )
            );
            // Scroll the element into view horizontally
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'nearest', inline: 'end'});", gstcoolumn);
            Thread.sleep(1000);

        } catch (Exception e) {

            throw e;

        }

        approvebtn.click();
        okbtn.click();
    }
/*
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
        wait.until(ExpectedConditions.elementToBeClickable(quoteeupdatebtn));
        quoteeupdatebtn.click();

    }*/
}








