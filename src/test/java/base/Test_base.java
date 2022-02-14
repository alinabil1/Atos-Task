package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;


public class Test_base {

    public WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver_win.exe");
            driver = new ChromeDriver();


        } else if (browser.equalsIgnoreCase("")) {
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/");
    }

    // Take screenshot when Test case fails
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                var camera = (TakesScreenshot) driver;
                File screenShot = camera.getScreenshotAs(OutputType.FILE);
                Files.move(screenShot, new File("./screenshots/" + result.getName() + ".png"));
                System.out.println("Failed");
                System.out.println(("Taking screenshot..."));
//                Helper.Take_Screenshot(driver, result.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    @AfterClass
//    public void TearDown() {
//        driver.close();
//    }

}
