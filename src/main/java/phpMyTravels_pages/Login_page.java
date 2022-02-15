package phpMyTravels_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class Login_page {

    private WebDriver driver;

    public Login_page(WebDriver driver){
        this.driver=driver;
    }

    // Locators (Element Identification)
    private By email = By.name("email");
    private By password = By.name("password");

    public void SetEmail(String Email_address) {
        ElementActions.SetText(email, Email_address, driver);
    }

    public void SetPassword(String Password) {
        ElementActions.SetText(password, Password, driver);
    }

    public void login_successfully(String email,String Password){
        SetEmail(email);
        SetPassword(Password);
        ElementActions.ClickKeyboardKey(driver,password, Keys.ENTER);
    }








}
