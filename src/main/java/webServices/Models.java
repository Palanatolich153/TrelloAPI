package webServices;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.ResponseSpecification;

import static com.jayway.restassured.RestAssured.given;

public class Models {

    private String headerData;
    private String requestModel;

    public Models(String requestModel, String headerData) {

        this.headerData = headerData;
        this.requestModel = requestModel;
    }

    public Models() {
    }

    public ResponseSpecification setHeadersForPostRequest() {

        ResponseSpecification responseSpecification =
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("Origin", headerData)
                        .body(requestModel)
                        .expect()
                        .when();

        return responseSpecification;
    }

    public ResponseSpecification setHeadersForGetRequest() {

        ResponseSpecification responseSpecification =
                given()
                        .header("Accept", "application/json, text/plain, */*")
                        .expect()
                        .when();

        return responseSpecification;
    }

    public ResponseSpecification setHeadersForPutRequest() {

        ResponseSpecification responseSpecification =
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("Origin", headerData)
                        .body(requestModel)
                        .expect()
                        .when();

        return responseSpecification;
    }
}