package stepDefinitions;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonStepDefinitions {
    private static Response response;

    @When("a GET request is made to ottplatform media api endpoint")
    public void a_get_request_is_made_to_ottplatform_media_api_endpoint() {
        RestAssured.baseURI = "https://testapi.io/api/ottplatform/media";
        RequestSpecification request = RestAssured.given();
        response = request.request(Method.GET);
    }

    public Response getResponse() {
        return response;
    }
}
