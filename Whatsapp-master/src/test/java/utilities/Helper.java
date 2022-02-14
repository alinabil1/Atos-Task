package utilities;

import org.openqa.selenium.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    private WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    // method to capture screenshot
    public static void Take_Screenshot(WebDriver driver, String screenshotName) {
        Path destination = Paths.get("./Screenshots", screenshotName + ".png");
        try {


            Files.createDirectories(destination.getParent());
            FileOutputStream out = new FileOutputStream(destination.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("screenshot was not generated" + e.getMessage());
        }
    }


}
