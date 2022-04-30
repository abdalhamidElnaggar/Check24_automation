package RestAPI;

import org.testng.annotations.BeforeClass;
import utils.TestDataParser;

import java.io.IOException;

public class BaseClassAPIs {
    TestDataParser dataparser;
    String baseURI;

    @BeforeClass
    public void setup() {

        //read test data from properties file
        dataparser = new TestDataParser();
        try {
            dataparser.readFile("src/main/resources/testdata.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        baseURI = dataparser.getPropertyValue("EndPointURL");
    }
}
