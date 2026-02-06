package testCases.deliveryChallanTestCase;

import PageObjects.deliveryChallan.deliveryChallanCopy;
import PageObjects.deliveryChallan.deliveryChallanDelete;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class deliveryChallanDeleteTestCase extends baseclass {

    @Test(priority = 7, dependsOnMethods = "getdeliverycopy")
    public void getdeliverydelete() throws InterruptedException {
        deliveryChallanDelete dd = new deliveryChallanDelete(driver);
        dd.setdeliverychaalandelete();
    }
}
