package dto.list;

public class CardsDto {

    private OpenPerListDto openPerList;
    private TotalPerListDto totalPerList;

    public OpenPerListDto getOpenPerList() {
        return openPerList;
    }

    public void setOpenPerList(OpenPerListDto openPerList) {
        this.openPerList = openPerList;
    }

    public TotalPerListDto getTotalPerList() {
        return totalPerList;
    }

    public void setTotalPerList(TotalPerListDto totalPerList) {
        this.totalPerList = totalPerList;
    }
}