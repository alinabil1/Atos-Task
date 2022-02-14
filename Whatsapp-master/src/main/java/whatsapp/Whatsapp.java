package phpMyTravels_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class Whatsapp extends PageBase {

    public Whatsapp(WebDriver driver) {
        super(driver);
    }

    private By search_Bar = By.xpath("//div[@class='_13NKt copyable-text selectable-text']");
    private By first_Result = By.xpath("(//div[@data-testid='cell-frame-container'])");
    private By type_a_message_text = By.xpath("//div[@title='Type a message']");
    private By send_message = By.xpath("//span[@data-testid='send']");
    private By message = By.className("_22Msk");

//    Actions actions = new Actions(driver);


    public void Send_message(String phone_number, String messageBody) throws InterruptedException {

        SetText(search_Bar, phone_number);
        Thread.sleep(1000);
        ClickBTN(first_Result);
        SetText(type_a_message_text, messageBody);
        ClickBTN(send_message);
    }

    public int  Check_Number_of_messages(){
        return get_Elements_Size(message);
    }

}
