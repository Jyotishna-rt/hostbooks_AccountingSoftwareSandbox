package testCases.salesInvoiceTestCase;

import PageObjects.salesInvoice.salesInvoiceDelete;
import PageObjects.salesInvoice.salesInvoiceVoid;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class salesInvoiceDeleteTestCase extends baseclass {


    @Test(priority = 5, groups = "salesinvoice")
    public void getsalesinvoicedelete() throws InterruptedException {

        System.out.println("Starting Sales Invoice Test");

        salesInvoiceDelete sid = new salesInvoiceDelete(driver);
        sid.setsalesinvoicevoid();

        System.out.println("Sales Invoice Test Completed");

    }
    }
