package GapiV2.Garlands.controller;

import GapiV2.Garlands.request.UpdateProfileRequest;
import GapiV2.Garlands.response.UserDetailResponse;
import GapiV2.Garlands.service.UserDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-detail")
public class UserDetailController {
    private final UserDetailService userDetailService;

    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDetailResponse>> getAll(){
        return new ResponseEntity<>(userDetailService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<UserDetailResponse> getById(@PathVariable int id){
        return new ResponseEntity<>(userDetailService.getResponseById(id), HttpStatus.OK);
    }

    @PostMapping("/update-profile")
    public ResponseEntity<Integer> add(@RequestBody UpdateProfileRequest updateProfileRequest){
        int userDetailId = userDetailService.add(updateProfileRequest);
        return new ResponseEntity<>(userDetailId, HttpStatus.CREATED);
    }
}
