package GapiV2.Garlands.controller;

import GapiV2.Garlands.response.CmsImageResponse;
import GapiV2.Garlands.service.CmsImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/cms-images")
public class CmsImageController {
    private final CmsImageService cmsImageService;

    public CmsImageController(CmsImageService cmsImageService) {
        this.cmsImageService = cmsImageService;
    }

//    @PostMapping("/upload")
//    public ResponseEntity<PostImageResponse> upload(@RequestParam("image") MultipartFile file, @RequestParam int postId) throws IOException {
//        PostImageResponse postImageResponse = postImageService.upload(file,postId);
//        return new ResponseEntity<>(postImageResponse, HttpStatus.OK);
//    }
    @PostMapping("/upload")
    public ResponseEntity<CmsImageResponse> upload(@RequestParam("image") MultipartFile file, @RequestParam int cmsId) throws IOException {
        CmsImageResponse cmsImageResponse = cmsImageService.upload(file,cmsId);
        return  new ResponseEntity<>(cmsImageResponse, HttpStatus.OK);
    }

//    @GetMapping("/download/{postId}")
//    public ResponseEntity<?> download(@PathVariable int postId){
//        byte[] image = postImageService.download(postId);
//        if (image!=null){
//            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//
//    }

    @GetMapping("/download/{cmsId}")
    public ResponseEntity<?> download(@PathVariable int cmsId){
        byte[] image = cmsImageService.download(cmsId);
        if (image!=null){
            return  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
