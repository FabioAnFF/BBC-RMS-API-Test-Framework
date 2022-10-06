package stepDefinitions;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.junit.Assert;

import java.util.*;

public class APITestsStepDefinitions {
    Helpers helpers = new Helpers();
    CommonStepDefinitions request = new CommonStepDefinitions();
    Response response = request.getResponse();


    @Then("id field for every track has a value")
    public void id_field_for_every_track_has_a_value() {
        JSONArray jsonArray = helpers.getJSONArrayFromResponse(response);
        for(int i = 0; i < jsonArray.length(); i++) {
            Assert.assertNotNull(jsonArray.getJSONObject(i).getString("id"));
            Assert.assertFalse(jsonArray.getJSONObject(i).getString("id").isEmpty());
        }

    }
    @Then("segment_type is {string} for every track")
    public void segment_type_is_for_every_track(String segmentType) {
       JSONArray jsonArray = helpers.getJSONArrayFromResponse(response);
        for (int i = 0; i < jsonArray.length(); i++) {
            Assert.assertEquals(segmentType, jsonArray.getJSONObject(i).getString("segment_type"));
        }
    }

    @Then("primary field in title_list of each track should have a value")
    public void primary_field_in_title_list_of_each_track_should_have_a_value() {
        JSONArray jsonArray = helpers.getJSONArrayFromResponse(response);
        for (int i = 0; i < jsonArray.length(); i++) {
            Assert.assertNotNull(jsonArray.getJSONObject(i).getJSONObject("title_list").getString("primary"));
            Assert.assertFalse(jsonArray.getJSONObject(i).getJSONObject("title_list").getString("primary").isEmpty());
        }
    }

    @Then("only one track should have the now_playing field set to true")
    public void only_one_track_should_have_the_now_playing_field_set_to_true() {
        List<Boolean> tracksPlayingList = new ArrayList<>();
        JSONArray jsonArray = helpers.getJSONArrayFromResponse(response);
        for (int i = 0; i < jsonArray.length(); i++) {
            Boolean isCurrentlyPlaying = jsonArray.getJSONObject(i).getJSONObject("offset").getBoolean("now_playing");
            tracksPlayingList.add(isCurrentlyPlaying);
        }
        Assert.assertEquals(1, Collections.frequency(tracksPlayingList,true));
    }

    @Then("Date exists in response headers")
    public void date_exists_in_response_headers() {
        Assert.assertTrue(response.headers().hasHeaderWithName("Date"));
    }

    @Then("Date response header value is not empty")
    public void date_response_header_value_is_not_empty() {
        Assert.assertFalse(response.header("Date").isEmpty());
    }
}
