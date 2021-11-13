package Base;

import Utilities.Helper;
import Utilities.LoadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";
    String url = LoadProperties.userData.getProperty("url");
    String browserName = LoadProperties.userData.getProperty("browserName");


    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.addArguments("--start-maximized");
        options.addArguments("incognito");
        return options;
    }

    @BeforeClass
    public void startDriver() {
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOption());
            System.out.println("Chrome driver opened");
        } else if (browserName.equals("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Firefox Driver opened");

        } else if (browserName.equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            System.out.println("Internet Explorer Driver opened");

        } else if (browserName.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }


        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Driver Opened Successfully");
        System.out.println("DownloadPath = [" + downloadPath);

    }

   // @AfterClass
   // public void closeDriver() {
       // driver.quit();
       // System.out.println("Driver Closed Successfully");
   // }


    //////////////////////// take screenshot when test case failed and add it in the Screenshots folder ////////////////////////
    @AfterMethod(alwaysRun = true)
    public void screenShotOnFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenShot(driver, result.getName());
            Helper.addAttachmenetsToAllure(result.getName(), "Screenshots\\" + result.getName() + ".png");
        }
    }


}
