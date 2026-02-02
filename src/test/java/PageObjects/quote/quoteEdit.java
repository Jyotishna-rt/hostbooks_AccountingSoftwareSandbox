package PageObjects.quote;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class quoteEdit {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;


    public quoteEdit(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //quote select from listing page
    @FindBy(xpath = "(//*[@id=\"TEXT\"]/div/div)[5]")
    WebElement quotetxnedit;

    //quoteaccept
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-view-quote/div/hb-header-strip/div[1]/div[1]/div[3]/hb-split-button[3]/div/p-splitbutton/div/button[2]")
    WebElement quoteeditquickoptionbtn;

    //popup mark as accepted
    @FindBy(xpath = "//a[.//span[normalize-space()='Edit']]")
    WebElement quoteEditbtn;


    //all data to appear
    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[5]")
    WebElement customercode;
    //all data to appear

    @FindBy(xpath = "//*[@id=\"itemFocus\"]")
    WebElement lineitemscroll;

//    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[6]")
//    WebElement quoteeditcustomerfield;
//
//    // Specific customer field locator
//    @FindBy(xpath = "//*[@id=\"pn_id_725_1\"]")
//    WebElement quoteeditcustomerInputField;
    //scroll

    //new line item
    @FindBy(xpath = "//span[normalize-space()='Line']")
    WebElement Linebtn;

     //
    @FindBy(xpath = "//td[@data-index='1']//span[@class='px-2 d-block ng-star-inserted']")
    WebElement itemrowslectdown;

    @FindBy(xpath = "//li[@role='option' and @aria-label='Iphone 13 - Iphone 13']")
    WebElement itemselect;

//    @FindBy(xpath = "//*[@id=\"pn_id_752-table\"]/tfoot/tr/td[15]")
//    WebElement lastcolumnselect;

    @FindBy(xpath = "//button[contains(., 'Approve and Send')]")
    WebElement quotecopyapprovebtn;

    //okbtn
    @FindBy(xpath = "//button[contains(text(), 'OK')]")
    WebElement okbtn;


    public void setquoteEdit(){

        quotetxnedit.click();
        //quick options click
        wait.until(ExpectedConditions.elementToBeClickable(quoteeditquickoptionbtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", quoteeditquickoptionbtn);

        //edit click
        wait.until(ExpectedConditions.elementToBeClickable(quoteEditbtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", quoteEditbtn);



    }

//    public void quotechanges(){
//
//        wait.until(ExpectedConditions.visibilityOf(quoteeditcustomerfield));
//        quoteeditcustomerfield.click();
//        quoteeditcustomerfield.clear();
//        quoteeditcustomerfield.sendKeys(Keys.CONTROL+"a");
//        quoteeditcustomerfield.sendKeys(Keys.BACK_SPACE);
//
//        // 🔥 trigger dropdown search
//        quoteeditcustomerfield.sendKeys(" ");
//        quoteeditcustomerfield.sendKeys(Keys.BACK_SPACE);
//
//       // reopen dropdown
//        quoteeditcustomerfield.click();
//
//       //new data customer enter
//        wait.until(ExpectedConditions.visibilityOf(quoteeditcustomerInputField));
//        quoteeditcustomerInputField.click();
//     //   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", quoteeditcustomerInputField);
//
//    }

    public void scrollToItemLineDetails() {

        wait.until(ExpectedConditions.visibilityOf(customercode));

        wait.until(ExpectedConditions.visibilityOf(lineitemscroll));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", lineitemscroll);

        wait.until(ExpectedConditions.elementToBeClickable(Linebtn));
        Linebtn.click();

        // Wait a moment for the new row to be added
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(itemrowslectdown));
        // Scroll to the cell
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", itemrowslectdown);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        itemrowslectdown.click();
//        // Click the cell/span to activate the input
//        WebElement spanInCell = itemrowslectdown.findElement(By.xpath(".//span[@class='px-2 d-block ng-star-inserted'])[10]"));
//        spanInCell.click();
        // Wait for it to be clickable

        // Wait for input field to appear
        WebElement itemInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//td[@data-index='1']//input[contains(@class, 'p-autocomplete-input')]")
        ));

        // Click and type in the input
        itemInput.click();
        itemInput.sendKeys("iphone");

        // Wait for dropdown list to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[@role='option']")
        ));


        wait.until(ExpectedConditions.visibilityOf(itemselect));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", itemselect);

        WebElement itemOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[2]/td[9]/hb-input-field/div/div/span/p-inputnumber")));
        itemOption.click();

        WebElement itemdoubleclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"body\"]")));

        itemdoubleclick.click();

        // 1. Fill Unit Price for row 2
        WebElement unitPriceField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//*[@id=\"numberField\"])[3]")
        ));
        unitPriceField.click();
//        unitPriceField.clear();
//        unitPriceField.sendKeys("10000");


//        // 2. Fill Account for row 2
//        WebElement accountField = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//span[@role='combobox'  and @aria-label='52000-Sale of Goods']")
//        ));
//        accountField.click();
//        accountField.sendKeys("52000");

//
//        wait.until(ExpectedConditions.visibilityOf(itemselectdropdown));
//        JavascriptExecutor js1 = (JavascriptExecutor) driver;
//        js1.executeScript("arguments[0].scrollIntoView({block:'center'});", itemselectdropdown);

        wait.until(ExpectedConditions.visibilityOf(quotecopyapprovebtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({inline:'end', block:'nearest'});", quotecopyapprovebtn);

       // lastcolumnselect.click();
        // Scroll the page down to see the Approve button
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(quotecopyapprovebtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", quotecopyapprovebtn);
        okbtn.click();
    }

}
