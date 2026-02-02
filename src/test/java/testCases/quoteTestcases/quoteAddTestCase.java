package testCases.quoteTestcases;

import PageObjects.quote.quoteadd;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class quoteAddTestCase extends baseclass {

    @Test(priority = 4, dependsOnMethods = "openlinks")
    public void getquoteadd() throws InterruptedException {
        quoteadd qa = new quoteadd(driver);
        qa.quotelist();
      //  sl.selectStatusByText("Goods");

       qa.setCustomerfield();
       qa.scrollToItemLineDetails();
       qa.setLineitem();
       qa.setScrolllineitemsright();
    }
}
