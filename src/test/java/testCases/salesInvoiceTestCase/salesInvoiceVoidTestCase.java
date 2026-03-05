package testCases.salesInvoiceTestCase;

import PageObjects.salesInvoice.salesInvoiceCopy;
import PageObjects.salesInvoice.salesInvoiceVoid;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class salesInvoiceVoidTestCase extends baseclass {

    @Test(priority = 4, groups = "salesinvoice")
    public void getsalesinvoicevoid() throws InterruptedException {

        System.out.println("Starting Sales Invoice Test");

        salesInvoiceVoid siv = new salesInvoiceVoid(driver);
        siv.setsalesinvoicevoid();


        System.out.println("Sales Invoice Test Completed");

    }
}
