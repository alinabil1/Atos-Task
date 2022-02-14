import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import phpMyTravels_pages.Whatsapp;

import java.util.concurrent.TimeUnit;

public class VerificationScript {

    static public WebDriver driver;
    static Whatsapp whats;
    static int no_of_messages;
    static int no_new_messages;
    static String phone_number = "01060864018";
    static String OTPCode = RandomString.make(4);

    private static By search_Bar = By.xpath("//div[@class='_13NKt copyable-text selectable-text']");
    private static By first_Result = By.xpath("(//div[@data-testid='cell-frame-container'])");
    private static By type_a_message_text = By.xpath("//div[@title='Type a message']");
    private static By send_message = By.xpath("//span[@data-testid='send']");
    private static By message = By.className("_22Msk");


    public static void main(String[] arg) throws InterruptedException {
        setUpChromeDriver();
        Verify();
    }

//    public static void main(String[] arg) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver_win1.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir=C:/Users/Owner/AppData/Local/Google/Chrome/User Data/Person" + 1);
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.get("https://web.whatsapp.com/");
//        whats = new SignUp_page(driver);
//        String WelcomeMessage = "مرحباً بكم في فاريانس، اذا كنت تريد تفعيل التحقق من رقم الهاتف الخاص بك من فضلك ارسل 1";
//        Send_message(phone_number, WelcomeMessage);
//        // # of messages returns the # of messages in the conversation after sending the welcome message
//        no_of_messages = whats.Check_Number_of_messages();
//        no_new_messages = no_of_messages;
//
//        /**
//         * get number of messages and keep track of any update in the number of messages.
//         * if the messages is incremented --> it means that the user replied to the message.
//         * if user replied to the message send him the OTP.
//         **/
//
//        do {
//            no_new_messages = whats.Check_Number_of_messages();
//            if (no_new_messages > no_of_messages) {
//                String OTPMessage = "رمز التحقق الخاص بك هو  " + OTPCode;
//                Send_message(phone_number, OTPMessage);
//                break;
//            }
//            Thread.sleep(1000);
//        } while (no_new_messages == no_of_messages);
//}


    public static void setUpChromeDriver() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver_win1.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("user-data-dir=C:/Users/Owner/AppData/Local/Google/Chrome/User Data/Person" + 1);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/");
    }

    /**
     * searches for a contact by phone number and then sends him a message
     *
     * @param phone_number --> contact phone number
     * @param messageBody  --> body of the message sent to the contact
     */
    public static void Send_message(String phone_number, String messageBody) throws InterruptedException {
        SetText(search_Bar, phone_number);
        Thread.sleep(1000);
        ClickBTN(first_Result);
        SetText(type_a_message_text, messageBody);
        ClickBTN(send_message);
    }

    public static void Verify() throws InterruptedException {
        // initialize Home page of whatsapp web
        whats = new Whatsapp(driver);
        String WelcomeMessage = "مرحباً بكم في فاريانس، اذا كنت تريد تفعيل التحقق من رقم الهاتف الخاص بك من فضلك ارسل 1";
        //send a welcome message to user
        Send_message(phone_number, WelcomeMessage);
        // # of messages returns the # of messages in the conversation after sending the welcome message
        no_of_messages = whats.Check_Number_of_messages();
        no_new_messages = no_of_messages;

        /**
         * get number of messages and keep track of any update in the number of messages.
         * if the messages is incremented --> it means that the user replied to the message.
         * if user replied to the message send him the OTP.
         **/

        do {
            no_new_messages = whats.Check_Number_of_messages();
            if (no_new_messages > no_of_messages) {
                String OTPMessage = "رمز التحقق الخاص بك هو  " + OTPCode;
                Send_message(phone_number, OTPMessage);
                break;
            }
            Thread.sleep(1000);
        } while (no_new_messages == no_of_messages);

    }

    public static void SetText(By element, String Text) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        ClearText(element);
        driver.findElement(element).sendKeys(Text);
    }

    public static void ClearText(By element) {
        driver.findElement(element).clear();


    }

    public static void ClickBTN(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();

    }
}
