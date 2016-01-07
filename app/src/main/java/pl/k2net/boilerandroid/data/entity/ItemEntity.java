package pl.k2net.boilerandroid.data.entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemEntity {

    @SerializedName(METADATA.NAME)
    String name;

    private interface METADATA {
        String NAME = "name";
    }
}
