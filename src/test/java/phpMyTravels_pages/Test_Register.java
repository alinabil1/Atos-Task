package phpMyTravels_pages;

import base.Test_base;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import javax.mail.Message;
import java.time.LocalDateTime;
import java.util.Date;

public class Test_Register extends Test_base {
    Home_page homeObj;
    SignUp_page singUpObj;
    Login_page loginObj;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    String No = String.valueOf(timestamp.getTime());
    String firstname = "Ali";
    String lastname = "Nabil";
    String phone = "01111111111 ";
    String email = "alinabiltest+" + No + "@gmail.com";
    String password = "Ya11";

    @Test
    public void Register_Using_Valid_Data_And_Login_In_Account() {
        System.out.println(No);
        homeObj = new Home_page(driver);
        homeObj.openSignUpPage();
        singUpObj = new SignUp_page(driver);
        singUpObj.UserValidSignUp(email, password, phone, firstname, lastname);

        driver.get("https://www.phptravels.net/");
        homeObj.openLoginPage();
        loginObj = new Login_page(driver);
        loginObj.login_successfully(email, password);

//        try {
//            Message email = emailUtils.getMessagesBySubject("Signed Up Successfully", true, 5)[0];
//            String link = emailUtils.getUrlsFromMessage(email, "http").get(0);
//            driver.get(link);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            Assert.fail(e.getMessage());
//        }
    }


}











