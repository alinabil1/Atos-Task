package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.EmailUtils;
import utilities.PropertiesReader;

import java.io.File;
import java.io.IOException;


public class Test_base {

    public WebDriver driver;
    public static EmailUtils emailUtils;
    private static String propertiesFileName = "automationPractice.properties";
    private static String platformType = PropertiesReader.getProperty(propertiesFileName, "platform.type");

    @BeforeMethod
    public void setUp(@Optional("Windows") String PlatformType) {
        if (PlatformType.equalsIgnoreCase("Windows")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver_win.exe");
            driver = new ChromeDriver();
        } else if (PlatformType.equalsIgnoreCase("mac")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver_mac");
            driver = new ChromeDriver();
        } else if (PlatformType.equalsIgnoreCase("linux")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver_linux");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/");
    }



   //     Take screenshot when Test case fails
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                var camera = (TakesScreenshot) driver;
                File screenShot = camera.getScreenshotAs(OutputType.FILE);
                Files.move(screenShot, new File("./screenshots/" + result.getName() + ".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
