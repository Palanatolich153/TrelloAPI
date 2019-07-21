package core;

import log.ListenerTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import services.Services;

@Listeners(ListenerTest.class)
public class BaseClass extends BaseAbstract {

    @AfterSuite
    public void afterSuiteActions() {

        Services services = new Services();

        //Archive all opened lists after test suite finished
        services.archiveLists();
    }
}