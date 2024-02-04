package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtil extends DataProviders{
    public WebDriver driver;
    private String browser, targetURL;
    private int implicitWait;

    @BeforeMethod
    public void setupDriverAndOpenTargetURL() throws InterruptedException {
        // read configurations for browser, url and wait
        readConfig("src/test/resources/config.properties");
        // set browser based on config properties - chrome or firefox
        setupDriver();
        //Implicit wait before opening the target url:
        driver.manage().timeouts().implicitlyWait(Duration.from(Duration.ofSeconds(implicitWait)));
        //Open target url in browser
        driver.get(targetURL);
    }

    @AfterMethod
    public void tearDown(){
        //close window after test is completed
        driver.quit();
    }

    //Read configurations from config.properties
    private void readConfig(String pathToFile){
        try{
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            targetURL = properties.getProperty("url");
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("wait"));
        }catch (IOException e){
            System.out.println(e);
        }
    }

    // set browser based on config properties - chrome or firefox
    private void setupDriver() {
        switch (browser) {
            case "chrome":
                driver = setupChromeDriver();
                break;
            case "firefox":
                driver = setupFireFoxDriver();
                break;
            default:
                System.out.println("Invalid browser");
        }
    }

    private WebDriver setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver setupFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
