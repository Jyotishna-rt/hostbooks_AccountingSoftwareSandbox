package PageObjects.deliveryChallan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class deliveryChallanDelete {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public deliveryChallanDelete(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js  = (JavascriptExecutor) driver;

    }
    //delete listing page number click
    @FindBy(xpath = "(//*[@id=\"TEXT\"]/div/div)[8]")
    WebElement deliverychallanlist;

    //deliveryoption
    @FindBy(xpath = "//*[@id=\"light\"]/section/div/div/div/div/app-view-delivery-challan/div/hb-header-strip/div[1]/div[1]/div[3]/hb-split-button[3]/div/p-splitbutton/div/button[2]")
    WebElement challanoptions;

    //delete btn click
    @FindBy(xpath = "//a[.//span[normalize-space()='Delete']]")
    WebElement deletebtn;

    //delete ok after popup
    @FindBy(xpath = "//*[@id=\"body\"]/div/div/div[3]/button[1]")
    WebElement okbtn;




    public void setdeliverychaalandelete(){

        deliverychallanlist.click();
        //quick options click
        wait.until(ExpectedConditions.elementToBeClickable(challanoptions));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", challanoptions);

        //delete click
        wait.until(ExpectedConditions.elementToBeClickable(deletebtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deletebtn);

        //popup for delete yes or no
        wait.until(ExpectedConditions.elementToBeClickable(okbtn));
        okbtn.click();
        //ok btn
        okbtn.click();
    }
    }
