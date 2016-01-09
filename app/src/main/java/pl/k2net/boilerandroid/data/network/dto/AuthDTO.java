package pl.k2net.boilerandroid.data.network.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthDTO {
    String username;
    String password;
}
