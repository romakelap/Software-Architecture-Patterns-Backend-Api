package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.CMS;
import GapiV2.Garlands.request.CmsAddRequest;
import GapiV2.Garlands.response.CmsGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CmsMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.lastName", target = "userLastName")
    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "templates.id", target = "templateId")
    CmsGetResponse cmsToGetResponse(CMS cms);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "templateId", target = "templates.id")
    CMS cmsAddRequestToCMS(CmsAddRequest cmsAddRequest);
    List<CmsGetResponse> cmsToGetResponse(List<CMS> cms);
}
