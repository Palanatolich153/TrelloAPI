package dto.list;

public class TotalPerListDto {

    private String status;
    private long disableAt;
    private long warnAt;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getDisableAt() {
        return disableAt;
    }

    public void setDisableAt(long disableAt) {
        this.disableAt = disableAt;
    }

    public long getWarnAt() {
        return warnAt;
    }

    public void setWarnAt(long warnAt) {
        this.warnAt = warnAt;
    }
}