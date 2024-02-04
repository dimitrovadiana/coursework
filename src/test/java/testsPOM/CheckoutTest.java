package testsPOM;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesPOM.CartPage;
import pagesPOM.CheckoutPage;
import pagesPOM.LoginPage;
import pagesPOM.ProductPage;

public class CheckoutTest extends TestUtil {

    @Test
    public void goToShoppingCart() {
        // Login with valid user
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.loginWithValidUser("standard_user", "secret_sauce");

        // Add one item to the cart
        productPage.addItemToTheCart("bike-light");

        // Click shopping cart link
        CartPage cartPage = productPage.clickShoppingCartLink();

        // Assert cart page title is displayed
        Assert.assertTrue(cartPage.isAt());
    }

    @Test
    public void successfulCheckout() {
        // Login with valid user
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.loginWithValidUser("standard_user", "secret_sauce");

        // Add one item to the cart
        productPage.addItemToTheCart("bike-light");

        // Click shopping cart link
        CartPage cartPage = productPage.clickShoppingCartLink();

        // Make successful checkout
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();

        // Assert checkout page title is displayed
        Assert.assertTrue(checkoutPage.isAt());
    }
}
