package GapiV2.Garlands.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostGetResponse {
    private int id;
    private int userId;
    private String userFirstName;
    private String userLastName;
    private String Description;
}
