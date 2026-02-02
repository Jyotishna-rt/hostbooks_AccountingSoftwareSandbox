package testCases.quoteTestcases;

import PageObjects.quote.quoteCopy;
import PageObjects.quote.quoteadd;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class quoteCopyTestCase extends baseclass {

    @Test(priority = 6, dependsOnMethods = "getquoteEdit")
    public void getquoteCopy() throws InterruptedException {
        quoteCopy qc = new quoteCopy(driver);
        qc.setquotecopy();
        qc.scrollToItemLineDetails();
    }

}
