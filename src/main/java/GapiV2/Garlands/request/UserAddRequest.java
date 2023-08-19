package GapiV2.Garlands.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
