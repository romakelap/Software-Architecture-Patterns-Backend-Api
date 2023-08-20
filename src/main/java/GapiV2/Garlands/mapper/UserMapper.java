package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.Follow;
import GapiV2.Garlands.entity.User;
import GapiV2.Garlands.request.UserAddRequest;
import GapiV2.Garlands.response.UserFollowerResponse;
import GapiV2.Garlands.response.UserFollowingResponse;
import GapiV2.Garlands.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.firstName",target = "firstName")
    @Mapping(source = "user.lastName",target = "lastName")
    UserFollowerResponse followToFollowerResponse(Follow follow);
    @Mapping(source = "following.id", target = "userId")
    @Mapping(source = "following.lastName", target = "lastName")
    @Mapping(source = "following.firstName", target = "firstName")
    UserFollowingResponse followToFollowingResponse(Follow follow);

    @Mapping(source = "followers", target = "followers")
    @Mapping(source = "following", target = "following")
    @Mapping(target = "role", expression = "java(user.getRole().toString())") // untuk response role
    UserResponse userToResponse(User user);

    User requestToUser(UserAddRequest userAddRequest);
    List<UserResponse> usersToResponses(List<User> users);
    List<UserFollowingResponse> followsToFollowingResponses(List<Follow> follows);
}
