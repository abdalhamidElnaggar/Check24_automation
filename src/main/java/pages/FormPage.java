package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage {
    private WebDriver driver;
    public By email_input = By.xpath("//div[contains(@class, 'styles__FormPageWrapper')]//input[@id='cl_login']");
    public By btn_weiter = By.xpath("//div[contains(@class, 'styles__FormPageWrapper')]//button[@id='c24-uli-login-btn']");
    public By btn_ContinueAsGuest = By.xpath("//a[text()='als Gast fortfahren']");
    public By btn_weiter_new_user = By.xpath("//div[contains(@class, 'styles__FormPageWrapper')]//a[text()='weiter']");
    public By salution_error_msg = By.xpath("//label[text()='Bitte wählen Sie Ihre Anrede aus.']");
    public By firstname_error_msg = By.xpath("//label[text()='Bitte geben Sie Ihren Vornamen an.']");
    public By lastname_error_msg = By.xpath("//label[text()='Bitte geben Sie Ihren Nachnamen an.']");
    public By birthdate_error_msg = By.xpath("//label[text()='Bitte geben Sie Ihr Geburtsdatum an.']");
    public By mobilenumber_error_msg = By.xpath("//label[text()='Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer.']");
    public By firstname_input = By.id("GIVEN_NAME");
    public By lastname_input = By.id("LAST_NAME");
    public By birthdate_input = By.id("DATE_OF_BIRTH");
    public By mobilenumber_input = By.id("PHONENUMBER_MOBILE");
    public By herr_radiobtn = By.xpath("//label[@for='GENDER_MALE']");
    public By btn_weier_afterfillingform = By.xpath("//div[contains(@class, 'styles__FormPageWrapper')]//a[@target='_self']");
    public By other_personal_info_header = By.xpath("//h2[text()='Weitere persönliche Angaben']");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean checkTextMsgExist(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return !driver.findElements(by).isEmpty();
    }

    /**
     * type a text to webelement.
     *
     * @param by   the webelement to type at.
     * @param text text to be written
     */

    public void typeText(By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement webElement = driver.findElement(by);
        webElement.sendKeys(text);
    }


    /**
     * click on web element
     *
     * @param by the webelement to click on.
     */
    public void clickonElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement webElement = driver.findElement(by);

        try {

            webElement.click();
        } catch (Exception e) {

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", webElement);

        }
    }
}
