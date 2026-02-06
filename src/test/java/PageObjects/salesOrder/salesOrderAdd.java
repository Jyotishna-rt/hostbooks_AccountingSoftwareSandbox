package PageObjects.salesOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class salesOrderAdd {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;



    public salesOrderAdd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js  = (JavascriptExecutor) driver;
    }



    //desktop
    @FindBy(xpath = "//a[@href='/dashboard']")
    WebElement desktop;

    //salesordeselect
    @FindBy(xpath = "//a[@role='button'][normalize-space()='Sales']")
    WebElement saleslist;

    @FindBy(xpath = "//div[@class='outerList ng-star-inserted']//a[@class='ng-star-inserted'][normalize-space()='Standard Order']")
    WebElement salesorderlist;

    //salesorder dropdown
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-master-transaction/hb-header-strip/div[1]/div[1]/div[3]/hb-button[3]/button/span[2]")
    WebElement salesorderaddbtn;

    @FindBy(xpath = "(//*[@id=\"float-dropdown\"])[1]")
    WebElement ordertype;


    @FindBy(xpath = "(//*[@id=\"float-dropdown\"])[2]")
    WebElement partialconvention;
    //expiry date
    @FindBy(xpath = "(//*[@id=\"float-calendar\"])[2]")
    WebElement expirydate;

    //today
    @FindBy(xpath = "//span[normalize-space()='Today']")
    WebElement datetoday;


    //customername
    @FindBy(xpath = "(//*[@id=\"float-autoComplete\"])[5]")
    WebElement customer;

    //customer select from dropdown
    @FindBy(xpath = "//li[@role='option' and @aria-label='AMAZON SELLER SERVICES PRIVATE LIMITED']")
    WebElement customerselect;

    //wait for all data to fill
    @FindBy(xpath = "//label[normalize-space()='Total Outstanding Amount']")
    WebElement Outsandingamount;

    //scrollline items

    @FindBy(xpath = "//input[@id='itemFocus']")
    WebElement scrolllineitems;

    //line items
    @FindBy(xpath = "//*[@id=\"pn_id_253-table\"]/tbody/tr/td[3]")
    WebElement itemcolumn;

    //itemselect
    @FindBy(xpath = "//span[normalize-space()='samsung galaxy pro - samsung galaxy pro']")
    WebElement itemname;








    public void setsalesorderadd(){
        desktop.click();
        wait.until(ExpectedConditions.elementToBeClickable(saleslist));
        saleslist.click();
        wait.until(ExpectedConditions.elementToBeClickable(salesorderlist));
        salesorderlist.click();
        wait.until(ExpectedConditions.visibilityOf(salesorderaddbtn));
        salesorderaddbtn.click();
        wait.until(ExpectedConditions.visibilityOf(ordertype));
        wait.until(ExpectedConditions.visibilityOf(partialconvention));
        wait.until(ExpectedConditions.elementToBeClickable(expirydate));
        expirydate.click();
        wait.until(ExpectedConditions.elementToBeClickable(datetoday));
         datetoday.click();
        wait.until(ExpectedConditions.elementToBeClickable(customer));
        js.executeScript("arguments[0].click();", customer);
        try {
            //   customer.sendKeys("AMAZON");
            WebElement customerOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@role='option' and contains(@aria-label, 'AMAZON SELLER')]")
            ));
        }catch (Exception e){
            js.executeScript("arguments[0].click();", customerselect);

        }
        wait.until(ExpectedConditions.visibilityOf(Outsandingamount));
    }


//    public void setScrolllineitems(){
//        wait.until(ExpectedConditions.visibilityOf(scrolllineitems));
//        js.executeScript("arguments[0].scrollIntoView({block:'center'});", scrolllineitems);
//    }


    public void  setlineitemsdetails(){
        wait.until(ExpectedConditions.visibilityOf(itemcolumn));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", itemcolumn);

        wait.until(ExpectedConditions.elementToBeClickable(itemname));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", itemname);


    }

    }

