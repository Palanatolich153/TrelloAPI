package webServices;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.ResponseSpecification;

import static com.jayway.restassured.RestAssured.given;

/**
 * Methods for implementing request models
 */
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

        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Origin", headerData)
                .body(requestModel)
                .expect()
                .when();
    }

    public ResponseSpecification setHeadersForGetRequest() {

        return given()
                .header("Accept", "application/json, text/plain, */*")
                .expect()
                .when();
    }

    public ResponseSpecification setHeadersForPutRequest() {

        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Origin", headerData)
                .body(requestModel)
                .expect()
                .when();
    }
}