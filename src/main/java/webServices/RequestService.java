package webServices;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.ResponseSpecification;
import config.URLs;

import java.net.URI;
import java.net.URISyntaxException;

public class RequestService {

    /**
     * Creating the Post Request
     */
    public Response Post(String additionalURL, String requestModel, String headerData) {

        Response response = null;

        Models requestModels = new Models(requestModel, headerData);

        ResponseSpecification responseSpecification = requestModels.setHeadersForPostRequest();

        try {
            response = responseSpecification.post(new URI(URLs.generalPartOfURL + additionalURL)).thenReturn();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return response;
    }

    public Response Get(String additionalURL) {

        Models requestModels = new Models();

        ResponseSpecification responseSpecification = requestModels.setHeadersForGetRequest();

        Response response = null;
        try {
            response = responseSpecification.get(new URI(URLs.generalPartOfURL + additionalURL)).thenReturn();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return response;
    }

    public Response Put(String additionalURL, String requestModel, String headerData) {

        Models requestModels = new Models(requestModel, headerData);

        ResponseSpecification responseSpecification = requestModels.setHeadersForPutRequest();

        Response response = null;
        try {
            response = responseSpecification.put(new URI(URLs.generalPartOfURL + additionalURL)).thenReturn();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return response;
    }
}