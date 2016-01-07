package pl.k2net.boilerandroid.data.entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEntity {

    @SerializedName(METADATA.USERNAME)
    String username;
    @SerializedName(METADATA.FIRST_NAME)
    String firstName;
    @SerializedName(METADATA.LAST_NAME)
    String lastName;
    @SerializedName(METADATA.EMAIL)
    String email;
    @SerializedName(METADATA.ROLES)
    String[] roles;

    interface METADATA {
        String USERNAME = "username";
        String FIRST_NAME = "firstName";
        String LAST_NAME = "lastName";
        String EMAIL = "email";
        String ROLES = "roles";
    }

}
