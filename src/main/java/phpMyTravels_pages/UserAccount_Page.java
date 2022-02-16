package phpMyTravels_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;
public class UserAccount_Page {

    private WebDriver driver;

    public UserAccount_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Locators (Element Identification)
    private By WelcomeBack = By.className("author__meta");

    // methods
    public String getWelcomeMessage(){
        return ElementActions.getText(WelcomeBack,driver);
    }




}
