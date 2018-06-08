package pages.calldoctor;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.utilities.JSWaiter;

import static org.testng.AssertJUnit.assertTrue;

public class EditCardPage extends BasePage {

    @FindBy(xpath = "//addCallBtn[@id='btn_delete']/span[2]")
    WebElement deleteShedule;

    @FindBy(xpath = "//span[contains(.,'СМП')]")
    WebElement SMP;

    @FindBy(xpath = "//button[@aria-label='Clear']/span/mat-icon")
    WebElement cancelAdress;

    @FindBy(xpath = "//div[@class='autocomplete-list-container']/ul/li")
    WebElement list_first_container;

    @FindBy(xpath = "//input[@placeholder='Адрес']")
    WebElement placeholder_adress;

    @FindBy(xpath = "//div[@class='autocomplete-list-container'")
    WebElement containerKladr;

    @FindBy(xpath = "//input[@placeholder='Дом']")
    WebElement dom;

    @FindBy(xpath = "//*[@mattooltip='Добавить вызов']")
    WebElement addCallBtn;

    @FindBy(xpath = "//span/mat-icon")
    WebElement mat_icon;

    @FindBy(id = "phone")
    WebElement telephoneNumber;

    @FindBy(xpath = "//label[@class='mat-checkbox-layout']/div")
    WebElement chkBoxTelephone;

    @FindBy(xpath = "//button[2]/span/mat-icon")
    WebElement hz;

    @FindBy(xpath = "//input[@placeholder='Возр. категория']")
    WebElement vozr;

    @FindBy(xpath = "//span[contains(.,'Взрослый')]")
    WebElement hz2;

    @FindBy(xpath = "//input[@placeholder='Корпус']")
    WebElement korpus;

    @FindBy(xpath = "//input[@placeholder='Строение']")
    WebElement stroenie;

    @FindBy(xpath = "//input[@placeholder='Квартира']")
    WebElement kvartira;

    @FindBy(xpath = "//input[@placeholder='П-д']")
    WebElement pd;

    @FindBy(xpath = "//input[@placeholder='Д-фон']")
    WebElement dfon;

    @FindBy(xpath = "//input[@placeholder='Этаж']")
    WebElement etazh;

    @FindBy(xpath = "//input[@aria-label='Введите текст жалобы']")
    WebElement zhaloba;

    @FindBy(xpath = "//input[@placeholder='Серия']")
    WebElement seriyaPol;

    @FindBy(xpath = "//input[@placeholder='Номер полиса']")
    WebElement nomerPol;

    @FindBy(xpath = "//input[@placeholder='Фамилия']")
    WebElement fam;

    @FindBy(xpath = "//input[@placeholder='Имя']")
    WebElement name;

    @FindBy(xpath = "//input[@placeholder='Отчество']")
    WebElement otchestvo;

    @FindBy(xpath = "//input[@placeholder='Тип вызывающего']")
    WebElement tipVisivaushego;

    @FindBy(xpath = "//input[@placeholder='Вид вызова']")
    WebElement vidVisova;

    @FindBy(xpath = "//span[contains(.,'Пациент')]")
    WebElement pacient;

    @FindBy(xpath = "//span[contains(.,'Представитель')]")
    WebElement predstav;

    @FindBy(xpath = "//span[contains(.,'Неотложный')]")
    WebElement neotlozhniy;

    @FindBy(xpath = "//button[3]/span/span")
    WebElement saveBtns;

    @FindBy(id = "callFamily")
    WebElement callFamily;

    @FindBy(id = "callName")
    WebElement callName;

    @FindBy(id = "callPatronymic")
    WebElement callPatronymic;

    @FindBy(xpath = "//div[@style='width: 50%; background-color: rgb(23, 150, 112);']")
    WebElement thisDayLoadGreen;

    @FindBy(xpath = "//div[@style='width: 50%; background-color: rgb(252, 194, 54);']")
    WebElement thisDayLoadYellow;

    @FindBy(xpath = "//span[contains(.,'Назначить на сегодня')]")
    WebElement appenOnThisDay;

    @FindBy(xpath = "//div[contains(.,'Найдена МКАБ пациента Петров')]")
    WebElement naidena_mkab;

    public EditCardPage(WebDriver driver) {
        super(driver);
    }

