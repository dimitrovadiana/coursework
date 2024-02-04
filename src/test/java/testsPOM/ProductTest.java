package testsPOM;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesPOM.LoginPage;
import pagesPOM.ProductPage;

public class ProductTest extends TestUtil {

    @Test(dataProvider = "items list")
    public void addItemToTheCart(String itemName){
        // Login with valid user
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.loginWithValidUser("standard_user", "secret_sauce");

        // Add one item to the cart
        productPage.addItemToTheCart(itemName);

        // Assert that there is only one item in the cart
        Assert.assertEquals(productPage.getItemsInCart(), 1,
                "Because we`ve added only one item");
    }

    @Test
    public void addItemsToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.loginWithValidUser("standard_user", "secret_sauce");

        // Add one item to the cart
        productPage.addItemToTheCart("fleece-jacket");

        // Assert that there is only one item in the cart
        Assert.assertEquals(productPage.getItemsInCart(), 1,
                "Because we`ve added only one item");

        // Add second item to the cart
        productPage.addItemToTheCart("backpack");

        // Assert that there are two items in the cart
        Assert.assertEquals(productPage.getItemsInCart(), 2,
                "Because we`ve added two items");
    }
}
