package api;

import com.jayway.restassured.http.ContentType;
import config.Constants;
import io.qameta.allure.Step;
import pojo.ArchiveList;
import pojo.List;

import static com.jayway.restassured.RestAssured.given;

public class ListClient extends Client<ListClient> {

    private String welcomeToTrelloBoardId = "5d132cead342b156efed967a";
    private String getListsEndpoint = "1/boards/";
    private String archiveListsEndpoint = "1/lists/";
    private String createListEndpoint = "1/lists?idBoard=&idListSource=&key=";

    @Override
    protected ListClient getType() {
        return this;
    }

    @Step("Create List")
    public ListClient createList(List list) {

        setResponse(given().pathParam("key", Constants.key).pathParam("token", Constants.token)
                .contentType(ContentType.JSON).body(list).post(createListEndpoint + "{key}&token={token}"));
        return this;
    }

    @Step("Get Lists")
    public ListClient getLists() {

        setResponse(given().pathParam("key", Constants.key).pathParam("token", Constants.token).pathParam("welcomeToTrelloBoardId", welcomeToTrelloBoardId)
                .contentType(ContentType.JSON).get(getListsEndpoint + "{welcomeToTrelloBoardId}/lists?fields=all&filter=open&key={key}&token={token}"));
        return this;
    }

    @Step("Archive List")
    public ListClient archiveLists(ArchiveList list, String value) {

        setResponse(given().contentType(ContentType.JSON).body(list).put(archiveListsEndpoint + value));
        return this;
    }
}