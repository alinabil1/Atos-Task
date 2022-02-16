package phpMyTravels_pages;

import base.Test_base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ExcelFileManager;

import java.io.File;
import java.sql.Timestamp;
import javax.mail.Message;

public class Test_Register extends Test_base {

    private ExcelFileManager spreadSheet;
    Home_page homeObj;
    SignUp_page singUpObj;
    Login_page loginObj;
    UserAccount_Page userAccountObj;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    String No = String.valueOf(timestamp.getTime());
    String firstname, lastname, phone, email, password;


    //    @BeforeClass
//    public static void connectToEmail() {
//        try {
//            emailUtils = new EmailUtils("alinabiltest@gmail.com", "Ya123456", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
//        } catch (Exception e) {
//            e.printStackTrace();
//            Assert.fail(e.getMessage());
//        }
//    }

    @BeforeClass
    public void setUp() {
        spreadSheet = new ExcelFileManager(
                new File("src/test/resources/TestData/PhpTravels_SignUp_TestData.xlsx"));
        spreadSheet.switchToSheet("GUI");
    }

    @Test()
    public void testingValidUserSignUp() {
        firstname = spreadSheet.getCellData("FirstName", 2);
        lastname = spreadSheet.getCellData("LastName", 2);
        phone = spreadSheet.getCellData("Mobile Number", 2);
        email = spreadSheet.getCellData("Email", 2) + No + "@gmail.com";
        password = spreadSheet.getCellData("Password", 2);
        homeObj = new Home_page(driver);
        homeObj.openSignUpPage();
        singUpObj = new SignUp_page(driver);
        singUpObj.validUserSignUp(email, password, phone, firstname, lastname);
/*
                try {
            Message email = emailUtils.getMessagesBySubject("Signed Up Successfully", true, 5)[0];
            String link = emailUtils.getUrlsFromMessage(email, "http").get(0);
            driver.get(link);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
 */
        driver.get("https://www.phptravels.net/");
        homeObj.openLoginPage();
        loginObj = new Login_page(driver);
        loginObj.login_successfully(email, password);
        userAccountObj = new UserAccount_Page(driver);
        Assert.assertEquals(userAccountObj.getWelcomeMessage(),
                spreadSheet.getCellData("Expected Alert Message", 2));
    }

    @Test(dependsOnMethods = "testingValidUserSignUp")
    public void testingInvalidUserSignUp_emailAlreadyExists() throws InterruptedException {
        firstname = spreadSheet.getCellData("FirstName", 3);
        lastname = spreadSheet.getCellData("LastName", 3);
        phone = spreadSheet.getCellData("Mobile Number", 3);
        email = spreadSheet.getCellData("Email", 3) + No + "@gmail.com";
        password = spreadSheet.getCellData("Password", 3);
        homeObj = new Home_page(driver);
        homeObj.openSignUpPage();
        singUpObj = new SignUp_page(driver);
        singUpObj.invalidUserSignUp(email, password, phone, firstname, lastname);
        Thread.sleep(1000);
        String alertMessage = singUpObj.getAlertText();
        Assert.assertEquals(alertMessage, spreadSheet.getCellData("Expected Alert Message", 3),
                "No/Wrong Alert Message!;");
    }

    @Test
    public void testingInvalidUserSignup_emailWrongFormat() {
        firstname = spreadSheet.getCellData("FirstName", 4);
        lastname = spreadSheet.getCellData("LastName", 4);
        phone = spreadSheet.getCellData("Mobile Number", 4);
        email = spreadSheet.getCellData("Email", 4);
        password = spreadSheet.getCellData("Password", 4);
        homeObj = new Home_page(driver);
        homeObj.openSignUpPage();
        singUpObj = new SignUp_page(driver);
        singUpObj.invalidUserSignUp(email, password, phone, firstname, lastname);
        String alertMessage = singUpObj.getAlertText();
        Assert.assertEquals(alertMessage, spreadSheet.getCellData("Expected Alert Message", 4),
                "No/Wrong Alert Message!;");
    }

    @Test
    public void testingInvalidUserSignup_invalidFirstNameFormat() {
        String No = String.valueOf(timestamp.getTime());
        firstname = spreadSheet.getCellData("FirstName", 5);
        lastname = spreadSheet.getCellData("LastName", 5);
        phone = spreadSheet.getCellData("Mobile Number", 5);
        email = spreadSheet.getCellData("Email", 5) + No + "@gmail.com";
        password = spreadSheet.getCellData("Password", 5);
        homeObj = new Home_page(driver);
        homeObj.openSignUpPage();
        singUpObj = new SignUp_page(driver);
        singUpObj.invalidUserSignUp(email, password, phone, firstname, lastname);
        String alertMessage = singUpObj.getAlertText();
        Assert.assertEquals(alertMessage, spreadSheet.getCellData("Expected Alert Message", 5),
                "No/Wrong Alert Message!;");
    }

    @Test
    public void testingInvalidUserSignup_invalidPasswordFormat() {
        String No = String.valueOf(timestamp.getTime());
        firstname = spreadSheet.getCellData("FirstName", 6);
        lastname = spreadSheet.getCellData("LastName", 6);
        phone = spreadSheet.getCellData("Mobile Number", 6);
        email = spreadSheet.getCellData("Email", 6) + No + "@gmail.com";
        password = spreadSheet.getCellData("Password", 6);
        homeObj = new Home_page(driver);
        homeObj.openSignUpPage();
        singUpObj = new SignUp_page(driver);
        singUpObj.invalidUserSignUp(email, password, phone, firstname, lastname);
        String alertMessage = singUpObj.getAlertText();
        Assert.assertEquals(alertMessage, spreadSheet.getCellData("Expected Alert Message", 6),
                "No/Wrong Alert Message!;");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}

