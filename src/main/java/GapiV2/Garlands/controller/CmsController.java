package GapiV2.Garlands.controller;

import GapiV2.Garlands.request.CmsAddRequest;
import GapiV2.Garlands.response.CmsGetResponse;
import GapiV2.Garlands.service.CmsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cms")
public class CmsController {
    private final CmsService cmsService;

    public CmsController(CmsService cmsService) {
        this.cmsService = cmsService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CmsGetResponse>> getAll(){
        return new ResponseEntity<>(cmsService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<CmsGetResponse> getById(@PathVariable int id){
        return new ResponseEntity<>(cmsService.getResponseById(id),HttpStatus.OK);
    }


    @GetMapping("/get-all-by-user/{userId}")
    public ResponseEntity<List<CmsGetResponse>> getAllByUser(@PathVariable int userId){
        return new ResponseEntity<>(cmsService.getAllByUser(userId),HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody CmsAddRequest cmsAddRequest){
        int cmsId = cmsService.add(cmsAddRequest);
        return new ResponseEntity<>(cmsId,HttpStatus.CREATED);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        cmsService.delete(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
