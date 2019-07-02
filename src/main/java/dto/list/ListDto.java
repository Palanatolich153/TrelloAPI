package dto.list;

public class ListDto {

    private String id;
    private String name;
    private boolean closed;
    private String idBoard;
    private double pos;
    private boolean subscribed;
    private LimitsDto limits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public double getPos() {
        return pos;
    }

    public void setPos(double pos) {
        this.pos = pos;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public LimitsDto getLimits() {
        return limits;
    }

    public void setLimits(LimitsDto limits) {
        this.limits = limits;
    }

    public String toString() {
        return "Name: '" + this.name + "', id: '" + this.id + "', closed: '" + this.closed + "'";
    }
}