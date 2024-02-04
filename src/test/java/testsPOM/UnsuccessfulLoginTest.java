package testsPOM;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesPOM.LoginPage;

public class UnsuccessfulLoginTest extends TestUtil {

    @Test
    public void unsuccessfulLogin(){
        // Login with invalid user
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "invalid_sauce");

        // Assert invalid login error is displayed
        Assert.assertTrue(loginPage.isInvalidErrorDisplayed());
    }
}
