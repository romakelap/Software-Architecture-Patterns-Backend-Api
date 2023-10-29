package GapiV2.Garlands.controller;

import GapiV2.Garlands.request.PostAddRequest;
import GapiV2.Garlands.response.PostGetResponse;
import GapiV2.Garlands.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    private final PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PostGetResponse>> getAll(){
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<PostGetResponse> getById(@PathVariable int id){
        return new ResponseEntity<>(postService.getResponseById(id),HttpStatus.OK);
    }

    @GetMapping("/get-all-by-user/{userId}")
    public ResponseEntity<List<PostGetResponse>> getAllByUser(@PathVariable int userId){
        return new ResponseEntity<>(postService.getAllByUser(userId),HttpStatus.OK);
    }

    @GetMapping("/get-by-user-following/{userId}")
    public ResponseEntity<List<PostGetResponse>> getAllByUserFollowing(@PathVariable int userId){
        return new ResponseEntity<>(postService.getByUserFollowing(userId),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody PostAddRequest postAddRequest){
        int postId = postService.add(postAddRequest);
        return new ResponseEntity<>(postId,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        postService.delete(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}
