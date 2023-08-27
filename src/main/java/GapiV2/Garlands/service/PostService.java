package GapiV2.Garlands.service;

import GapiV2.Garlands.entity.Post;
import GapiV2.Garlands.mapper.PostMapper;
import GapiV2.Garlands.repository.PostRepo;
import GapiV2.Garlands.request.PostAddRequest;
import GapiV2.Garlands.response.PostGetResponse;
import GapiV2.Garlands.response.UserFollowingResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostService {

    private final PostRepo postRepo;
    private final PostMapper postMapper;
    private final UserService userService;

    public PostService(PostRepo postRepo, PostMapper postMapper, UserService userService) {
        this.postRepo = postRepo;
        this.postMapper = postMapper;
        this.userService = userService;
    }

    public List<PostGetResponse> getAll(){
        List<Post> posts = postRepo.findAll();
        return postMapper.postsToGetResponses(posts);
    }

    public PostGetResponse getResponseById(int id){
        Post post = postRepo.findById(id).orElse(null);
        return postMapper.postToGetResponse(post);
    }

    public Post getById(int id){
        return postRepo.findById(id).get();
    }

    public List<PostGetResponse> getAllByUser(int userId){
        List<Post> userPosts = postRepo.findAllByUser_IdOrderByIdDesc(userId);
        return postMapper.postsToGetResponses(userPosts);
    }

    public List<PostGetResponse> getByUserFollowing(int userId){
        List<UserFollowingResponse> follows = userService.getUserFollowing(userId);
        List<Post> set = new ArrayList<>();

        for (UserFollowingResponse user : follows){
            set.addAll(postRepo.findAllByUser_IdOrderByIdDesc(user.getUserId()));
        }

        set.sort(Comparator.comparing(Post::getId).reversed());
        return postMapper.postsToGetResponses(set);
    }

    public int add(PostAddRequest postAddRequest){
        Post post = postMapper.postAddRequestToPost(postAddRequest);
        postRepo.save(post);
        return post.getId();
    }

    public void delete(int id){
        postRepo.deleteById(id);
    }
}
