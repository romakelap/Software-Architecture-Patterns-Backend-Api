package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.Comment;
import GapiV2.Garlands.request.CommentAddRequest;
import GapiV2.Garlands.response.CommentGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "user.id" , target = "userId")
    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    CommentGetResponse commentToResponse(Comment comment);

    List<CommentGetResponse> commentToResponse(List<Comment> comments);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "postId", target = "post.id")
    Comment addRequestToComment(CommentAddRequest commentAddRequest);
}
