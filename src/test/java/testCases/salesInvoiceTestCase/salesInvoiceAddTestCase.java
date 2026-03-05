package testCases.salesInvoiceTestCase;

import PageObjects.deliveryChallan.deliveryChallanAdd;
import PageObjects.salesInvoice.salesInvoiceAdd;
import baseClass.baseclass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class salesInvoiceAddTestCase extends baseclass {
//
//    @Test(priority = 1, groups = "salesinvoice")
//    public void getsalesinvoiceadd() throws InterruptedException {
//        salesInvoiceAdd sia = new salesInvoiceAdd(driver);
//        sia.setSIAdd();
//        sia.setScrolllineitems();
//        sia.setLineitem();
//    }


    @Test(priority = 1, groups = "salesinvoice")
    public void testSalesInvoiceCreation() throws InterruptedException {

        System.out.println("Starting Sales Invoice Test");

        salesInvoiceAdd sia = new salesInvoiceAdd(driver);

        sia.setSIAdd();
        Thread.sleep(1000);

        sia.setScrolllineitems();

        sia.setLineitem();

        System.out.println("Sales Invoice Test Completed");
    }
}


