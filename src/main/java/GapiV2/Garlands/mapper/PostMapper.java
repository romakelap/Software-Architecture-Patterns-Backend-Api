package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.Post;
import GapiV2.Garlands.request.PostAddRequest;
import GapiV2.Garlands.response.PostGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(source = "user.id",target = "userId")
    @Mapping(source = "user.lastName", target = "userLastName")
    @Mapping(source = "user.firstName", target = "userFirstName")
    PostGetResponse postToGetResponse(Post post);
    @Mapping(source = "userId",target = "user.id")
    Post postAddRequestToPost(PostAddRequest postAddRequest);
    List<PostGetResponse> postsToGetResponses(List<Post> posts);
}
