import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class RegressCallDoctor extends TestBase {

    @Ignore
    @Test// KEYS 0.0
    public void testProject() throws InterruptedException, ClassNotFoundException {
        //кейс для быстрых проверочек
    }

    @Test
    public void testCreateRecord() throws InterruptedException, ClassNotFoundException {
        driver.get("http://mis.softrust.ru/whc/Home");
        page.loginPage().enterLoginText("admin");
        page.loginPage().enterPasswordText("11");
        page.loginPage().clickLoginButton();

        page.homePage().callDoctorBtn();
        page.callDoctorPage().switchToPage();
        //driver.get("http://109.95.224.42:2165/test/call/call_doctor_ui/call-doctor;6628/board?ticket=rIjLfkzppVn535yZNj87yX%2bn%2flsaAQCvx%2f6oVgRslUhRxpjtjkE3e1xmu%2b8Oy5eSmWXcfaQ8A4Gz00wHkDVLg126daSKZsclYDKgmDUflgln66XRS1YyCvKTwov6E76m2wSPN4ptJ2Z7eSG9Bst2%2b5Vuf9Y2YzqosTC8TSyL%2fQO3JxsTQx%2bqj2IjwDOrVErC9uWF49Nhzrhud0t6pIU2UmFN1W5oi3ZSbkAzDm2wXAJtWumTCvZDVahRTQaxk8oJrXfyf3jSpJtCpMKxSY9WqRm1yDE2U4csJGEvp%2faas6WNWzF2&ReturnUrl=http%3a%2f%2fmis.softrust.ru%2fwhc%2fMain%2fDefault");
        page.callDoctorPage().createCallOtRegistratura();
        page.callDoctorPage().verifyCreateCall();
    }
}