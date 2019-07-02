package helpers;

import com.github.javafaker.Faker;
import com.google.gson.*;
import com.jayway.restassured.response.Response;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public JsonObject createRequestBody(String filePath) {

        Gson gson = new GsonBuilder().create();

        JtwigTemplate template = JtwigTemplate.classpathTemplate(filePath);
        JtwigModel model = JtwigModel.newModel().with("faker", new Faker());

        return gson.fromJson(template.render(model), JsonObject.class);
    }

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

    public List<String> getSameValuesFromJson(JsonArray body) {

        Gson gson = new Gson();
        List<String> values = new ArrayList<>();

        for (int i = 0; i < body.size(); i++) {
            JsonObject jsonObject = gson.fromJson(body.get(i), JsonObject.class);
            values.add(modifyString(jsonObject.get("id")));
        }
        return values;
    }
}