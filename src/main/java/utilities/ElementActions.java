package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {
    private WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }


    public static void Click(By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public static void ClearText(By element, WebDriver driver) {
        driver.findElement(element).clear();
    }

    public static void SetText(By element, String Text, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        ClearText(element, driver);
        driver.findElement(element).sendKeys(Text);
    }

    public static String getText(By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    public static void ScrollToBottom(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollToBottom");
    }

    public static void ScrollIntoView(By element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void ClickKeyboardKey(WebDriver driver, By element, Keys key) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        driver.findElement(element).sendKeys(key);
    }

}
