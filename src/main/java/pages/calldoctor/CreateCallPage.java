package pages.calldoctor;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.calldoctor.Profiles_interfaces.Profile0;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.calldoctor.Profiles_interfaces.Profile4;
import pages.utilities.JSWaiter;

import java.io.InputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class CreateCallPage extends AbstractPage implements Profile1, Profile2, Profile0, Profile4 {
//    Actions action = new Actions(driver);

    @FindBy(id = "4198BD84-7A21-4E38-B36B-3ECB2E956408")
    @CacheLookup
    WebElement cancelAdress;

    @FindBy(xpath = "//div[@class='autocomplete-list-container']/ul/li")
    WebElement list_first_container;

    @FindBy(xpath = "//input[@placeholder='Адрес']")
    @CacheLookup
    WebElement placeholder_adress;

    @FindBy(xpath = "//input[@placeholder='Дом']")
    @CacheLookup
    WebElement dom;

    @FindBy(xpath = "//*[@mattooltip='Добавить вызов']")
    @CacheLookup
    WebElement addCallBtn;

    @FindBy(id = "phone")
    @CacheLookup
    WebElement telephoneNumber;

    @FindBy(xpath = "//label[@class='mat-checkbox-layout']/div")
    @CacheLookup
    WebElement chkBoxTelephone;

    @FindBy(xpath = "//button[2]/span/mat-icon")
    WebElement hz;

    @FindBy(xpath = "//input[@placeholder='Возр. категория']")
    WebElement vozr;

    @FindBy(xpath = "//span[contains(.,'Взрослые')]")
    WebElement hz2;

    @FindBy(xpath = "//input[@placeholder='Корпус']")
    @CacheLookup
    WebElement korpus;

    @FindBy(xpath = "//input[@placeholder='Строение']")
    @CacheLookup
    WebElement stroenie;

    @FindBy(xpath = "//input[@placeholder='Квартира']")
    @CacheLookup
    WebElement kvartira;

    @FindBy(xpath = "//input[@placeholder='П-д']")
    @CacheLookup
    WebElement pd;

    @FindBy(xpath = "//input[@placeholder='Д-фон']")
    @CacheLookup
    WebElement dfon;

    @FindBy(xpath = "//input[@placeholder='Этаж']")
    @CacheLookup
    WebElement etazh;

    SelenideElement zhaloba = $(By.xpath("//input[@aria-label='Введите текст жалобы']"));

    @FindBy(xpath = "//input[@placeholder='Серия']")
    @CacheLookup
    WebElement seriyaPol;

    @FindBy(xpath = "//input[@placeholder='Номер полиса']")
    @CacheLookup
    WebElement nomerPol;

    @FindBy(xpath = "//input[@placeholder='Фамилия']")
    @CacheLookup
    WebElement fam;

    @FindBy(xpath = "//input[@placeholder='Имя']")
    @CacheLookup
    WebElement name;

    @FindBy(xpath = "//input[@placeholder='Отчество']")
    @CacheLookup
    WebElement otchestvo;

    @FindBy(xpath = "//input[@placeholder='Тип вызывающего']")
    @CacheLookup
    WebElement tipVisivaushego;

    @FindBy(xpath = "//input[@placeholder='Станция СМП']")
    @CacheLookup
    WebElement stationSMP;

    @FindBy(xpath = "//span[contains(.,'Пациент')]")
    @CacheLookup
    WebElement pacient;

    @FindBy(id = "save")
    @CacheLookup
    WebElement saveBtns;

    @FindBy(id = "callFamily")
    @CacheLookup
    WebElement callFamily;

    @FindBy(id = "callName")
    @CacheLookup
    WebElement callName;

    @FindBy(id = "callPatronymic")
    @CacheLookup
    WebElement callPatronymic;

    @FindBy(xpath = "//div[contains(text(),'Новый вызов')]")
    @CacheLookup
    WebElement noviyVizov;

    @FindBy(xpath = "//input[@placeholder='Дата рождения']")
    @CacheLookup
    WebElement birthDay;

    @FindBy(id = "findPatientInput")
    @CacheLookup
    WebElement findPatientInput;

    @FindBy(xpath = "//div/mat-option/span[contains(text(),'" + famPro2 + "')]")
    @CacheLookup
    WebElement famPro2Xpath;

    @FindBy(id = "source0")
    @CacheLookup
    WebElement source0;

    @FindBy(xpath = "//button/span[contains(text(),'Да')]")
    @CacheLookup
    WebElement allarmaYes;

    @FindBy(id = "sex1")
    @CacheLookup
    WebElement sex1;

    public CreateCallPage(/*WebDriver driver*/) {
        //super(driver);
    }

    @Step("создаю пустой вызов")
    public void createCallProfile0() {
        createCallBtn();
        /*обязательные поля*/
        sendKeysJS(dom, domPro0);
        click(chkBoxTelephone);

        click(hz);
        click(vozr);
        hz2.click();

        /*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + zhalobaPro0 + "';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        //action.sendKeys(Keys.ENTER).perform();

        saveBtns.click();

        click(allarmaYes);
    }

    @Step("создаю вызов -МКАБ +Регистр")
    public void createCallProfile1(String nameGen) {
        /**
         * таких профилей будет несколько
         * в него нужно передавать класс с содержимым профиля
         * этот профиль должен перезаписывать переменные находящиеся здесь и по ним создавать профиль
         */
        addNewCall()
                .adress()
                .telephone()
                .vozrastKat()
                .adressAddition()
                .sexM()
                .complaint()
                .polis()
                .FIO()
                .birthDay()
                .caller()
                .saveBtn();
    }
//    @Step("создаю вызов -МКАБ +Регистр")
//    public void createCallProfile1(String nameGen) throws InterruptedException {
//        $(By.id("addNewCall")).click();
//        /*адрес*/
//        $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408")).click();
//        $(By.xpath("//input[@placeholder='Адрес']")).click();
//        $(By.xpath("//input[@placeholder='Адрес']")).setValue(adressPro1_1);
//        $(By.xpath("//div[@class='autocomplete-list-container']/ul/li")).click();
//        $(By.xpath("//input[@placeholder='Адрес']")).setValue(adressPro1_2);
//        $(By.xpath("//div[@class='autocomplete-list-container']/ul/li")).click();
//        $(By.xpath("//input[@placeholder='Адрес']")).setValue(adressPro1_3);
//        $(By.xpath("//div[@class='autocomplete-list-container']/ul/li")).click();
//        /*обязательные поля*/
//        $(By.xpath("//input[@placeholder='Дом']")).setValue(domPro1);
//        $(By.id("phone")).setValue(telephonePro1);
//        $(By.xpath("//button[2]/span/mat-icon")).click();
//        $(By.xpath("//input[@placeholder='Возр. категория']")).click();
//        $(By.xpath("//span[contains(.,'Взрослые')]")).click();
//        /*необязательные поля*/
//        $(By.xpath("//input[@placeholder='Корпус']")).setValue(korpusPro1);
//        $(By.xpath("//input[@placeholder='Строение']")).setValue(stroeniePro1);
//        $(By.xpath("//input[@placeholder='Квартира']")).setValue(kvartiraPro1);
//        $(By.xpath("//input[@placeholder='П-д']")).setValue(pdPro1);
//        $(By.xpath("//input[@placeholder='Д-фон']")).setValue(dfonPro1);
//        $(By.xpath("//input[@placeholder='Этаж']")).setValue(etazhPro1);
//        $(By.id("sex1")).click();
//        /*жалоба*/
//        WebDriver driver = getWebDriver();
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].value='" + zhalobaPro1 + "';", zhaloba);
//        zhaloba.sendKeys(Keys.SPACE);
//        /*кто пациент*/
//        $(By.xpath("//input[@placeholder='Серия']")).setValue(seriyaPolPro1);
//        $(By.xpath("//input[@placeholder='Номер полиса']")).setValue(nomerPolPro1);
//        $(By.xpath("//input[@placeholder='Фамилия']")).setValue(famPro1);
//        $(By.xpath("//input[@placeholder='Имя']")).setValue(nameGen);
//        $(By.xpath("//input[@placeholder='Отчество']")).setValue(otchestvoPro1);
//        $(By.xpath("//input[@placeholder='Дата рождения']")).setValue(birthDayPro1);
//        /*кто вызывает*/
//        $(By.xpath("//input[@placeholder='Тип вызывающего']")).click();
//        $(By.xpath("//span[contains(.,'Пациент')]")).click();
//        $(By.id("save")).click();
//    }

    public CreateCallPage addNewCall() {
        $(By.id("addNewCall")).click();
        return this;
    }

    private CreateCallPage adress() {
        $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408")).click();
        //тут нужно сделать цикл, потому что адрес может быть разной длины
        $(By.xpath("//input[@placeholder='Адрес']")).setValue(adressPro1_1);
        $(By.xpath("//div[@class='autocomplete-list-container']/ul/li")).click();
        $(By.xpath("//input[@placeholder='Адрес']")).setValue(adressPro1_2);
        $(By.xpath("//div[@class='autocomplete-list-container']/ul/li")).click();
        $(By.xpath("//input[@placeholder='Адрес']")).setValue(adressPro1_3);
        $(By.xpath("//div[@class='autocomplete-list-container']/ul/li")).click();
        $(By.xpath("//input[@placeholder='Дом']")).setValue(domPro1);
        return this;
    }

    private CreateCallPage telephone() {
        $(By.id("phone")).setValue(telephonePro1);
        return this;
    }

    private CreateCallPage vozrastKat() {
        $(By.xpath("//button[2]/span/mat-icon")).click();
        $(By.xpath("//input[@placeholder='Возр. категория']")).click();
        $(By.xpath("//span[contains(.,'Взрослые')]")).click();
        return this;
    }

    private CreateCallPage adressAddition() {
        $(By.xpath("//input[@placeholder='Корпус']")).setValue(korpusPro1);
        $(By.xpath("//input[@placeholder='Строение']")).setValue(stroeniePro1);
        $(By.xpath("//input[@placeholder='Квартира']")).setValue(kvartiraPro1);
        $(By.xpath("//input[@placeholder='П-д']")).setValue(pdPro1);
        $(By.xpath("//input[@placeholder='Д-фон']")).setValue(dfonPro1);
        $(By.xpath("//input[@placeholder='Этаж']")).setValue(etazhPro1);
        return this;
    }

    private CreateCallPage sexM() {
        $(By.id("sex1")).click();
        return this;
    }

    private CreateCallPage complaint() {
        WebDriver driver = getWebDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + zhalobaPro1 + "';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        return this;
    }

    private CreateCallPage polis() {
        $(By.xpath("//input[@placeholder='Серия']")).setValue(seriyaPolPro1);
        $(By.xpath("//input[@placeholder='Номер полиса']")).setValue(nomerPolPro1);
        return this;
    }

    private CreateCallPage FIO() {
        $(By.xpath("//input[@placeholder='Фамилия']")).setValue(famPro1);
        $(By.xpath("//input[@placeholder='Имя']")).setValue(namePro2/*nameGen*/);
        $(By.xpath("//input[@placeholder='Отчество']")).setValue(otchestvoPro1);
        return this;
    }

    private CreateCallPage birthDay() {
        $(By.xpath("//input[@placeholder='Дата рождения']")).setValue(birthDayPro1);
        return this;
    }

    private CreateCallPage caller() {
        $(By.xpath("//input[@placeholder='Тип вызывающего']")).click();
        $(By.xpath("//span[contains(.,'Пациент')]")).click();
        return this;
    }

    private CreateCallPage saveBtn() {
        $(By.id("save")).click();
        return this;
    }


    @Step("создаю вызов с МКАБ + СМП")
    public void createCallProfile2(String nameGen) {
        createCallBtn();

        /*кто пациент*/
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Новый вызов')]")));
        sendKeysJS(findPatientInput, nomerPolPro2);
        clickJS(famPro2Xpath);

        /*обязательные поля*/
        click(source0);
        sendKeysJS(dom, domPro2);

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].value='" + telephonePro1 + "';", telephoneNumber);
        telephoneNumber.click();
        //action.sendKeys(Keys.SPACE).perform();

        /*необязательные поля*/
        sendKeysJS(pd, pdPro2);
        sendKeysJS(dfon, dfonPro2);
        sendKeysJS(etazh, etazhPro2);
        click(sex1);

        /*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + zhalobaPro2 + "';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        //action.sendKeys(Keys.ENTER).perform();


        /*кто вызывает*/
        sendKeysJS(callFamily, famCallPro2);
        sendKeysJS(callName, nameGen);
        sendKeysJS(callPatronymic, otCallPro2);
        sendKeysJS(stationSMP, stationSMPPro2);

        saveBtns.click();
    }

    @Step("создаю вызов от СМП по api Ребёнок без КЛАДР по МКАБ")
    public void createCallProfile3(String nameGen) {
        HttpClient httpClient = HttpClients.createDefault();
        JSONObject json = new JSONObject();
        json.put("name", nameGen);
        json.put("family", "Тестовый");
        json.put("ot", "СМП");
        json.put("birthdate", "2002-01-10");
        json.put("seriespol", "");
        json.put("numberpol", "5098799789000154");//реальный мкаб
        json.put("gender", "2");
        json.put("address", "это не формализованный адрес");
        json.put("complaint", "тестовый вызов");
        json.put("diagnosis", "j20");
        json.put("type", "4");
        json.put("codedomophone", "12№#!@-тут символы");
        json.put("phone", "+79606223551");
        json.put("source", "2");
        json.put("sourceName", "СМП");
        json.put("sourceCode", "2");
        json.put("entrance", "12");
        json.put("floor", "5");

        try {
            HttpPost request = new HttpPost("http://12.8.1.126:2224/api/v2/smp/calldoctor/a7f391d4-d5d8-44d5-a770-f7b527bb1233");
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", "fb6e439f-c34f-4ee0-b2ba-38c1be5116a3");

            StringEntity params = new StringEntity(json.toString(), "UTF-8");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (response != null) {
                InputStream in = response.getEntity().getContent();
                System.out.println(in);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error, " + "Cannot Estabilish Connection");
        } finally {
//            driver.close();
        }
    }

    @Step("создаю вызов от СМП по api Взрослый по КЛАДР без МКАБ")
    public void createCallProfile6(String nameGen) {
        HttpClient httpClient = HttpClients.createDefault();

        JSONObject kladraddress = new JSONObject();
        kladraddress.put("addressString", "Белгородская обл., г. Белгород, ул. Есенина, д.11а, стр.2, корп.3, кв.4");
        kladraddress.put("addressStringMin", "Белгородская обл., г. Белгород, ул. Есенина");
        kladraddress.put("appartment", "4");
        kladraddress.put("building", "3");
        kladraddress.put("code", "31000001000007700");
        kladraddress.put("construction", "2");
        kladraddress.put("number", "11а");

        JSONObject json = new JSONObject();
        json.put("name", nameGen);
        json.put("family", "Тестов");
        json.put("ot", "Тестович");
        json.put("birthdate", "2000-01-01");
        json.put("seriespol", "404");
        json.put("numberpol", "501");
        json.put("gender", "1");
        json.put("complaint", "тестовый вызов по апи от СМП");
        json.put("diagnosis", "j20");
        json.put("type", "4");
        json.put("codedomophone", "12№#!@-тут символы");
        json.put("phone", "+79606223551");
        json.put("source", "2");
        json.put("sourceName", "СМП");
        json.put("sourceCode", "2");
        json.put("entrance", "12");
        json.put("floor", "5");
        json.put("kladraddress", kladraddress);

        try {
            HttpPost request = new HttpPost("http://12.8.1.126:2224/api/v2/smp/calldoctor/a7f391d4-d5d8-44d5-a770-f7b527bb1233");
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", "fb6e439f-c34f-4ee0-b2ba-38c1be5116a3");

            StringEntity params = new StringEntity(json.toString(), "UTF-8");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (response != null) {
                InputStream in = response.getEntity().getContent();
                System.out.println(in);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error, " + "Cannot Estabilish Connection");
        } finally {
//            driver.close();
        }
    }

    @Step("открыл страницу создания вызова")
    public void createCallBtn() {
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        click(addCallBtn);
        waitVisibility(noviyVizov);
    }
}