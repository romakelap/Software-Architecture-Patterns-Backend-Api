package GapiV2.Garlands.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentAddRequest {
    private int postId;
    private int userId;
    private String description;
}
