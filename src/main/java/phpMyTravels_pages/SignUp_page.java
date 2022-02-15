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
//    private By SignUpBTN = By.className(" btn btn-default btn-lg btn-block effect ladda-button waves-effect");

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

//    public Login_page ClickSignup() {
//        ElementActions.ScrollIntoView(SignUpBTN,driver);
//        ElementActions.Click(SignUpBTN, driver);
//        return new Login_page(driver);
//    }


    public void UserValidSignUp(String email,String password,String phone,String firstname,String lastname){
        SetFirstName(firstname);
        SetLastName(lastname);
        SetEmail(email);
        SetPhoneNumber(phone);
        SetPassword(password);
        ElementActions.ClickKeyboardKey(driver,Password,Keys.ENTER);
    }

    public void InvalidUserSignUp(String email,String password,String phone,String firstname,String lastname){
        SetFirstName(firstname);
        SetLastName(lastname);
        SetEmail(email);
        SetPhoneNumber(phone);
        SetPassword(password);
        ElementActions.ClickKeyboardKey(driver,Password,Keys.ENTER);
    }

}
