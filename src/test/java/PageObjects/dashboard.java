package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class dashboard {
    WebDriver driver;
    WebDriverWait wait;

//    public Dashboard(WebDriver driver) {
//        this.driver = driver;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//    }
//    *[@id="pagination-section"]/div/div/div[4]/div/div/div[2]/a[1]
//    @FindBy(xpath = "//*[@id=\"pagination-section\"]/div/div/div[4]/div/div/div[2]/a[1]")
//    WebElement Business;
//    //sandbox account ok
//    @FindBy(xpath = "/html/body/div[4]/div/div[3]/button[1]")
//    WebElement business_click;


    By businessCard = By.xpath("//*[@id=\"pagination-section\"]/div/div/div[4]/div/div/div[2]/a[1]");
    By continueBtn  = By.xpath("/html/body/div[4]/div/div[3]/button[1]");

    public dashboard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    public void setdash() {
        // Wait until redirected from login
        wait.until(ExpectedConditions.urlContains("in/user/dashboard"));


        // Click business card
        WebElement business = wait.until(
                ExpectedConditions.elementToBeClickable(businessCard)
        );
        business.click();

        // Continue button (CRITICAL FIX)
        WebElement cont = wait.until(
                ExpectedConditions.elementToBeClickable(continueBtn)
        );


        // 🔥 Force SAME TAB navigation
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].removeAttribute('target');", cont);
        cont.click();
        driver.navigate().to("https://cloud360erp.hostbooks.in/dashboard");

    }
}
