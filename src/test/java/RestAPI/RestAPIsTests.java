package RestAPI;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAPIsTests extends BaseClassAPIs {

    @Test(priority = 1)
    public void checkNotFound() {
        String notFoundProduct = baseURI + dataparser.getPropertyValue("Id_notFound");
        var response = given()
                .get(notFoundProduct).then();
        response.assertThat().statusCode(404).body("message", equalTo("HTTP 404 Not Found"))
                .header("Content-Type", equalTo("application/json;charset=UTF-8"));


    }


    @Test(priority = 2)
    public void checkNoContent() {
        String noContent = baseURI + dataparser.getPropertyValue("Id_noContent");
        var response = given()
                .get(noContent).then();
        response.assertThat().statusCode(204);

    }

    @Test(priority = 2)
    public void checkValidContent() {
        String validProduct = baseURI + dataparser.getPropertyValue("Id_validcontent");
        var response = given()
                .get(validProduct).then();

        response.assertThat().statusCode(200).
                body("productId", equalTo(0)).header("Content-Type", equalTo("application/json;charset=UTF-8"));


    }
}

