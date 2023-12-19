package first.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SuccessfulLogin {
    public WebDriver driver;

    @BeforeMethod
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successfulLogin(){
        driver.get("https://www.saucedemo.com/");

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[name=login-button]"));
        loginBtn.click();

        WebElement productPageTitle = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        Assert.assertTrue(productPageTitle.isDisplayed());
        //Assert.assertEquals(driver.getTitle(), "Products");
    }
}
