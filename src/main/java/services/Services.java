package services;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jayway.restassured.response.Response;
import config.Constants;
import core.BaseAbstract;
import helpers.Helper;
import webServices.RequestService;

import java.util.List;

public class Services extends BaseAbstract {

    public JsonObject executePostRequestAndReturnRequestBody(String additionalURL, JsonObject requestBody) {

        Helper helper = new Helper();
        RequestService requestService = new RequestService();

        Response response = requestService.Post(additionalURL, requestBody.toString(), origin);

        return helper.createResponseBodyJsonObject(response);
    }

    public JsonArray executeGetRequestAndReturnRequestBodyAsJsonArray(String additionalURL) {

        Helper helper = new Helper();
        RequestService requestService = new RequestService();

        Response response = requestService.Get(additionalURL);

        return helper.createResponseBodyJsonArray(response);
    }

    public JsonObject createList(String additionalURL) {

        Helper helper = new Helper();

        //Create a List
        JsonObject listRequestBody = helper.createRequestBody(Constants.listTemplateFilePath);
        return executePostRequestAndReturnRequestBody(additionalURL, listRequestBody);
    }

    public void archiveLists() {

        Helper helper = new Helper();
        RequestService requestService = new RequestService();

        String listId;
        String getListFullAdditionalUrl = getListsAdditionalURL + welcomeToTrelloBoardId + "/lists?fields=all&filter=open&key=" + key + "&token=" + token;

        JsonObject requestBody = helper.createRequestBody(Constants.archiveListTemplateFilePath);

        JsonArray responseBody = executeGetRequestAndReturnRequestBodyAsJsonArray(getListFullAdditionalUrl);

        List<String> values = helper.getSameValuesFromJson(responseBody);

        for (int i = 0; i < values.size(); i++) {

            listId = values.get(i);

            Response response = requestService.Put("1/lists/" + listId, requestBody.toString(), origin);

            System.out.println(response.getStatusCode());
            System.out.println(response.getBody().asString());
        }
    }
}