package PageObjects.quote;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class quoteadd {
    WebDriver driver;
    WebDriverWait wait;
    WebDriverWait extendedWait;
    JavascriptExecutor js;

    public quoteadd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js  = (JavascriptExecutor) driver;
        extendedWait = new WebDriverWait(driver, Duration.ofSeconds(40));

            }

      //sales modules
    @FindBy(linkText = "Sales")
    WebElement salesmenu;

    //quote
    @FindBy(linkText = "Quotation")
    WebElement quotationmenu;

    //add quote tab
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-master-transaction/hb-header-strip/div[1]/div[1]/div[3]/hb-button[3]/button/span[1]")
    WebElement quoteadd;


    @FindBy(xpath = "(//input[@id=\"float-calendar\"])[1]")
    WebElement quotedate;

    @FindBy(xpath = "//*[@id=\"textField\"]")
    WebElement quoteno;

    //expiry date
    @FindBy(xpath = "(//input[@id='float-calendar'])[2]")
    WebElement expirydate;

    @FindBy(xpath = "//span[normalize-space()='Today']")
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


    public void quotelist() {
        salesmenu.click();
        quotationmenu.click();
        extendedWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(quoteadd));
        quoteadd.click();

        // wait till form fully loaded
        wait.until(ExpectedConditions.visibilityOf(quotedate));

        //wait till quote no loaded
        extendedWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(quoteno));

        // click expiry date
        // NOW wait calendar open
        expirydate.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'p-datepicker')]")
        ));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", expirydate);
        wait.until(ExpectedConditions.elementToBeClickable(today));
        today.click();
    }

    public void setCustomerfield() {
        extendedWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        // Click customer dropdown
        wait.until(ExpectedConditions.elementToBeClickable(customerfield));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", customerfield);

        customerfield.click();
        wait.until(ExpectedConditions.elementToBeClickable(customerInputField));
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
        wait.until(ExpectedConditions.elementToBeClickable(okbtn));
        okbtn.click();
    }
}








