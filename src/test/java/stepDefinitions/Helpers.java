package stepDefinitions;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class Helpers {

    public JSONArray getJSONArrayFromResponse(Response response) {
        JSONObject jsonObject = new JSONObject(response.asString());
        return new JSONArray(jsonObject.getJSONArray("data"));
    }
}
