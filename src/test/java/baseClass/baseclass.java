package baseClass;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utilities.browserSetup;

public class baseclass {
    public static WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setbrowser() throws IOException {
        // driver= browserSetup.setup("chrome", driver , "https://sso.hostbooks.com/");
        driver= browserSetup.setup("chrome", driver , "https://sandboxusa.hostbooks.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterTest(alwaysRun = true)
    public void tear() throws InterruptedException {
        browserSetup.teardown(driver);
        //   driver.quit();
    }
}



