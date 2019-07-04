package services;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jayway.restassured.response.Response;
import config.Constants;
import core.BaseAbstract;
import helpers.Helper;
import webServices.RequestService;

import java.util.List;

/**
 * Methods for implementing service logic
 */
public class Services extends BaseAbstract {

    public JsonObject executePostRequestAndReturnRequestBody(String additionalURL, JsonObject requestBody) {

        Helper helper = new Helper();
        RequestService requestService = new RequestService();

        Response response = requestService.Post(additionalURL, requestBody.toString(), origin);

        return helper.createResponseBodyJsonObject(response);
    }

    private JsonArray executeGetRequestAndReturnRequestBodyAsJsonArray(String additionalURL) {

        Helper helper = new Helper();
        RequestService requestService = new RequestService();

        Response response = requestService.Get(additionalURL);

        return helper.createResponseBodyJsonArray(response);
    }

    public JsonObject createList(String additionalURL) {

        Helper helper = new Helper();

        JsonObject listRequestBody = helper.createRequestBody(Constants.listTemplateFilePath);

        return executePostRequestAndReturnRequestBody(additionalURL, listRequestBody);
    }

    public void archiveLists() {

        Helper helper = new Helper();
        RequestService requestService = new RequestService();

        JsonObject requestBody = helper.createRequestBody(Constants.archiveListTemplateFilePath);

        JsonArray responseBody = executeGetRequestAndReturnRequestBodyAsJsonArray(getOpenListWelcomeToTrelloBoardFullAdditionalUrl);

        List<String> values = helper.getSameValuesFromJson(responseBody, "id");

        values.parallelStream().forEach(value -> requestService.Put("1/lists/" + value, requestBody.toString(), origin));
    }
}