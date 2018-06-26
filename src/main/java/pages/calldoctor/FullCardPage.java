package pages.calldoctor;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.calldoctor.Profiles_interfaces.Profile0;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.utilities.JSWaiter;

public class FullCardPage extends BasePage implements Profile0, Profile1, Profile2 {

    @FindBy(id = "doneCall")
    WebElement doneCall;

    @FindBy(xpath = "//div[@class='mat-calendar-body-cell-content mat-calendar-body-selected mat-calendar-body-today']")
    WebElement mat_calendar_header;

    @FindBy(xpath = "//*[contains(.,'Что изменилось')]")
    WebElement chtoIzmenilos;

    @FindBy(xpath = "//span[contains(text(),'Передать другому врачу')]")
    WebElement appoindBtn;

    @FindBy(id = "cancel")
    WebElement cancelBtn;

    @FindBy(id = "cancelCall")
    WebElement cancelCall;

    @FindBy(xpath = "//div[contains(text(),'Карта вызова')]")
    WebElement callCard;

    @FindBy(xpath = "//input[@placeholder='Причина отмены вызова")
    WebElement cancelField;

    public FullCardPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void verifyCallProfile0() throws InterruptedException {
        isDisplayed("Карта вызова");
        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("ЖАЛОБЫ");

        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");

        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("Не назначен");

        isDisplayedOnCardPage(adressPro0);
        isDisplayedOnCardPage(zhalobaPro0);
    }

    @Step
    public void verifyCallProfile1(String nameGen) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("П-д");
        isDisplayedOnCardPage("Домофон");
        isDisplayedOnCardPage("Этаж");
        isDisplayedOnCardPage("ЖАЛОБЫ");

        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("Возраст");
        isDisplayedOnCardPage("Пол");
        isDisplayedOnCardPage("Полис");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("Взрослый");
        isDisplayedOnCardPage("Пациент");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("Не назначен");
//        isDisplayedOnCardPage("Стенд ЕМИАС МО");