    public void editCallToMkab2() throws InterruptedException {
        Actions action = new Actions(driver);
/*адрес*/
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));
        click(cancelAdress);
        click(placeholder_adress);

        placeholder_adress.sendKeys("Московская");
        click(list_first_container);

        placeholder_adress.sendKeys("Коломна");
        click(list_first_container);

        placeholder_adress.sendKeys("Первомайская");
        click(list_first_container);

/*обязательные поля*/
        dom.clear();
        click(dom);
        dom.sendKeys("1");

//        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
//        jse1.executeScript("arguments[0].value='+7 (951) 158-27-14';", telephoneNumber);
//        click(telephoneNumber);
//        action.sendKeys(Keys.ENTER);
        click(chkBoxTelephone);
        click(hz);
        click(vozr);
        hz2.click();

/*необязательные поля*/
        korpus.clear();
        korpus.sendKeys("2");
        stroenie.clear();
        stroenie.sendKeys("3");
        kvartira.clear();
        kvartira.sendKeys("4");
        pd.clear();
        pd.sendKeys("5");
        dfon.clear();
        dfon.sendKeys("6");
        etazh.clear();
        etazh.sendKeys("7");

/*жалоба*/
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='автотест';", zhaloba);
        zhaloba.sendKeys(Keys.SPACE);
        action.sendKeys(Keys.ENTER).perform();

/*кто пациент*/
        seriyaPol.clear();
        seriyaPol.sendKeys("321");
        nomerPol.clear();
        nomerPol.sendKeys("54321");
//        click(fam);
//        fam.sendKeys("Автотемников");
//        name.sendKeys("Автодмитрий");
//        otchestvo.sendKeys("Автоолегович");

/*кто вызывает*/
        tipVisivaushego.click();
        predstav.click();
//        click(callFamily);
        callFamily.clear();
        callFamily.sendKeys("Автотемниковизменил");
        callName.clear();
        callName.sendKeys("Автодмитрийизменил");
        callPatronymic.clear();
        callPatronymic.sendKeys("Автоолеговичизменил");

        assertTrue(naidena_mkab.isEnabled());
        saveBtns.click();
    }

    public void verifyCallMkabNew() throws InterruptedException {
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Редактирование вызова')]")));

        Thread.sleep(700);
        containsClickable("Дата");
        containsClickable("Время");
        containsClickable("Статус");
        containsClickable("Вид вызова");
        containsClickable("Источник");
        containsClickable("АДРЕС");
        containsClickable("ЖАЛОБЫ");
        containsClickable("Возрастная категория");
        containsClickable("КТО ПАЦИЕНТ");
        containsClickable("КТО ВЫЗВАЛ");
        containsClickable("КТО ОБСЛУЖИВАЕТ");
        containsClickable("Телефон");
        containsClickable("Врач");
        containsClickable("ИСТОРИЯ ВЫЗОВА");
        containsClickable("АВТОР");
        containsClickable("ЧТО ИЗМЕНИЛОСЬ");
        containsClickable("ИЗМЕНЕНИЕ");
        containsClickable("Отменить вызов");
        containsClickable("Изменить");
        containsClickable("Передать в другое ЛПУ");

        containsClickable("Московская обл., г. Коломна, ул. Первомайская, д.1, корп.2, стр.3, кв.4");
        containsClickable("Новый");
        containsClickable("Первичный");
        containsClickable("Регистратура");
        containsClickable("Афанасьева");
        containsClickable("Софья");
        containsClickable("Петровна");
        containsClickable("");
        containsClickable("7854215965847521");
        containsClickable("Представитель");
        containsClickable("Карта создана");
        containsClickable("автотест");
        containsClickable("19.02.2016");
        containsClickable("2 года");
        containsClickable("Ребенок");
        containsClickable("Автотемников");
        containsClickable("Автодмитрий");
        containsClickable("Автоолегович");
        containsClickable("Не назначен");

    }

    public void editCallBtn() {
        JSWaiter.waitJQueryAngular();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

        WebElement dynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[contains(., 'Карта вызова')]")));


        WebElement appoindBtns = driver.findElement(By.xpath("//span[contains(text(),'Изменить')]"));
        wait.until(ExpectedConditions.elementToBeClickable(appoindBtns));
        appoindBtns.click();

    }

    public void saveCallBtn() {
        assertTrue(naidena_mkab.isEnabled());
        saveBtns.click();

    }
}