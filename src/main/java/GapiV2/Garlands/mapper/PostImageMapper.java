package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.PostImage;
import GapiV2.Garlands.response.PostImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostImageMapper {
    @Mapping(source = "post.id", target = "postId")
    PostImageResponse imageToResponse(PostImage postImage);
}
