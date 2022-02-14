package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        ClearText(element, driver);
        driver.findElement(element).sendKeys(Text);
    }

    public static String getText(By element, WebDriver driver) {
        return driver.findElement(element).getText();
    }

    public void ScrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollToBottom");
    }

}
