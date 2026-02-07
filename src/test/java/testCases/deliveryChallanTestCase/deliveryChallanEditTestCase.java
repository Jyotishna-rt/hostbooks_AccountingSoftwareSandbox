package testCases.deliveryChallanTestCase;

import PageObjects.deliveryChallan.deliveryChallanAdd;
import PageObjects.deliveryChallan.deliveryChallanEdit;
import baseClass.baseclass;
import org.testng.annotations.Test;

public class deliveryChallanEditTestCase extends baseclass {

    @Test(priority = 2, groups = "deliverychallan")
    public void getdeliveryedit() throws InterruptedException {
        deliveryChallanEdit de = new deliveryChallanEdit(driver);
        de.setDeliverychallanedit();
        de.scrollToItemLineDetails();
        de.lineitemdetsils();
    }
}
