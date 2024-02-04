package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    //elements
    @FindBy(id="user-name")
    private WebElement userNameInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(id="login-button")
    private WebElement loginBtn;

    @FindBy(xpath = " //*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement invalidLoginError;

    //constructor
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //methods i.e. actions on the page
    public ProductPage loginWithValidUser(String username, String password){
        login(username, password);

        return new ProductPage(driver);
    }

    public void login(String username, String password) {
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(username);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();
    }

    public boolean isInvalidErrorDisplayed(){
        return invalidLoginError.isDisplayed();
    }
}
