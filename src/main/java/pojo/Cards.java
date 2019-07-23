package pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Cards {

    @SerializedName("openPerList")
    @Expose
    @Builder.Default
    private OpenPerList openPerList;
    @SerializedName("totalPerList")
    @Expose
    @Builder.Default
    private TotalPerList totalPerList;
}