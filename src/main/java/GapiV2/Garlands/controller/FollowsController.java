package GapiV2.Garlands.controller;

import GapiV2.Garlands.request.FollowRequest;
import GapiV2.Garlands.service.FollowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/follows")
public class FollowsController {

    private final FollowService followService;

    public FollowsController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody FollowRequest followRequest){
        followService.add(followRequest);
        return new ResponseEntity<>("Followed", HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody FollowRequest  followRequest){
        followService.delete(followRequest);
        return new ResponseEntity<>("Unfollowed",HttpStatus.OK);
    }
}
