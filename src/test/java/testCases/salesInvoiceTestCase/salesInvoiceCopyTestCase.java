package testCases.salesInvoiceTestCase;

import PageObjects.salesInvoice.salesInvoiceCopy;
import PageObjects.salesInvoice.salesInvoiceEdit;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class salesInvoiceCopyTestCase  extends baseclass {

    @Test(priority = 3, groups = "salesinvoice")
    public void getsalesinvoicecopy() throws InterruptedException {

        System.out.println("Starting Sales Invoice Test");

       salesInvoiceCopy sic = new salesInvoiceCopy(driver);
       sic.setsalesinvoicecopy();
       sic.scrolllineitems();

        System.out.println("Sales Invoice Test Completed");

    }
}
