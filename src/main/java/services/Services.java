package services;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.jayway.restassured.response.Response;
import config.Constants;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.testng.Assert;
import webServices.RequestService;

import java.util.List;

public class Services {

    public JsonObject createRequestBody(String filePath) {

        Gson gson = new GsonBuilder().create();

        JtwigTemplate template = JtwigTemplate.classpathTemplate(filePath);
        JtwigModel model = JtwigModel.newModel().with("faker", new Faker());

        return gson.fromJson(template.render(model), JsonObject.class);
    }

    public JsonObject createResponseBody(Response response) {

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

    public void archiveLists(List<String> lists) {

        RequestService requestService = new RequestService();

        String listId;
        String origin = "https://developers.trello.com";

        int listsSize = lists.size();

        JsonObject requestBody = createRequestBody(Constants.archiveListTemplateFilePath);

        for (int i = 0; i < lists.size(); i++) {

            listId = lists.get(i);

            requestService.Put("1/lists/" + listId.substring(1, (listsSize - 1)), requestBody.toString(), origin);
        }
    }
}