package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAt(){
        // wait 5 seconds until page title is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.from(Duration.ofSeconds(5)));
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        if (pageTitle.getText().equals("Your Cart")){
            return true;
        }else {
            return false;
        }
    }

    public CheckoutPage clickCheckoutButton() {
        checkoutBtn.click();

        return new CheckoutPage(driver);
    }
}
