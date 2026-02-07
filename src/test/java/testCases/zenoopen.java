package testCases;

import PageObjects.*;
import baseClass.baseclass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class zenoopen extends baseclass {

    @Test(priority = 3, groups = "login")
    public void openlinks() {
        Angulartab dasbrd = new Angulartab(driver);
        dasbrd.openDashboardInSameTab();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/dashboard"),
                "Dashboard did not open"

        );
    }

    @Test(groups = "quote")
    public void openQuote() {
        Angulartab tab = new Angulartab(driver);
        tab.openQuote();
    }

    @Test(groups = "deliverychallan")
    public void openDeliveryChallan() {
        Angulartab tab = new Angulartab(driver);
        tab.openDeliveryChallan();
    }
}


