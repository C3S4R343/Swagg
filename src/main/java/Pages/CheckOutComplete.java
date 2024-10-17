package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutComplete {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(@class,'small')]")
    WebElement btnBackHome;

    @FindBy(xpath = "//h2[contains(.,'Thank you for your order!')]")
    WebElement message;

    public CheckOutComplete(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBackHome(){
        if(message.isDisplayed()){
            btnBackHome.click();
        }
    }

}
