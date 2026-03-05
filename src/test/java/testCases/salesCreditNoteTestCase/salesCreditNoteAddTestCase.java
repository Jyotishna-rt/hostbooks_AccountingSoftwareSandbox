package testCases.salesCreditNoteTestCase;

import PageObjects.salesCreditNote.salesCreditNoteAdd;
import PageObjects.salesInvoice.salesInvoiceAdd;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class salesCreditNoteAddTestCase extends baseclass {

    @Test(priority = 1, groups = "salescreditnote")
    public void getsalescreditnoteadd() throws InterruptedException {
       salesCreditNoteAdd scna = new salesCreditNoteAdd(driver);
        scna.setSCNAdd();
    }

}
