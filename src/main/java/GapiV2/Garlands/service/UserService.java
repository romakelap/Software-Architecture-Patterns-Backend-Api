package GapiV2.Garlands.service;

import GapiV2.Garlands.entity.Follow;
import GapiV2.Garlands.entity.User;
import GapiV2.Garlands.mapper.UserMapper;
import GapiV2.Garlands.repository.FollowRepo;
import GapiV2.Garlands.repository.UserRepo;
import GapiV2.Garlands.request.UserAddRequest;
import GapiV2.Garlands.response.UserFollowingResponse;
import GapiV2.Garlands.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepo userRepo;
    private final FollowRepo followRepo;

    public UserService(UserMapper userMapper, UserRepo userRepo, FollowRepo followRepo) {
        this.userMapper = userMapper;
        this.userRepo = userRepo;
        this.followRepo = followRepo;
    }

    public List<UserResponse> getAll(){

        return userMapper.usersToResponses(userRepo.findAll());
    }
    public UserResponse getResponseById(int id){
        User user = userRepo.findById(id).orElse(null);
        return userMapper.userToResponse(user);
    }
    public UserResponse getByEmail(String email){
        User user = userRepo.findByEmail(email);
        return userMapper.userToResponse(user);
    }

    public List<UserFollowingResponse> getUserFollowing(int userId){
        return userMapper.followsToFollowingResponses(followRepo.findAllByUser_Id(userId));
    }
    public boolean isFollowing(int userId,int followingId){
        Optional<Follow> follow = followRepo.findByUser_IdAndFollowing_id(userId,followingId);
        return follow.isPresent();
    }

    public User getById(int id){
        return userRepo.findById(id).get();
    }

    public void add(UserAddRequest userAddRequest){
        User user = userMapper.requestToUser(userAddRequest);
        userRepo.save(user);
    }

    public void delete(int id){
        userRepo.deleteById(id);
    }
}
