package UI_Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.Resultspage;
import utils.TestDataParser;

import java.io.IOException;

public class BaseClassUI {

    WebDriver driver;
    protected Resultspage Resultspage;
    TestDataParser dataparser;

    @BeforeClass
    public void setup(ITestContext context) {
        //driver initlializations
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        //properties file;
        dataparser = new TestDataParser();

        try {
            dataparser.readFile("src/main/resources/testdata.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = dataparser.getPropertyValue("ResultsPage_URL");

        //open browser
        driver.get(url);
        Resultspage = new Resultspage(driver);

    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}


