package pojo;

import com.github.javafaker.Faker;
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
public class List {

    @SerializedName("id")
    @Expose
    @Builder.Default
    public String id;
    @SerializedName("name")
    @Expose
    @Builder.Default
    public String name = new Faker().name().firstName();
    @SerializedName("closed")
    @Expose
    @Builder.Default
    public boolean closed = false;
    @SerializedName("idBoard")
    @Expose
    @Builder.Default
    public String idBoard = "5d132cead342b156efed967a";
    @SerializedName("pos")
    @Expose
    @Builder.Default
    public Double pos;
    @SerializedName("limits")
    @Expose
    @Builder.Default
    public Limits limits;
}