package GapiV2.Garlands.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowerResponse {
   private int userId;
   private String firstName;
   private String lastName;
}
