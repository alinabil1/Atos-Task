package phpMyTravels_pages;

import base.Test_base;
import org.testng.annotations.Test;

public class Test_Register extends Test_base {
    Home_page homeObj;
    SignUp_page singUpObj;
    String firstname, lastname, phone, email, password;


    @Test
    public void Register_Using_Valid_Data() {

        homeObj = new Home_page(driver);
        homeObj.openSignUpPage();
        singUpObj = new SignUp_page(driver);
        singUpObj.SetFirstName(firstname);
        singUpObj.SetLastName(lastname);
        singUpObj.SetEmail(email);
        singUpObj.SetPhoneNumber(phone);
        singUpObj.SetPassword(password);
        singUpObj.ClickSignup();


    }


}





