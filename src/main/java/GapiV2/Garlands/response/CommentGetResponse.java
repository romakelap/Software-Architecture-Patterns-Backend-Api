package GapiV2.Garlands.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentGetResponse {
    private int id;
    private int postId;
    private int userId;
    private String userFirstName;
    private String userLastName;
    private String description;
}
