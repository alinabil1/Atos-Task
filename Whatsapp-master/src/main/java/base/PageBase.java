package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageBase {


    //======================= Parameters ==========================
    protected WebDriver driver;
    public By LanguageSelect = By.cssSelector("li.dropdown-language.nav-item.dropdown");
    public By EnglishLanguage = By.xpath("//a[@id='rtl-version'][1]");

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }


    //======================= METHODS ==========================

    public void SelectEnglishLanguage() {
        ClickBTN(LanguageSelect);
        ClickBTN(EnglishLanguage);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void get_Elements(By element) {
        driver.findElement(element);
    }

    public int get_Elements_Size(By element) {
       return driver.findElements(element).size();
    }


    public void ClickBTN(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();

    }

    public void ClearText(By element) {
        driver.findElement(element).clear();
    }

    public void SetText(By element, String Text) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        ClearText(element);
        driver.findElement(element).sendKeys(Text);
    }

    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    public void ScrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollToBottom");
    }

}
