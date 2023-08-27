package GapiV2.Garlands.response;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CmsGetResponse {
    private int id;
    private int userId;
    private String title;
    private String content;

}
