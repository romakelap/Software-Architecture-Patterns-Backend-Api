package GapiV2.Garlands.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<UserFollowerResponse> followers;
    private List<UserFollowingResponse> following;
    private String role;
}
