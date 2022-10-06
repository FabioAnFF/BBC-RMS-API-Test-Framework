package stepDefinitions;

import io.cucumber.java.en.Then;

import io.restassured.response.Response;
import org.junit.Assert;

public class ApiHealthStepDefinitions {

    CommonStepDefinitions request = new CommonStepDefinitions();
    Response response = request.getResponse();
    @Then("response code should be {int}")
    public void response_code_should_be_n(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }
    @Then("response time should be less than {int} ms")
    public void response_time_should_be_less_than_n_ms(int maximumResponseTime) {
        Assert.assertTrue(String.format("Response took %d ms. Expected less than %d ms", response.getTime(), maximumResponseTime), response.getTime() < maximumResponseTime);
    }
}
