package phpMyTravels_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class SignUp_page {
    private WebDriver driver;

    public SignUp_page(WebDriver driver) {
        this.driver = driver;
    }

    // Locators (Element Identification)
    private By firstName = By.name("first_name");
    private By lastName = By.name("last_name");
    private By phone = By.name("phone");
    private By email = By.name("email");
    private By Password = By.name("password");
    private By alert_text = By.xpath("//div[contains(@class, 'alert')]");


    // methods
    public void SetFirstName(String first_Name) {
        ElementActions.SetText(firstName, first_Name, driver);
    }

    public void SetLastName(String last_Name) {
        ElementActions.SetText(lastName, last_Name, driver);
    }

    public void SetPhoneNumber(String phone_number) {
        ElementActions.SetText(phone, phone_number, driver);
    }

    public void SetEmail(String Email_address) {
        ElementActions.SetText(email, Email_address, driver);
    }

    public void SetPassword(String password) {
        ElementActions.SetText(Password, password, driver);
    }

    public String getAlertText(){
        return ElementActions.getText(alert_text,driver);
    }

    public Login_page validUserSignUp(String email,String password,String phone,String firstname,String lastname){
        SetFirstName(firstname);
        SetLastName(lastname);
        SetEmail(email);
        SetPhoneNumber(phone);
        SetPassword(password);
        ElementActions.ClickKeyboardKey(driver,Password,Keys.ENTER);
        return new Login_page(driver);
    }

    public SignUp_page invalidUserSignUp(String email,String password,String phone,String firstname,String lastname){
        SetFirstName(firstname);
        SetLastName(lastname);
        SetEmail(email);
        SetPhoneNumber(phone);
        SetPassword(password);
        ElementActions.ClickKeyboardKey(driver,Password,Keys.ENTER);
        return this;
    }

}
