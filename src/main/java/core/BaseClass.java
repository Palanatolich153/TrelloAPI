package core;

import log.ListenerTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import services.Services;

import java.util.ArrayList;
import java.util.List;

@Listeners(ListenerTest.class)
public class BaseClass {

    protected List<String> listsForArchivation = new ArrayList<>();

    protected String origin = "https://developers.trello.com";
    protected String key = "661c41560774298c33984a8b5fa33df4";
    protected String token = "802a857ff7d4b3653b0e69c92652bc797a48328ca2b6bd763d0c4021a62d150f";
    protected String createListAdditionalURL = "1/lists?idBoard=&idListSource=&key=" + key + "&token=" + token;

    @AfterSuite
    public void afterSuiteActions(){

        Services services = new Services();

        services.archiveLists(listsForArchivation);
    }
}