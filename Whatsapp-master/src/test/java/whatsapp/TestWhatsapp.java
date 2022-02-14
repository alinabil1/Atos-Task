package phpMyTravels_pages;

import base.BaseTests;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;


public class TestWhatsapp extends BaseTests {
    Whatsapp whats;
    int no_of_elements ;
    int no_new_messages;
    String phone_number;
    String OTPCode;

    @Test
    public void ready() throws InterruptedException {
        // get parameters phone number and OTP Code
        if (phone_number == null) {
            phone_number = "01060864018";
        }
        if (OTPCode == null) {
            OTPCode = RandomString.make(4);
        }
        whats = new Whatsapp(driver);
        String WelcomeMessage = "مرحباً بكم في فاريانس، اذا كنت تريد تفعيل التحقق من رقم الهاتف الخاص بك من فضلك ارسل 1";
        whats.Send_message(phone_number, WelcomeMessage);
        no_of_elements = whats.Check_Number_of_messages();
        no_new_messages = no_of_elements;
        do {
            no_new_messages = whats.Check_Number_of_messages();
            if (no_new_messages > no_of_elements) {
                String OTPMessage = "رمز التحقق الخاص بك هو  " + OTPCode;
                whats.Send_message(phone_number, OTPMessage);
                break;
            }
            Thread.sleep(1000);
        }while (no_new_messages == no_of_elements);
    }





}
