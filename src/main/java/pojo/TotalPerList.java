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
public class TotalPerList {

    @SerializedName("status")
    @Expose
    @Builder.Default
    private String status;
    @SerializedName("disableAt")
    @Expose
    @Builder.Default
    private long disableAt;
    @SerializedName("warnAt")
    @Expose
    @Builder.Default
    private long warnAt;
}