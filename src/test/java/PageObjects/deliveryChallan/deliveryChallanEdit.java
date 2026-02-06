package PageObjects.deliveryChallan;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class deliveryChallanEdit {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    WebDriverWait extendedWait;

    public deliveryChallanEdit(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js  = (JavascriptExecutor) driver;
        extendedWait = new WebDriverWait(driver, Duration.ofSeconds(40));

    }

    //delivery chllan listing page number click
    @FindBy(xpath = "(//*[@id=\"TEXT\"]/div/div)[8]")
    WebElement deliverychallanlist;

    //challan option click
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-view-delivery-challan/div/hb-header-strip/div[1]/div[1]/div[3]/hb-split-button[3]/div/p-splitbutton/div/button[2]")
    WebElement challanoptions;

    //edit btn click
    @FindBy(xpath = "//a[.//span[normalize-space()='Edit']]")
    WebElement editbtn;


    //all data to appear
    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[4]")
    WebElement customercode;
    //all data to appear


    //line item scroll
    @FindBy(xpath = "//*[@id=\"itemFocus\"]")
    WebElement lineitemscroll;



    //new line item
    @FindBy(xpath = "//span[normalize-space()='Line']")
    WebElement Linebtn;

    //item name click it will popup dropdown
    @FindBy(xpath = "//td[@data-index='1']//span[@class='px-2 d-block ng-star-inserted']")
    WebElement itemrowslectdown;

    //item select which you want to
    @FindBy(xpath = "//li[@role='option' and @aria-label='Iphone 13 - Iphone 13']")
    WebElement itemselect;

    //inventory popup
    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement inventoryokbtn;

    //unit price
    @FindBy(xpath = "(//*[@id=\"numberField\"])[3]")
    WebElement unitpricelist;

    //scroll towards right
    @FindBy(xpath = "//table[contains(@class, 'p-datatable-table')]//thead//th[16]")
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

    public void setDeliverychallanedit() {

        //listing page number click
        deliverychallanlist.click();

        //quick options click
        wait.until(ExpectedConditions.elementToBeClickable(challanoptions));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", challanoptions);

        //edit click
        wait.until(ExpectedConditions.elementToBeClickable(editbtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editbtn);

    }


    public void scrollToItemLineDetails() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(customercode));

        wait.until(ExpectedConditions.visibilityOf(lineitemscroll));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", lineitemscroll);


    }

      public void lineitemdetsils() throws InterruptedException {

        //line btn click
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

          //item sleect from dropdown
          itemrowslectdown.click();


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

//            WebElement itemOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[2]/td[9]/hb-input-field/div/div/span/p-inputnumber")));
//            itemOption.click();

          WebElement itemdoubleclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"body\"]")));

          // **IMPORTANT: Click the dropdown option to trigger auto-fill**
          try {
              itemdoubleclick.click();
              System.out.println("iPhone 13 option clicked from dropdown");
          } catch (Exception e) {
              js.executeScript("arguments[0].click();", itemdoubleclick);
              System.out.println("iPhone 13 option clicked with JS");
          }

//inventory pop up
          // **Handle inventory popup if appears**
          try {
              wait.until(ExpectedConditions.visibilityOf(inventoryokbtn));
              Thread.sleep(300);

              try {
                  inventoryokbtn.click();
                  System.out.println("Inventory popup OK clicked");
              } catch (Exception e) {
                  js.executeScript("arguments[0].click();", inventoryokbtn);
                  System.out.println("Inventory popup OK clicked with JS");
              }
              // Wait for popup to close
              Thread.sleep(800);
          } catch (Exception e) {
              System.out.println("No inventory popup appeared");
          }



          // Scroll to unit price field
          js.executeScript("arguments[0].scrollIntoView({block:'center'});", unitpricelist);
          Thread.sleep(300);
          unitpricelist.click();
          unitpricelist.clear();
          unitpricelist.sendKeys("10000");



// **CRITICAL FIX: Scroll horizontally to the right to see GST column**
          // Method 1: Find the scrollable table container and scroll right
          try {
              WebElement scrollableTable = wait.until(ExpectedConditions.presenceOfElementLocated(
                      By.cssSelector(".p-datatable-scrollable-body, .p-datatable-wrapper")
              ));

              // Scroll the table horizontally to the right
              js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollableTable);
              Thread.sleep(500);

          } catch (Exception e) {
              System.out.println("Could not find scrollable container, trying alternative method");
          }

        // **Scroll table to right**



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


