package tests;

import api.CardClient;
import api.ListClient;
import com.github.javafaker.Faker;
import core.BaseClass;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import pojo.Card;
import pojo.List;

public class TrelloTestController extends BaseClass {

    @Test
    public void createListSimpleApproach() {

        List list = List.builder().build();

        new ListClient()
                .createList(list)
                .verifyStatusCode(HttpStatus.SC_OK)
                .verifyJsonBody(list);
    }

    @Test
    public void createCardSimpleApproach() {

        Faker faker = new Faker();
        Card card = Card.builder().build();

        String cardName = faker.name().username();

        new CardClient()
                .createCard(cardName, card)
                .verifyStatusCode(HttpStatus.SC_OK)
                .verifyJsonFieldValue("name", cardName);
    }
}