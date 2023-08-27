package GapiV2.Garlands.request;

import GapiV2.Garlands.entity.CMS;
import GapiV2.Garlands.entity.CmsImage;
import GapiV2.Garlands.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CMSRequest {
    private int userId;
    @NotNull
    private String title;

    @NotNull
    private String content;

    private List<CmsImageRequest> cmsImages;

    public CMS toCMSEntity() {
        CMS cms = new CMS();
        cms.setId(this.userId);
        cms.setTitle(this.title);
        cms.setContent(this.content);
        // Mapping CmsImageRequest to CmsImage entities
        List<CmsImage> cmsImageEntities = CmsImageRequest.toCmsImageEntities(this.cmsImages);
        cms.setCmsImages(cmsImageEntities);
        return cms;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class CmsImageRequest {
    private int id;
    private String name;
    private String type;
    private byte[] data;

    public static List<CmsImage> toCmsImageEntities(List<CmsImageRequest> cmsImageRequests) {
        // Convert list of CmsImageRequest to list of CmsImage entities
        // You'll need to implement this conversion logic based on your needs
        return null;
    }
}
