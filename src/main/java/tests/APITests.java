package tests;

import com.google.gson.JsonObject;
import com.jayway.restassured.response.Response;
import config.Constants;
import core.BaseClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import services.Services;
import webServices.RequestService;

public class APITests extends BaseClass {

    @Test
    public void createList() {

        Services services = new Services();
        SoftAssert assertion = new SoftAssert();
        RequestService requestService = new RequestService();

        JsonObject requestBody = services.createRequestBody(Constants.listTemplateFilePath);

        Response response = requestService.Post(createListAdditionalURL, requestBody.toString(), origin);

        JsonObject responseBody = services.createResponseBody(response);

        listsForArchivation.add(responseBody.get("id").toString());

        assertion.assertEquals(requestBody.get("name"), responseBody.get("name"));
        assertion.assertAll();
    }
}