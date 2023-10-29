package GapiV2.Garlands.controller;

import GapiV2.Garlands.request.LikeRequest;
import GapiV2.Garlands.response.LikeResponse;
import GapiV2.Garlands.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikesController {

    private final LikeService likeService;

    public LikesController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody LikeRequest likeRequest){
        likeService.add(likeRequest);
        return new ResponseEntity<>("Added", HttpStatus.OK);
    }

    @GetMapping("/get-all-by-post/{postId}")
    public ResponseEntity<List<LikeResponse>> getAllByPost(@PathVariable int postId){
        return new ResponseEntity<>(likeService.getAllByPost(postId),HttpStatus.OK);
    }

    @GetMapping("/get-all-by-user/{userId}")
    public ResponseEntity<List<LikeResponse>> getAllByUser(@PathVariable int userId){
        return new ResponseEntity<>(likeService.getAllByUser(userId),HttpStatus.OK);
    }

    @GetMapping("/is-liked")
    public ResponseEntity<Boolean> isLiked(@RequestParam int userId,@RequestParam int postId){
        return new ResponseEntity<>(likeService.isLiked(userId,postId),HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody LikeRequest likeRequest){
        likeService.delete(likeRequest);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
