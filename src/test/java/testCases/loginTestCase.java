package testCases;

import PageObjects.accountLogin;
import PageObjects.dashboard;
import baseClass.baseclass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static baseClass.baseclass.driver;

public class loginTestCase extends baseclass {
    @Test(priority = 1)
    public void login() {

        accountLogin aclogin = PageFactory.initElements(driver, accountLogin.class);
        aclogin.setLogin("jyotishna.rawat@hostbooks.com", "Hostbooks@123");
    }


    @Test(priority = 2)
    public void DashboardList() {
        dashboard dasbrd = PageFactory.initElements(driver, dashboard.class);
        dasbrd.setdash();

    }
}
