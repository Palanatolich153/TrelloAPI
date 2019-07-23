package core;

import com.jayway.restassured.RestAssured;
import log.ListenerTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import services.Services;

@Listeners(ListenerTest.class)
public class BaseClass {

    @BeforeSuite
    public void beforeSuiteAction() {

        RestAssured.baseURI = "https://api.trello.com/";
    }

    @AfterSuite
    public void afterSuiteActions() {

        Services services = new Services();

        //Archive all opened lists after test suite finished
        services.archiveLists();
    }
}