package pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.AbstractPage;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage extends AbstractPage {


    private SelenideElement exitToMis = $(By.xpath("//mat-icon[contains(text(),'more_vert')]"));
    private SelenideElement exitBtn = $(By.xpath("//*[contains(text(),'Выход')]"));
    private SelenideElement instructionBtn = $(By.xpath("//*[contains(text(),'Инструкция')]"));
    private SelenideElement fioFilter = $(By.xpath("//*[@placeholder='ФИО']"));
    private SelenideElement docFilter = $(By.xpath("//*[@placeholder='Врач']"));
    private SelenideElement typeCall = $(By.xpath("//*[@placeholder='Вид вызова']"));
    private SelenideElement newCallProgressFrame = $(By.id("newCallProgressFrame"));
    private SelenideElement matExpansionPanel = $(By.xpath("//*[@id='newCallProgressFrame']/mat-expansion-panel/div"));
    private SelenideElement typeCallFilterNeotlozhniy = $(By.xpath("//span[contains(text(),'Неотложный')]"));
    private SelenideElement activeCallProgressFrame = $(By.id("activeCallProgressFrame"));
    private SelenideElement doneCallProgressFrame = $(By.id("doneCallProgressFrame"));

    public DashboardPage() {

    }

    @Step("вышел в мис")
    public void exitToMis() {
        exitToMis.click();
        exitBtn.click();
    }

    @Step("вышел в мис")
    public void instruction() {
        exitToMis.click();
        instructionBtn.click();
    }

//    @Step("поиск в фильтре ФИО")
//    public DashboardPage searchFilterFio(String fio) {
//        fioFilter.click();
//        fioFilter.setValue(fio);
//        return this;
//    }

    @Step("поиск в фильтре ФИО")
    public DashboardPage searchFilterFio_Fam(Pacient pacient) throws IOException, InterruptedException {
        fioFilter.click();
        fioFilter.setValue(pacient.getFamily());
        Thread.sleep(2000);
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPage searchFilterDoctor(Doctor doctor) throws IOException, InterruptedException {
        docFilter.click();
        docFilter.setValue(doctor.getFamily());
        $(By.xpath("//ul/li/div[contains(text(),'" + doctor.getFamily() + "')]")).shouldBe(Condition.visible);
        Thread.sleep(1000);
        $(By.xpath("//ul/li[contains(@data-value,'" + doctor.getFamily() + "')]")).click();
        return this;
    }

    @Step("поиск в фильтре врача")
    public DashboardPage searchFilterTypeCallNeotlozhniy() {
        typeCall.click();
        typeCallFilterNeotlozhniy.click();
        return this;
    }

    @Step("очистить фильтр подразделение")
    public DashboardPage clearAllFilters() {
        ElementsCollection closeList = $$(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408"));
        for (SelenideElement closeBtn : closeList) {
            closeBtn.click();
        }
        return this;
    }

//    @Step("проверяю на дашборде запись в группе новые")
//    public void verifyNewCallGroup(String profile, String nameGen) throws InterruptedException, IOException {
//        Thread.sleep(4000);
//        newCallProgressFrame.$(By.id("order")).click();
//        newCallProgressFrame.click();
//        if (proData.get("source").equals("СМП")) {
//            $(By.xpath("//*[contains(text(),'" + proData.get("adressDashboard") + "')]")).click();
//            $(By.xpath("//*[contains(text(),'" + proData.get("fam") + "')]")).shouldBe(Condition.visible);
//            $(By.xpath("//*[contains(text(),'" + proData.get("telephone") + "')]")).shouldBe(Condition.visible);
//        }
//        if (!proData.get("source").equals("СМП")) {
//            $(By.xpath("//*[contains(text(),'" + proData.get("adressDashboard") + "')]")).click();
//            $(By.xpath("//*[contains(text(),'" + nameGen + "')]")).shouldBe(Condition.visible);
//            $(By.xpath("//*[contains(text(),'" + proData.get("telephone") + "')]")).shouldBe(Condition.visible);
//        }
//        System.out.println("Краткая карта вызова проверена!");
//    }

    @Step("проверяю на дашборде запись в группе новые")
    public void verifyNewCallGroup(Pacient pacient) throws InterruptedException, IOException {
        Thread.sleep(4000);
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        $(By.xpath("//*[contains(text(),'" + pacient.getAddress() + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + pacient.getName() + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + pacient.getFamily() + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + pacient.getOt() + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + parseTelephone(pacient) + "')]")).shouldBe(Condition.visible);
        System.out.println("Краткая карта вызова проверена!");
    }

    @Step("проверяю на дашборде запись у врача в группе активные")
    public DashboardPage verifyActiveDocGroup(Pacient pacient, Doctor doctor) throws IOException {
        SelenideElement docFamBlock = $(By.xpath("//span[contains(text(),'" + doctor.getFamily() + "')]"));
        docFamBlock.click();

        SelenideElement docBlock = docFamBlock.$(By.xpath("../../../../../."));
        docBlock.$(By.xpath(".//*[contains(text(),'Ожидают обработки')]"))
                .$(By.xpath("../."))
                .$(By.xpath(".//*[@id='order']")).click();
        docBlock.$(By.xpath(".//*[contains(text(),'Ожидают обработки')]")).click();
        $(By.xpath("//*[contains(text(),'" + pacient.getAddress() + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + parseTelephone(pacient) + "')]")).shouldBe(Condition.visible);
        System.out.println("Краткая карта вызова проверена!");
        return this;
    }

    @Step("проверка в группе обслуженные")
    public void verifyDoneDocGroup(Pacient pacient, Doctor doctor) throws InterruptedException {
        SelenideElement doneFrame = $(By.xpath("//*[contains(text(),'Обслуженные')]")).$(By.xpath("../../."));
        SelenideElement docFamBlock = doneFrame.$(By.xpath(".//span[contains(text(),'" + doctor.getFamily() + "')]"));
        docFamBlock.click();

        SelenideElement docBlock = docFamBlock.$(By.xpath("../../../../../."));
        docBlock.$(By.xpath(".//*[contains(text(),'Ожидают обработки')]"))
                .$(By.xpath("../."))
                .$(By.xpath(".//*[@id='order']")).click();
        docBlock.$(By.xpath(".//*[contains(text(),'Ожидают обработки')]")).click();
        $(By.xpath("//*[contains(text(),'" + pacient.getAddress() + "')]")).click();
        $(By.xpath("//*[contains(text(),'" + parseTelephone(pacient) + "')]")).shouldBe(Condition.visible);
        System.out.println("Краткая карта вызова проверена!");
    }

    @Step("Проверка что запись удалена с дашборда")
    public void verifyRecordIsCancelFromDashboard(Pacient pacient) throws InterruptedException {
        Thread.sleep(5000);
        SelenideElement address = $(By.xpath("//*[contains(text(),'" + pacient.getAddress() + "')]"));
        if (newCallProgressFrame.isDisplayed()) {
            newCallProgressFrame.$(By.id("order")).click();
            newCallProgressFrame.click();
            if (address.isDisplayed()) {
                address.click();
                Assert.assertFalse(!$(By.xpath("//*[contains(text(),'" + pacient.getName() + "')]")).isDisplayed());
                Assert.assertFalse(!$(By.xpath("//*[contains(text(),'" + pacient.getFamily() + "')]")).isDisplayed());
                Assert.assertFalse(!$(By.xpath("//*[contains(text(),'" + pacient.getOt() + "')]")).isDisplayed());
                Assert.assertFalse(!$(By.xpath("//*[contains(text(),'" + parseTelephone(pacient) + "')]")).isDisplayed());
            } else {
                System.out.println("Проверка выполнена. Вызов с адресом: '" + address + "' не найден!");
            }
        } else {
            System.out.println("Проверка выполнена. Группа 'ожидают обработки' не найдена!");
        }
    }

    @Step("открываю карту вызова в группе 'Ожидают обработки' через дашбоард")
    public void openNewCallDash(Pacient pacient) throws IOException, InterruptedException {
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        SelenideElement address = matExpansionPanel.$(By.xpath(".//*[contains(text(),'" + pacient.getAddress() + "')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(address).perform();
        SelenideElement smallMenu = address.$(By.xpath("../../../.")).$(By.xpath(".//*[contains(text(),'chevron_left')]"));
        actions.moveToElement(smallMenu).perform();
        SelenideElement openCard = address.$(By.xpath("../../../.")).$(By.xpath(".//*[@title='Открыть карту вызова']"));
        Thread.sleep(700);
        openCard.click();
    }

    @Step("удаляю карту вызова в группе 'Ожидают обработки' через дашбоард")
    public DashboardPage deleteNewCallProgressFrame(Pacient pacient) throws IOException {
        newCallProgressFrame.$(By.id("order")).click();
        newCallProgressFrame.click();
        SelenideElement adress = matExpansionPanel.$(By.xpath(".//*[contains(text(),'" + pacient.getAddress() + "')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(adress).perform();
        SelenideElement smallMenu = adress.$(By.xpath("../../../.")).$(By.xpath(".//*[contains(text(),'chevron_left')]"));
        actions.moveToElement(smallMenu).perform();
        SelenideElement openCard = adress.$(By.xpath("../../../.")).$(By.xpath(".//*[@title='Отменить вызов']"));
        openCard.click();
        return this;
    }
}