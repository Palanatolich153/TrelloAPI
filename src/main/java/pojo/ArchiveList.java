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
public class ArchiveList {

    @SerializedName("closed")
    @Expose
    @Builder.Default
    private Boolean closed = true;
    @SerializedName("idBoard")
    @Expose
    @Builder.Default
    private String idBoard = "5d132cead342b156efed967a";
    @SerializedName("pos")
    @Expose
    @Builder.Default
    private Double pos;
    @SerializedName("key")
    @Expose
    @Builder.Default
    private String key = "661c41560774298c33984a8b5fa33df4";
    @SerializedName("token")
    @Expose
    @Builder.Default
    private String token = "802a857ff7d4b3653b0e69c92652bc797a48328ca2b6bd763d0c4021a62d150f";
}