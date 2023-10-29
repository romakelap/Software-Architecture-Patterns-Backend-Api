package GapiV2.Garlands.controller;

import GapiV2.Garlands.response.UserImageResponse;
import GapiV2.Garlands.service.UserImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/user-images")
public class UserImagesController {
    private final UserImageService userImageService;

    public UserImagesController(UserImageService userImageService) {
        this.userImageService = userImageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<UserImageResponse> upload(@RequestParam("image")MultipartFile file, @RequestParam int userId) throws IOException {
        UserImageResponse response = userImageService.upload(file,userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/download/{userId}")
    public ResponseEntity<byte[]> download(@PathVariable int userId){
        byte[] image = userImageService.download(userId);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }


}
