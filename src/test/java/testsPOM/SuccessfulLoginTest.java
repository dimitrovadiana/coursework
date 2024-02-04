package testsPOM;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesPOM.LoginPage;
import pagesPOM.ProductPage;

public class SuccessfulLoginTest extends TestUtil {

    @Test
    public void successfulLogin(){
        // Login with valid user
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.loginWithValidUser("standard_user", "secret_sauce");

        // Assert product page title is displayed
        Assert.assertTrue(productPage.isAt());
    }
}
