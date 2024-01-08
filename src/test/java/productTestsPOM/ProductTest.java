package productTestsPOM;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pagesPOM.LoginPage;
import pagesPOM.ProductPage;

public class ProductTest extends TestUtil {

    @Test
    public void addItemToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user",
                "secret_sauce");

        productPage.addItemToTheCart("bike-light");

        Assert.assertEquals(productPage.getItemsInCart(), 1,
                "Because we`ve added only one item");
    }

    @Test
    public void addItemsToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user",
                "secret_sauce");

        SoftAssert softAssert = new SoftAssert();

        productPage.addItemToTheCart("fleece-jacket");
        softAssert.assertEquals(productPage.getItemsInCart(), 1, "First step");

        productPage.addItemToTheCart("backpack");
        softAssert.assertEquals(productPage.getItemsInCart(), 2, "Second step");

        softAssert.assertAll();
    }
}
