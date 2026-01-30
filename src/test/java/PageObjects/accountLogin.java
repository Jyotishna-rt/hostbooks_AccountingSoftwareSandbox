package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountLogin {
    WebDriver driver;
    public accountLogin(WebDriver driver) {
        this.driver = driver;
        // PageFactory for POM
    }
    @FindBy(id = "email")
    WebElement username;

    @FindBy(id = "password")
    WebElement passcode;

    @FindBy(id = "check_login")
    WebElement login;

//

    public void setLogin(String email, String password){
        username.sendKeys(email);
        passcode.sendKeys(password);
        login.click();
    }

}