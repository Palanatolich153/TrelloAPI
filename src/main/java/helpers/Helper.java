package helpers;

import com.google.gson.*;
import com.jayway.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Methods for implementing auxiliary logic
 */
public class Helper {

    public JsonObject createResponseBodyJsonObject(Response response) {

        Gson gson = new GsonBuilder().create();

        JsonObject jsonObject = null;

        try {
            jsonObject = gson.fromJson(response.getBody().asString(), JsonObject.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            Assert.fail("JsonSyntaxException happened in " + new Object() {
            }.getClass().getEnclosingMethod().getName());
        }
        return jsonObject;
    }

    public JsonArray createResponseBodyJsonArray(Response response) {

        Gson gson = new GsonBuilder().create();

        JsonArray jsonArray = null;

        try {
            jsonArray = gson.fromJson(response.getBody().asString(), JsonArray.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            Assert.fail("JsonSyntaxException happened in " + new Object() {
            }.getClass().getEnclosingMethod().getName());
        }
        return jsonArray;
    }

    public String modifyString(JsonElement element) {

        String elementToString = element.toString();

        return elementToString.substring(1, elementToString.length() - 1);
    }

    public List<String> getSameValuesFromJson(JsonArray body, String key) {

        Gson gson = new Gson();

        return IntStream.range(0, body.size()).
                mapToObj(index -> (modifyString(gson.fromJson(body.get(index), JsonObject.class).get(key)))).collect(Collectors.toList());
    }
}