package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.Follow;
import GapiV2.Garlands.request.FollowRequest;
import GapiV2.Garlands.response.FollowResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FollowMapper {
    @Mapping(source = "following.id", target = "followingId")
    @Mapping(source = "user.id", target = "followerId")
    @Mapping(target = "followingName",expression = "java(follow.getFollowing().getFirstName() + \" \"+follow.getFollowing().getLastName())")
    @Mapping(target = "followerName",expression = "java(follow.getUser().getFirstName() + \" \"+follow.getUser().getLastName())")
    FollowResponse followToResponse(Follow follow);
    @Mapping(source = "userId",target = "user.id")
    @Mapping(source = "followingId",target = "following.id")
    Follow addRequestToFollow(FollowRequest followAddRequest);

    List<FollowResponse> followsToResponses(List<Follow> follows);
}
