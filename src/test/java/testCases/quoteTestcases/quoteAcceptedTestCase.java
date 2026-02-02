package testCases.quoteTestcases;

import PageObjects.quote.quoteAccepted;
import PageObjects.quote.quoteadd;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class quoteAcceptedTestCase extends baseclass {

    @Test(priority = 7, dependsOnMethods = "getquoteCopy")
    public void getquoteAccepted() throws InterruptedException {
        quoteAccepted sl = new quoteAccepted(driver);
        sl.setQuoteview();

    }
}
