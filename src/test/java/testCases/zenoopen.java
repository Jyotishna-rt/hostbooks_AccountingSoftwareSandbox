package testCases;

import PageObjects.*;
import baseClass.baseclass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class zenoopen extends baseclass {


    //    @Test(priority = 3 , dependsOnMethods = "DashboardList")
//    public void openlinks() {
//        Angulartab dasbrd = PageFactory.initElements(driver, Angulartab.class);
//        dasbrd.openDashboardInSameTab();
//        Assert.assertTrue(
//                driver.getCurrentUrl().contains("dashboard"),
//                "Dashboard did not open"
//        );
//    }
    @Test(priority = 3, dependsOnMethods = "DashboardList")
    public void openlinks() {
        Angulartab dasbrd = new Angulartab(driver);
        dasbrd.openDashboardInSameTab();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/dashboard"),
                "Dashboard did not open"

        );
    }
}


