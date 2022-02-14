package phpMyTravels_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class Home_page {
    private WebDriver driver;

    // constructor
    public Home_page(WebDriver driver) {
        this.driver = driver;
    }


    // elements
    private By signUp = By.linkText("Signup");
    private By login = By.linkText("Login");


    // methods
    public SignUp_page openSignUpPage() {
        ElementActions.Click(signUp, driver);
        return new SignUp_page(driver);
    }

    public Login_page openLoginPage() {
        ElementActions.Click(login, driver);
        return new Login_page(driver);
    }

}
