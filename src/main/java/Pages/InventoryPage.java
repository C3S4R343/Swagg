package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {
    WebDriver driver;

    @FindBy(id="react-burger-menu-btn")
    WebElement menu;

    @FindBy(xpath = "//a[@data-test='logout-sidebar-link']")
    WebElement loggout;

    @FindBy(xpath = "//button[contains(.,'Close Menu')]")
    WebElement closeMenu;

    @FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']")
    WebElement addBackpack;

    @FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-fleece-jacket']")
    WebElement addJacket;

    @FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")
    WebElement addTshirt;

    public InventoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyUrl(){
        String url = driver.getCurrentUrl();
        return  url.equals("https://www.saucedemo.com/inventory.html");
    }

    public boolean isLogoutVisible(){
        return loggout.isEnabled();
    }

    public void openMenu(){
        menu.click();
    }

    public void CloseMenu(){
        closeMenu.click();
    }

    public boolean verifyProductNamesAndPrices(){
        // Localiza todos los elementos que contienen los nombres de los productos y su precio
        List<WebElement> productNames = driver.findElements(By.cssSelector("[data-test='inventory-item-name']"));
        List<WebElement> productPrices = driver.findElements(By.cssSelector("[data-test='inventory-item-price']"));

        //Verificar que hat elementos de nombres y precios
        if(productNames.isEmpty() || productPrices.isEmpty()){
            return false;
        }

        //Verificar que todos los nombres de productos sean visibles
        for(WebElement productName : productNames){
            if(!productName.isDisplayed()){
                System.out.println("Nombre de producto no esta disponible" + productName);
                return false;
            }
        }

        for(WebElement productPrice : productPrices){
            if(!productPrice.isDisplayed()){
                System.out.println("Precio de producto no disponible" + productPrice);
                return false;
            }
        }
        return true;
    }

    public void addItems(){
        addJacket.click();
        addBackpack.click();
        addTshirt.click();
    }
}
