
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;
import pages.Pages;
import pages.utilities.ChromeOptionsManager;
import pages.utilities.DriverManager;
import pages.utilities.JSWaiter;
import pages.utilities.Waiter;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    //    private DesiredCapsManager desiredCapsManager = new DesiredCapsManager();
    private ChromeOptionsManager chromeOptionsManager = new ChromeOptionsManager();
    Pages page;
    ScreenshotListener listner;

    @Parameters(value = {"browser", "platform"})
    @BeforeClass
    public void setupTest(@Optional String browser, @Optional String platform) throws MalformedURLException {
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);

        //КОРОЧЕ изучить как работает менеджер

//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        ChromeOptions options = new ChromeOptions();
//        options.merge(capabilities);
        options.setHeadless(false);
        options.addArguments("window-size=1200,1020");
//        ChromeDriver driver = new ChromeDriver(service, options);
        driver = new ChromeDriver(service, options);
//more capabilit https://sites.google.com/a/chromium.org/chromedriver/capabilities

//        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");

        //Get DesiredCapabilities
//        ChromeOptions options = new ChromeOptions();
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //Create Driver with capabilities
//        driver = new DriverManager(options).createDriver();
        JSWaiter.setDriver(driver);
        Waiter.setDriver(driver);
        wait = new WebDriverWait(driver, 15);
        page = new Pages(driver);
        listner = new ScreenshotListener(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @BeforeMethod
    public void setup() {
        driver.get("http://emias.mosreg.ru/demonstration");
        page.loginPage().enterLoginText("admin");
        page.loginPage().enterPasswordText("RChS2014");
        page.loginPage().clickLoginButton();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() throws Exception {
/*вот тут нужно что бы скрин был только если была ошибка*/
        takeSnapShot(driver, "test.png");
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}

