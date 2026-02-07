package testCases.deliveryChallanTestCase;

import PageObjects.deliveryChallan.deliveryChallanCopy;
import PageObjects.deliveryChallan.deliveryChallanEdit;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class deliveryChallanCopyTestCase extends baseclass {

    @Test(priority = 3, groups = "deliverychallan")
    public void getdeliverycopy() throws InterruptedException {
        deliveryChallanCopy dc = new deliveryChallanCopy(driver);
        dc.setDeliverychallancopy();
        dc.scrolllineitems();
    }
}
