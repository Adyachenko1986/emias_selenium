package emias;

//import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;

public class ScreenshotListener extends TestListenerAdapter {
    WebDriver driver;

    public ScreenshotListener(WebDriver driver) {
        this.driver = driver;
    }

//    @Override
//    public void onTestFailure(ITestResult result) {
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
//        String methodName = result.getFam();
//        if (!result.isSuccess()) {
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            try {
//                String reportDirectory = "target/surefire-reports";
//                File destFile = new File(reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
//                FileUtils.copyFile(scrFile, destFile);
//                Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}