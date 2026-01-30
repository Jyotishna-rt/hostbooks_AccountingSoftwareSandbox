package testCases;

import PageObjects.quoteadd;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class quoteAddTestCase extends baseclass {

    @Test(priority = 4, dependsOnMethods = "openlinks")
    public void getquoteadd() throws InterruptedException {
        quoteadd sl = new quoteadd(driver);
        sl.saleslist();
      //  sl.selectStatusByText("Goods");

       sl.setCustomerfield();
       sl.scrollToItemLineDetails();
       sl.setLineitem();
       sl.setScrolllineitemsright();
       sl.setQuoteview();

    }
}
