package api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import helpers.Helper;
import io.qameta.allure.Step;
import io.restassured.module.jsv.JsonSchemaValidator;
import lombok.Getter;
import lombok.Setter;
import net.javacrumbs.jsonunit.JsonAssert;
import net.javacrumbs.jsonunit.core.Option;
import org.testng.asserts.SoftAssert;

import java.io.File;

@Getter
@Setter
public abstract class Client<T> {

    protected abstract T getType();

    private Response response;

    @Step("Verify status code")
    public T verifyStatusCode(int expectedStatusCode) {

        response.then().assertThat().statusCode(expectedStatusCode);
        return getType();
    }

    @Step("Verify body matches json schema")
    public T verifyBodyMatchesJsonSchema(File expectedJsonSchema) {

        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(expectedJsonSchema));
        return getType();
    }

    @Step("Verify JSON body")
    public void verifyJsonBody(Object expectedBody) {

        String actualJsonBody = response.getBody().asString();
        String expectedJsonBody = new Gson().toJson(expectedBody);

        JsonAssert.assertJsonEquals(expectedJsonBody, actualJsonBody,
                JsonAssert.when(Option.IGNORING_EXTRA_FIELDS, Option.IGNORING_ARRAY_ORDER));
    }

    @Step("Verify JSON value")
    public void verifyJsonFieldValue(String path, String value) {

        SoftAssert assertion = new SoftAssert();

        JsonPath getData = new JsonPath(response.getBody().asString());

        assertion.assertEquals(getData.getString(path), value);
        assertion.assertAll();
    }

    @Step("Get Body as JSON Object")
    public JsonObject getBodyAsJsonObject() {

        Helper helper = new Helper();

        return helper.createResponseBodyJsonObject(response);
    }
}