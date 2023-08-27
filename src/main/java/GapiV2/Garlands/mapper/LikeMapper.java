package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.Like;
import GapiV2.Garlands.request.LikeRequest;
import GapiV2.Garlands.response.LikeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LikeMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.firstName", target = "firstName")
    @Mapping(source = "user.lastName", target = "lastName")
    LikeResponse likeToPostLikeResponse(Like like);

    @Mapping(source = "postId",target = "post.id")
    @Mapping(source = "userId", target = "user.id")
    Like requestToLike(LikeRequest likeRequest);

    List<LikeResponse> likesToLikeResponses(List<Like> likes);
}
