package GapiV2.Garlands.service;

import GapiV2.Garlands.entity.Follow;
import GapiV2.Garlands.mapper.FollowMapper;
import GapiV2.Garlands.repository.FollowRepo;
import GapiV2.Garlands.request.FollowRequest;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
    private final FollowRepo followRepo;
    private final FollowMapper followMapper;
    private final UserService userService;

    public FollowService(FollowRepo followRepo, FollowMapper followMapper, UserService userService) {
        this.followRepo = followRepo;
        this.followMapper = followMapper;
        this.userService = userService;
    }

    public void add(FollowRequest followAddRequest){
        if (userService.isFollowing(followAddRequest.getUserId(),followAddRequest.getFollowingId())){
            return;
        }
        followRepo.save(followMapper.addRequestToFollow(followAddRequest));
    }

    public void delete(FollowRequest followRequest){
        Follow follow
                = followRepo.findByUser_IdAndFollowing_id(followRequest.getUserId(), followRequest.getFollowingId()).orElse(null);

        followRepo.delete(follow);
    }
}
