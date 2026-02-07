package testCases.quoteTestcases;

import PageObjects.quote.quoteAccepted;
import PageObjects.quote.quoteDelete;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class quoteDeleteTestCase extends baseclass {


    @Test(priority = 5, groups = "quote")
    public void getquotedelete() {
        quoteDelete qd = new quoteDelete(driver);

        qd.setquoteDelete();
    }
}
