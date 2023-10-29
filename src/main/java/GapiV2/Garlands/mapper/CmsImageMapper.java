package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.CmsImage;
import GapiV2.Garlands.response.CmsImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CmsImageMapper {
    @Mapping(source = "cms.id", target = "cmsId")
    CmsImageResponse cmsImageResponse(CmsImage cmsImage);
}
