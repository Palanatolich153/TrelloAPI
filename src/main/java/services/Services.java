package services;

import api.ListClient;
import com.google.gson.JsonArray;
import com.jayway.restassured.response.Response;
import helpers.Helper;

import java.util.List;

public class Services {

    private JsonArray executeGetRequestAndReturnRequestBodyAsJsonArray() {

        Helper helper = new Helper();

        Response response = new ListClient().getLists().getResponse();

        return helper.createResponseBodyJsonArray(response);
    }

    public void archiveLists() {

        Helper helper = new Helper();

        ListClient listClient = new ListClient();

        pojo.ArchiveList list = pojo.ArchiveList.builder().build();

        JsonArray responseBody = executeGetRequestAndReturnRequestBodyAsJsonArray();

        List<String> values = helper.getSameValuesFromJson(responseBody, "id");

        values.parallelStream().forEach(value -> listClient.archiveLists(list, value));
    }
}