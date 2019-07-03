package core;

public abstract class BaseAbstract {

    private String key = "661c41560774298c33984a8b5fa33df4";
    private String token = "802a857ff7d4b3653b0e69c92652bc797a48328ca2b6bd763d0c4021a62d150f";
    protected String createListAdditionalURL = "1/lists?idBoard=&idListSource=&key=" + key + "&token=" + token;
    protected String createCardAdditionalURL = "1/cards?name=";
    private String getListsAdditionalURL = "1/boards/";
    protected String origin = "https://developers.trello.com";
    private String welcomeToTrelloBoardId = "5d132cead342b156efed967a";
    protected String getOpenListWelcomeToTrelloBoardFullAdditionalUrl = getListsAdditionalURL + welcomeToTrelloBoardId +
            "/lists?fields=all&filter=open&key=" + key + "&token=" + token;
}