package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Angulartab {
    WebDriver driver;
    WebDriverWait wait;


    //    By menuIcon = By.xpath("//*[@id=\"light\"]/section/div/div/div/div/app-branding-page/div/div/div[2]/div/div[2]/div[1]/a/div[2]/p[1]");
    By dashboardLink = By.xpath("//a[@href='/dashboard' and .//p[normalize-space()='Dashboard']]");


    public Angulartab(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    // Dashboard link
    //    By dashboardLink = By.xpath("//a[@href='/dashboard' and .//p[normalize-space()='Dashboard']]");

    public void openDashboardInSameTab() {

//            System.out.println(">>> Current URL: " + driver.getCurrentUrl());
//
//            // 1️⃣ Make sure we are on /main first
//            if (!driver.getCurrentUrl().contains("/main")) {
//                throw new RuntimeException("Not on /main page, current URL: " + driver.getCurrentUrl());
//            }
//
//            WebElement dash = wait.until(
//                    ExpectedConditions.elementToBeClickable(dashboardLink)
//            );
//            ((JavascriptExecutor) driver)
//                    .executeScript("arguments[0].click();", dash
//                    );
//
//            wait.until(ExpectedConditions.urlContains("dash"));
//            dash.click();


        String currentUrl = driver.getCurrentUrl();

        String newUrl = currentUrl.replace("/main", "/dashboard");

        driver.navigate().to(newUrl);
        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains("Dashboard")) {
                break;
            }
        }
        // Get all open tabs
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

// First tab = Dashboard
        String dashboardTab = iterator.next();

// Second tab = HB Accounts
        String hbAccountsTab = iterator.next();

// Close HB Accounts tab
        driver.switchTo().window(hbAccountsTab);
        driver.close();

// Switch back to Dashboard tab
        driver.switchTo().window(dashboardTab);



//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("window.location.href='https://cloud360erp.hostbooks.in/dashboard'");
////            // 2️⃣ Navigate to /dashboard in the same tab
////            driver.navigate().to("https://cloud360erp.hostbooks.in/dashboard");

        // 3️⃣ Wait for URL to confirm
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//            wait.until(ExpectedConditions.urlContains("/dashboard"));
//
//            System.out.println(">>> Successfully navigated to Dashboard: " + driver.getCurrentUrl());
    }
}







