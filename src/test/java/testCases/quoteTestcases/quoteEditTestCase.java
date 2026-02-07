package testCases.quoteTestcases;

import PageObjects.quote.quoteEdit;
import PageObjects.quote.quoteadd;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class quoteEditTestCase extends baseclass {


    @Test(priority = 2, groups = "quote")
    public void getquoteEdit() throws InterruptedException {
        quoteEdit qe = new quoteEdit(driver);

        qe.setquoteEdit();
       // qe.quotechanges();
        qe.scrollToItemLineDetails();

    }
}
