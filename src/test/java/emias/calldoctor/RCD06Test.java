package emias.calldoctor;

import emias.AbstractTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

public class RCD06Test extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod() {
        SQLDemonstration.finalizePacientName(nameGen);
    }

//    @Test(groups = "CD", description = "завершить обслуживание вызова")
//    @Issue("EMIAS-90")
//    @RetryCountIfFailed(2)
//    public void testCompleteCallRegistr() throws Exception {
//        open(curUrlCalldoctor);
//        page.createCallPage().createCallProfile1("Profile1", nameGen);
//        page.fullCardPage().chooseDoctorBtn();
//        page.setDoctorPage().chooseDoctor("Profile1");
//        page.fullCardPage()
//                .completeServiceBtn()
//                .verifyDoneDocGroup(nameGen, "Profile1")
//                .closeCardBtn();
//        page.dashboardPage()
//                .searchFilterFio(nameGen)
//                .clearFilterDepart()
//                .verifyDoneDocGroup(nameGen, "Profile1");
//    }

    // TODO: 13.08.2018 передать вызов из юр. Лица в подразделение
    // TODO: 13.08.2018 передать вызов из подразделения в др.подразделение
    // TODO: 13.08.2018 передать вызов из подразделения в юр. Лицо
    // TODO: 13.08.2018 передать вызов из первого ЛПУ в др. ЛПУ

}