        isDisplayedOnCardPage(adressPro1);
        isDisplayedOnCardPage(pdPro1);
        isDisplayedOnCardPage(dfonPro1);
        isDisplayedOnCardPage(etazhPro1);
        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(famPro1);
        isDisplayedOnCardPage(otchestvoPro1);
        isDisplayedOnCardPage(seriyaPolPro1);
        isDisplayedOnCardPage(nomerPolPro1);
        isDisplayedOnCardPage(zhalobaPro1);
        isDisplayedOnCardPage(birthDayPro1);
        isDisplayedOnCardPage(goda24Pro1);
        isDisplayedOnCardPage(vozrastKatPro1);
    }

    @Step
    public void verifyCallProfile1Activity(String doctorFam, String nameGen) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("П-д");
        isDisplayedOnCardPage("Домофон");
        isDisplayedOnCardPage("Этаж");
        isDisplayedOnCardPage("ЖАЛОБЫ");

        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("Возраст");
        isDisplayedOnCardPage("Пол");
        isDisplayedOnCardPage("Полис");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Активный");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("Пациент");

        //в истории вызова
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Карта создана");
        isDisplayedOnCardPage("Назначенный врач");
        isDisplayedOnCardPage("Дата перевода в статус активный");

        //параметры профиля
        isDisplayedOnCardPage(adressPro1);
        isDisplayedOnCardPage(pdPro1);
        isDisplayedOnCardPage(dfonPro1);
        isDisplayedOnCardPage(etazhPro1);
        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(doctorFam);
        isDisplayedOnCardPage(famPro1);
        isDisplayedOnCardPage(otchestvoPro1);
        isDisplayedOnCardPage(seriyaPolPro1);
        isDisplayedOnCardPage(nomerPolPro1);
        isDisplayedOnCardPage(zhalobaPro1);
        isDisplayedOnCardPage(birthDayPro1);
        isDisplayedOnCardPage(goda24Pro1);
        isDisplayedOnCardPage(vozrastKatPro1);
    }

    @Step
    public void verifyDoneDocGroup(String doctorFam, String nameGen) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        driver.navigate().refresh();

        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();
        WebElement dynamicElement2 = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("П-д");
        isDisplayedOnCardPage("Домофон");
        isDisplayedOnCardPage("Этаж");
        isDisplayedOnCardPage("ЖАЛОБЫ");

        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("Возраст");
        isDisplayedOnCardPage("Пол");
        isDisplayedOnCardPage("Полис");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");


        isDisplayedOnCardPage("Обслуженный");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("Регистратура");
        isDisplayedOnCardPage("Пациент");

        //в истории вызова
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Активный");
        isDisplayedOnCardPage("Назначенный врач");
        isDisplayedOnCardPage("Дата перевода в статус активный");
        isDisplayedOnCardPage("Дата и время завершения обслуживания вызова");

        //параметры профиля
        isDisplayedOnCardPage(adressPro1);
        isDisplayedOnCardPage(pdPro1);
        isDisplayedOnCardPage(dfonPro1);
        isDisplayedOnCardPage(etazhPro1);
        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(doctorFam);
        isDisplayedOnCardPage(famPro1);
        isDisplayedOnCardPage(otchestvoPro1);
        isDisplayedOnCardPage(seriyaPolPro1);
        isDisplayedOnCardPage(nomerPolPro1);
        isDisplayedOnCardPage(zhalobaPro1);
        isDisplayedOnCardPage(birthDayPro1);
        isDisplayedOnCardPage(goda24Pro1);
        isDisplayedOnCardPage(vozrastKatPro1);
    }

    @Step
    public String verifyCallProfile2(String nameGen) throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Thread.sleep(700);
        isDisplayedOnCardPage("Дата");
        isDisplayedOnCardPage("Время");
        isDisplayedOnCardPage("Статус");
        isDisplayedOnCardPage("Вид вызова");
        isDisplayedOnCardPage("Источник");
        isDisplayedOnCardPage("АДРЕС");
        isDisplayedOnCardPage("П-д");
        isDisplayedOnCardPage("Домофон");
        isDisplayedOnCardPage("Этаж");
        isDisplayedOnCardPage("ЖАЛОБЫ");

        isDisplayedOnCardPage("КТО ПАЦИЕНТ");
        isDisplayedOnCardPage("КТО ВЫЗВАЛ");
        isDisplayedOnCardPage("КТО ОБСЛУЖИВАЕТ");
        isDisplayedOnCardPage("Возрастная категория");
        isDisplayedOnCardPage("Возраст");
        isDisplayedOnCardPage("Пол");
        isDisplayedOnCardPage("Полис");
        isDisplayedOnCardPage("Телефон");
        isDisplayedOnCardPage("Тип вызывающего");
        isDisplayedOnCardPage("Врач");
        isDisplayedOnCardPage("ИСТОРИЯ ВЫЗОВА");
        isDisplayedOnCardPage("Отменить вызов");
        isDisplayedOnCardPage("Изменить");
        isDisplayedOnCardPage("Передать в другое ЛПУ");

        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Первичный");
        isDisplayedOnCardPage("СМП");

        //в истории вызова
        isDisplayedOnCardPage("АВТОР");
        isDisplayedOnCardPage("ЧТО ИЗМЕНИЛОСЬ");
        isDisplayedOnCardPage("ИЗМЕНЕНИЕ");
        isDisplayedOnCardPage("Новый");
        isDisplayedOnCardPage("Карта создана");

        //параметры профиля
        isDisplayedOnCardPage(adressPro2);
        isDisplayedOnCardPage(pdPro2);
        isDisplayedOnCardPage(dfonPro2);
        isDisplayedOnCardPage(etazhPro2);
        isDisplayedOnCardPage(nameGen);
        isDisplayedOnCardPage(famPro2);
        isDisplayedOnCardPage(namePro2);

        isDisplayedOnCardPage(otchestvoPro2);
        isDisplayedOnCardPage(nomerPolPro2);
        isDisplayedOnCardPage(zhalobaPro2);
        isDisplayedOnCardPage(birthDayPro2);
        isDisplayedOnCardPage(goda24Pro2);
        isDisplayedOnCardPage(vozrastKatPro2);

        isDisplayedOnCardPage(telephonePro2);
        isDisplayedOnCardPage(genderPro2);

        isDisplayedOnCardPage(nameCallPro2);
        isDisplayedOnCardPage(famCallPro2);
        isDisplayedOnCardPage(otCallPro2);

        isDisplayedOnCardPage(stationSMPPro2);
        return famPro2;
    }


    @Step
    public void cancelRecord() throws InterruptedException {
        isDisplayed("Карта вызова");
        click(cancelBtn);
        wait(cancelField);
        cancelField.click();
        cancelField.sendKeys("отмена автотеста");
        click(cancelCall);
    }

    @Step
    public void sendAnotherDoctorBtn() {
        click(appoindBtn);
    }

    @Step
    public void appoindDoctorBtn() throws InterruptedException {
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Назначить')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();
    }

    @Step
    public void completeServiceBtn() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();
        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));

        Actions action = new Actions(driver);
        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Завершить обслуживание')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();

        click(mat_calendar_header);
        action.sendKeys(Keys.ENTER).perform();
        click(doneCall);
    }

    @Step
    public void closeCardBtn() {
        WebElement close = driver.findElement(By.xpath("//mat-icon[contains(text(),'close')]"));
        wait.until(ExpectedConditions.elementToBeClickable(close));
        close.click();
    }
}