package api;

import com.google.gson.JsonObject;
import com.jayway.restassured.http.ContentType;
import helpers.Helper;
import io.qameta.allure.Step;
import pojo.Card;
import pojo.List;

import static com.jayway.restassured.RestAssured.given;

public class CardClient extends Client<CardClient> {

    private String createCardEndpoint = "1/cards?name=";

    @Override
    protected CardClient getType() {
        return this;
    }

    @Step("Create List")
    public CardClient createCard(String cardName, Card card) {

        Helper helper = new Helper();

        List list = List.builder().build();

        JsonObject listRequestBody = new ListClient().createList(list).getBodyAsJsonObject();

        String createCardFullEndpoint = createCardEndpoint + cardName + "&idList=" + helper.modifyString(listRequestBody.get("id"));

        setResponse(given().contentType(ContentType.JSON).body(card).post(createCardFullEndpoint));

        return this;
    }
}