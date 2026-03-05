package testCases.salesInvoiceTestCase;

import PageObjects.salesInvoice.salesInvoiceAdd;
import PageObjects.salesInvoice.salesInvoiceEdit;
import baseClass.baseclass;
import org.testng.annotations.Test;


public class salesInvoiceEditTestCase extends baseclass {
    @Test(priority = 2, groups = "salesinvoice")
    public void getsalesinvoiceedit() throws InterruptedException {
        System.out.println("Starting Sales Invoice Test");

        salesInvoiceEdit sie = new salesInvoiceEdit(driver);
        sie.setSIEdit();
        sie.setScrolllineitems();
        sie.setLineitem();
        System.out.println("Sales Invoice Test Completed");

    }

}
