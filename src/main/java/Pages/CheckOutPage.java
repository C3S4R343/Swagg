package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement FisrtName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement LastName;

    @FindBy(xpath = "//input[@name='postalCode']")
    WebElement ZipCode;

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    WebElement btnContinue;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCheckOutPage(){
        String url = driver.getCurrentUrl();

        return url.equals("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void enterInformation(){
        FisrtName.sendKeys("Cesar");
        LastName.sendKeys("Gonzalez");
        ZipCode.sendKeys("37188");
        btnContinue.click();
    }

}
