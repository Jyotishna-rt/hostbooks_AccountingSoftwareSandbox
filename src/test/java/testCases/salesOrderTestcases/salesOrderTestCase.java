package testCases.salesOrderTestcases;

import PageObjects.quote.quoteadd;
import PageObjects.salesOrder.salesOrderAdd;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class salesOrderTestCase extends baseclass {


    @Test(priority = 4, dependsOnMethods = "openlinks")
    public void getsalesorderadd() {
        salesOrderAdd soa = new salesOrderAdd(driver);
        soa.setsalesorderadd();
     //  soa.setScrolllineitems();
       soa.setlineitemsdetails();

    }
}
