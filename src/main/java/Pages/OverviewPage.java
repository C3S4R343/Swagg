package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(.,'Finish')]")
    WebElement btnFinish;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean VerifyOverviewPage() {
        String url = driver.getCurrentUrl();
        assert url != null;
        return url.equals("https://www.saucedemo.com/checkout-step-two.html");
    }


    public void finish(){
        btnFinish.click();
    }


}
