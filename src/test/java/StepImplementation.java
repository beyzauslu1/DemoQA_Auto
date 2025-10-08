import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementHelper;
import utils.ValueHelper;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation {

    @Step("Go to google")
    public void goToGoogle() {
        Driver.start();
        Driver.webDriver.get("https://www.google.com");
    }

    @Step("Form sayfası açılır")
    public void openFormPage() {
        Driver.start();
        Driver.webDriver.get("https://demoqa.com/automation-practice-form");
    }

    @Step("Form sayfası kontrol edilir")
    public void checkFormPage() {
        String currentUrl = Driver.webDriver.getCurrentUrl();
        assertThat(currentUrl).contains("automation-practice-form");

        WebElement header = ElementHelper.getElement(Driver.webDriver, "formHeader");
        assertThat(header.getText()).contains("Practice Form");
    }
    @Step("Girilen isim kontrol edilir")
    public void checkFirstName() {
        WebElement input = Driver.webDriver.findElement(By.id("firstName"));
        String value = input.getAttribute("value");
        if (value == null || value.isEmpty()) {
            throw new AssertionError("First name alanı boş!");
        }
    }

    @Step("Girilen soyisim kontrol edilir")
    public void checkLastName() {
        WebElement input = Driver.webDriver.findElement(By.id("lastName"));
        String value = input.getAttribute("value");
        if (value == null || value.isEmpty()) {
            throw new AssertionError("Last name alanı boş!");
        }
    }

    @Step("Girilen email kontrol edilir")
    public void checkEmail() {
        WebElement input = Driver.webDriver.findElement(By.id("userEmail"));
        String value = input.getAttribute("value");
        if (value == null || !value.contains("@")) {
            throw new AssertionError("Geçersiz email: " + value);
        }
    }

    @Step("<field> alanına <valueKey> verisi girilir")
    public void enterValue(String field, String valueKey) {
        WebElement input = ElementHelper.getElement(Driver.webDriver, field);
        String value = ValueHelper.getValue(valueKey);

        input.clear();
        input.sendKeys(value);

        // autocomplete varsa ENTER
        input.sendKeys(Keys.ENTER);
    }

    @Step("<field> butonuna tıklanır")
    public void clickButton(String field) {
        WebElement button = ElementHelper.getElement(Driver.webDriver, field);
        ((JavascriptExecutor) Driver.webDriver).executeScript("arguments[0].click();", button);
    }

    @Step("<field> alanı hata vermeli")
    public void checkError(String field) {
        WebElement element = ElementHelper.getElement(Driver.webDriver, field);
        String validationMessage = element.getAttribute("validationMessage");
        assertThat(validationMessage).isNotEmpty();
        System.out.println(field + " hata: " + validationMessage);
    }

    @Step("Form gönderilmemelidir")
    public void checkFormNotSubmitted() {
        List<WebElement> modals = Driver.webDriver.findElements(By.id("example-modal-sizes-title-lg"));
        assertThat(modals).isEmpty();
    }

    @Step("Gender alanı <genderKey> seçilir")
    public void selectGender(String genderKey) {
        String gender = ValueHelper.getValue(genderKey);
        WebElement element = Driver.webDriver.findElement(By.xpath("//label[text()='" + gender + "']"));
        ((JavascriptExecutor) Driver.webDriver).executeScript("arguments[0].click();", element);
    }

    @Step("hobbies alanına <hobbyKey> verisi girilir")
    public void selectHobby(String hobbyKey) {
        String hobby = ValueHelper.getValue(hobbyKey);
        WebElement checkbox = Driver.webDriver.findElement(By.xpath("//label[text()='" + hobby + "']"));
        ((JavascriptExecutor) Driver.webDriver).executeScript("arguments[0].click();", checkbox);
    }

    @Step("state alanına <stateKey> verisi girilir")
    public void selectState(String stateKey) {
        String state = ValueHelper.getValue(stateKey);
        WebDriverWait wait = new WebDriverWait(Driver.webDriver, Duration.ofSeconds(10));
        WebElement stateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-3-input")));
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
    }

    @Step("City alanına <cityKey> verisi girilir")
    public void selectCity(String cityKey) {
        String city = ValueHelper.getValue(cityKey);
        WebDriverWait wait = new WebDriverWait(Driver.webDriver, Duration.ofSeconds(10));
        WebElement cityInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-4-input")));
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
    }

    @Step("date alanına <dateKey> verisi girilir")
    public void selectDate(String dateKey) {
        String date = ValueHelper.getValue(dateKey);
        WebElement dateInput = ElementHelper.getElement(Driver.webDriver, "dateOfBirth");
        dateInput.sendKeys(Keys.CONTROL + "a");
        dateInput.sendKeys(date);
        dateInput.sendKeys(Keys.ENTER);
    }

    @Step("<field> alanına <fileKey> dosyası yüklenir")
    public void uploadFile(String field, String fileKey) {
        WebElement uploadInput = ElementHelper.getElement(Driver.webDriver, field);
        String filePath = ValueHelper.getValue(fileKey);
        uploadInput.sendKeys(filePath);
    }

    @Step("Yüklenen dosya adı formda görünmelidir")
    public void checkUploadedFileName() {
        WebElement uploaded = ElementHelper.getElement(Driver.webDriver, "uploadPicture");
        String fileName = uploaded.getAttribute("value");
        assertThat(fileName).contains("metin.txt");
    }

    @Step("Form başarıyla kaydedilmeli")
    public void checkFormSubmit() {
        WebElement modal = Driver.webDriver.findElement(By.id("example-modal-sizes-title-lg"));
        assertThat(modal.isDisplayed()).isTrue();
    }

    @Step("Formda state bilgisi görünmemelidir")
    public void verifyStateNotDisplayed() {
        List<WebElement> cells = Driver.webDriver.findElements(By.xpath("//td[text()='State and City']/following-sibling::td"));
        if (!cells.isEmpty()) {
            assertThat(cells.get(0).getText()).isEmpty();
        }
    }

    @Step("<field> alanında sadece rakam kalmalı")
    public void fieldShouldContainOnlyDigits(String field) {
        WebElement input = ElementHelper.getElement(Driver.webDriver, field);
        String value = input.getAttribute("value");
        assertThat(value).matches("\\d+");
    }

}
