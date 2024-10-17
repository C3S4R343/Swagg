package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(.,'Checkout')]")
    WebElement checkOutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCartPage(){
        String url = driver.getCurrentUrl();
        return url.equals("https://www.saucedemo.com/cart.html");
    }


    public  boolean getInventoryItemsCount(){
        List<WebElement> itemNames = driver.findElements(By.cssSelector("[data-test='inventory-item-name']"));

        if (itemNames.size() == 2){
            return true;
        }
        return false;

    }

    public void clickCheckOut(){
        if(checkOutButton.isDisplayed()){
            checkOutButton.click();
        }
    }


}
