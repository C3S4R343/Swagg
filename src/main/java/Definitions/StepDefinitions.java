package Definitions;

import Pages.*;
import Utils.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepDefinitions {
    WebDriver driver = Hooks.getDriver();
    LoginPage logPage = new LoginPage(driver);
    InventoryPage invPage = new InventoryPage(driver);
    CartPage cPage = new CartPage(driver);
    CheckOutPage chPage =  new CheckOutPage(driver);
    OverviewPage overPage =  new OverviewPage(driver);
    CheckOutComplete chCompl = new CheckOutComplete(driver);

    @Given("the browser is launched and test environment is set up")
    public void the_browser_is_launched_and_test_environment_is_set_up() {
        driver.get("https://www.saucedemo.com");
    }

    @When("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        Assert.assertTrue(logPage.verifyElements(), "No esta en login");
    }

    @And("the Swag Labs logo is displayed on the login page")
    public void the_swag_labs_logo_is_displayed_on_the_login_page() {
        Assert.assertTrue(logPage.verifyLogo(), "Logo no esta visible");
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        logPage.login("standard_user", "secret_sauce");
    }

    @Then("the products page is displayed")
    public void the_products_page_is_displayed() {
        Assert.assertTrue(invPage.verifyUrl(), "Pagina de inventario no disponible");
    }

    @When("the user opens the menu")
    public void the_user_opens_the_menu() {
        invPage.openMenu();
    }

    @And("the logout button is visible")
    public void the_logout_button_is_visible() {
        Assert.assertTrue(invPage.isLogoutVisible(), "No se encuentra logout");
    }

    @When("the user navigates to the product details page")
    public void the_user_navigates_to_the_product_details_page() {
        invPage.CloseMenu();
    }

    @Then("the product name is displayed")
    public void the_product_name_is_displayed() {
        Assert.assertTrue(invPage.verifyProductNamesAndPrices(), "No todos los nombres y precios de productos son visibles");
    }

    @When("the user adds 3 items to the cart")
    public void the_user_adds_items_to_the_cart() {
        invPage.addItems();
    }

    @Then("the cart icon shows {int} items")
    public void the_cart_icon_shows_items(Integer int1) {
        Assert.assertTrue(invPage.getItemsNumer(), "No hay 3 elementos en el carrito");
    }

    @When("the user clicks the {string} button on an item")
    public void the_user_clicks_the_button_on_an_item(String string) {
        invPage.remoteItem();
    }

    @Then("the item is removed from the cart")
    public void the_item_is_removed_from_the_cart() {
        Assert.assertFalse(invPage.getItemsNumer(),"No se elimino item");
    }

    @When("the user navigates to the cart page")
    public void the_user_navigates_to_the_cart_page() {
        invPage.enterCartPage();
        Assert.assertTrue(cPage.verifyCartPage(),"Pagina de carrito no es visible");
    }

    @Then("the correct items are listed in the cart")
    public void the_correct_items_are_listed_in_the_cart() {
        Assert.assertTrue(cPage.getInventoryItemsCount(),"No hay numero correcto de items");
    }

    @When("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {
        cPage.clickCheckOut();
    }

    @Then("the checkout page is displayed")
    public void the_checkout_page_is_displayed() {
        Assert.assertTrue(chPage.verifyCheckOutPage(),"Pagina de checkout no disponible");
    }

    @When("the user enters the required shipping and payment information")
    public void the_user_enters_the_required_shipping_and_payment_information() {
        chPage.enterInformation();
    }

    @Then("the user proceeds to the confirmation page")
    public void the_user_proceeds_to_the_confirmation_page() {
        Assert.assertTrue(overPage.VerifyOverviewPage(),"Pagina overvew no esta disponible");
    }

    @When("the user reviews the order on the confirmation page")
    public void the_user_reviews_the_order_on_the_confirmation_page() {
        Assert.assertTrue(invPage.verifyProductNamesAndPrices(),"Items visibles");
    }

    @Then("the correct items are displayed")
    public void the_correct_items_are_displayed() {
        Assert.assertTrue(invPage.verifyProductNamesAndPrices(),"Productos y precios correctos");
    }

    @When("the user logs out of the website")
    public void the_user_logs_out_of_the_website() {
        overPage.finish();
    }

    @Then("the user is logged out successfully")
    public void the_user_is_logged_out_successfully() {
        chCompl.clickBackHome();
        invPage.logOut();
    }

    @When("the user attempts to log in with the locked user credentials")
    public void the_user_attempts_to_log_in_with_the_credentials() {
        Assert.assertTrue(logPage.verifyLocketUser());
    }


    @When("the browser session is closed")
    public void the_browser_session_is_closed() {

    }

    @Then("the driver is terminated")
    public void the_driver_is_terminated() {

    }
}
