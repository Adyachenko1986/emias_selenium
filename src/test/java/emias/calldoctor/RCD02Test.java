package emias.calldoctor;

import emias.BaseTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.calldoctor.Profiles_interfaces.Profile5;
import pages.utilities.StringGenerator;

public class RCD02Test extends BaseTest implements Profile1, Profile2, Profile5 {
    String nameGen;


    @BeforeTest(groups = {"CD", "test"})
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = "CD")
    public void afterTest() throws Exception {
    }

    @Test(groups = "test", description = "изменить карту вызова, созданную по п.1.1")
    @RetryCountIfFailed(0)
    public void testEditProfile1() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);

        page.editCardPage().editCallBtn();
        page.editCardPage().editCallProfile5(nameGen);
        page.fullCardPage().verifyCallProfile5(nameGen);

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen, adressPro5_2, telephonePro5);
    }
}