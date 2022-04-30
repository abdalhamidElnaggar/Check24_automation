package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Resultspage {

    private WebDriver driver;
    By btn_weiter_results = By.xpath("//div[@id='501140']//a[text()='weiter']");
    By btn_accept_cookies = By.xpath("//a[text()='Akzeptieren']");

    public Resultspage(WebDriver driver) {
        this.driver = driver;
    }

    public FormPage clickOnWeiter()
    {
        clickOnAcceptCookies();
        driver.findElement(btn_weiter_results).click();
        return  new FormPage(driver);
    }
    private void clickOnAcceptCookies()
    {

        driver.findElement(btn_accept_cookies).click();
    }

    public String getCookie(String cookiename)
    {
      return  driver.manage().getCookieNamed(cookiename).getValue();
    }


}
