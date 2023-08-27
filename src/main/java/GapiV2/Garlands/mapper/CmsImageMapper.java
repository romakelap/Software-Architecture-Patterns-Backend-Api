package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.CmsImage;
import GapiV2.Garlands.response.CmsImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "")
public interface CmsImageMapper {
    @Mapping(source = "post.id", target = "postId")
    CmsImageResponse cmsImageResponse(CmsImage cmsImage);
}
