package GapiV2.Garlands.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CmsImageResponse {
    private int id;
    private String name;
    private String type;
    private byte[] data;
    private int cmsId;
}
