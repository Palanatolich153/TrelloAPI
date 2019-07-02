package dto.card;

public class BadgeDto {

    private long votes;
    private boolean viewingMemberVoted;
    private boolean subscribed;
    private String fogbugz;
    private long checkItems;
    private long checkItemsChecked;
    private long comments;
    private long attachments;
    private boolean description;
    private long due;
    private boolean dueComplete;

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

    public boolean isViewingMemberVoted() {
        return viewingMemberVoted;
    }

    public void setViewingMemberVoted(boolean viewingMemberVoted) {
        this.viewingMemberVoted = viewingMemberVoted;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public String getFogbugz() {
        return fogbugz;
    }

    public void setFogbugz(String fogbugz) {
        this.fogbugz = fogbugz;
    }

    public long getCheckItems() {
        return checkItems;
    }

    public void setCheckItems(long checkItems) {
        this.checkItems = checkItems;
    }

    public long getCheckItemsChecked() {
        return checkItemsChecked;
    }

    public void setCheckItemsChecked(long checkItemsChecked) {
        this.checkItemsChecked = checkItemsChecked;
    }

    public long getComments() {
        return comments;
    }

    public void setComments(long comments) {
        this.comments = comments;
    }

    public long getAttachments() {
        return attachments;
    }

    public void setAttachments(long attachments) {
        this.attachments = attachments;
    }

    public boolean isDescription() {
        return description;
    }

    public void setDescription(boolean description) {
        this.description = description;
    }

    public long getDue() {
        return due;
    }

    public void setDue(long due) {
        this.due = due;
    }

    public boolean isDueComplete() {
        return dueComplete;
    }

    public void setDueComplete(boolean dueComplete) {
        this.dueComplete = dueComplete;
    }
}