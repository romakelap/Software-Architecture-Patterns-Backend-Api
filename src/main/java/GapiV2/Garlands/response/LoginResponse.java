package GapiV2.Garlands.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String email;
    private int userId;
    private String fullName;
    private String role;
}
