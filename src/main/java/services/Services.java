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

    public JsonObject executePostRequestAndReturnRequestBody(String endpoint, JsonObject requestBody) {

        Helper helper = new Helper();
        RequestService requestService = new RequestService();

        Response response = requestService.Post(endpoint, requestBody.toString(), origin);

        return helper.createResponseBodyJsonObject(response);
    }

    private JsonArray executeGetRequestAndReturnRequestBodyAsJsonArray(String endpoint) {

        Helper helper = new Helper();
        RequestService requestService = new RequestService();

        Response response = requestService.Get(endpoint);

        return helper.createResponseBodyJsonArray(response);
    }

    public JsonObject createList(String endpoint) {

        Helper helper = new Helper();

        //Create a List
        JsonObject listRequestBody = helper.createRequestBody(Constants.listTemplateFilePath);
        return executePostRequestAndReturnRequestBody(endpoint, listRequestBody);
    }

    public void archiveLists() {

        Helper helper = new Helper();
        RequestService requestService = new RequestService();

        JsonObject requestBody = helper.createRequestBody(Constants.archiveListTemplateFilePath);

        JsonArray responseBody = executeGetRequestAndReturnRequestBodyAsJsonArray(getOpenListWelcomeToTrelloBoardFullEndpoint);

        List<String> values = helper.getSameValuesFromJson(responseBody, "id");

        values.parallelStream().forEach(value -> requestService.Put("1/lists/" + value, requestBody.toString(), origin));
    }
}