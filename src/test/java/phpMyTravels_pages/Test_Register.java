package phpMyTravels_pages;

import base.Test_base;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.mail.Message;

public class Test_Register extends Test_base {
    Home_page homeObj;
    SignUp_page singUpObj;
    String firstname = "Ali";
    String lastname = "Nabil";
    String phone = "01111111111 ";
    String email = "aaaa@gmail.com";
    String password = "Ya1";


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
//        singUpObj.ClickSignup();
    }

        @Test
        public void testLinkReg() {

            //TODO: apply for a loan using criteria that will result in the application being rejected

            try{
                Message email = emailUtils.getMessagesBySubject("Signed Up Successfully", true, 5)[0];
                String link = emailUtils.getUrlsFromMessage(email, "").get(0);

                driver.get(link);

                //TODO: continue testing
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail(e.getMessage());
            }
        }


    }








