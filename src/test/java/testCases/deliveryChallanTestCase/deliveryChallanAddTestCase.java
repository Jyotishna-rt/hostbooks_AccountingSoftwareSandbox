package testCases.deliveryChallanTestCase;

import PageObjects.deliveryChallan.deliveryChallanAdd;
import baseClass.baseclass;
import org.testng.annotations.Test;


public class deliveryChallanAddTestCase extends baseclass {

    @Test(priority = 4, dependsOnMethods = "openlinks")
    public void getdeliveryadd() throws InterruptedException {
        deliveryChallanAdd dc = new deliveryChallanAdd(driver);
        dc.setDCnadd();
        dc.scrollToItemLineDetails();
        dc.deliverchallanlinitems();
}
    }