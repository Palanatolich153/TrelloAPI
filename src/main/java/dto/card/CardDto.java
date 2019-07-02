package dto.card;


import dto.card.descData.DescDataDto;

import java.util.List;

public class CardDto {

    private String id;
    private BadgeDto badges;
    private List checkItemStates;
    private boolean closed;
    private boolean dueComplete;
    private String dateLastActivity;
    private String desc;
    private DescDataDto descData;
    private String email;
    private String idBoard;
    private List idChecklists;
    private String idList;
    private List<String> idMembers;
    private List<String> idMembersVoted;
    private int idShort;
    private String idAttachmentCover;
    private boolean manualCoverAttachment;
    private List<LabelDto> labels;
    private List<String> idLabels;
    private String name;
    private long pos;
    private String shortLink;
    private String shortUrl;
    private boolean subscribed;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BadgeDto getBadges() {
        return badges;
    }

    public void setBadges(BadgeDto badges) {
        this.badges = badges;
    }

    public List getCheckItemStates() {
        return checkItemStates;
    }

    public void setCheckItemStates(List checkItemStates) {
        this.checkItemStates = checkItemStates;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isDueComplete() {
        return dueComplete;
    }

    public void setDueComplete(boolean dueComplete) {
        this.dueComplete = dueComplete;
    }

    public String getDateLastActivity() {
        return dateLastActivity;
    }

    public void setDateLastActivity(String dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DescDataDto getDescData() {
        return descData;
    }

    public void setDescData(DescDataDto descData) {
        this.descData = descData;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public List getIdChecklists() {
        return idChecklists;
    }

    public void setIdChecklists(List idChecklists) {
        this.idChecklists = idChecklists;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public List<String> getIdMembers() {
        return idMembers;
    }

    public void setIdMembers(List<String> idMembers) {
        this.idMembers = idMembers;
    }

    public List<String> getIdMembersVoted() {
        return idMembersVoted;
    }

    public void setIdMembersVoted(List<String> idMembersVoted) {
        this.idMembersVoted = idMembersVoted;
    }

    public int getIdShort() {
        return idShort;
    }

    public void setIdShort(int idShort) {
        this.idShort = idShort;
    }

    public String getIdAttachmentCover() {
        return idAttachmentCover;
    }

    public void setIdAttachmentCover(String idAttachmentCover) {
        this.idAttachmentCover = idAttachmentCover;
    }

    public boolean isManualCoverAttachment() {
        return manualCoverAttachment;
    }

    public void setManualCoverAttachment(boolean manualCoverAttachment) {
        this.manualCoverAttachment = manualCoverAttachment;
    }

    public List<LabelDto> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelDto> labels) {
        this.labels = labels;
    }

    public List<String> getIdLabels() {
        return idLabels;
    }

    public void setIdLabels(List<String> idLabels) {
        this.idLabels = idLabels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPos() {
        return pos;
    }

    public void setPos(long pos) {
        this.pos = pos;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return "Name: '" + this.name + "', id: '" + this.id + "', closed: '" + this.closed + "'";
    }
}