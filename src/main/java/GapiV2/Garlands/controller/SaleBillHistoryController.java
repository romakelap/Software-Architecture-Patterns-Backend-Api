package GapiV2.Garlands.controller;

import GapiV2.Garlands.request.SaleBillHistoryRequest;
import GapiV2.Garlands.response.GetSaleBillHistoryResponse;
import GapiV2.Garlands.response.PostGetResponse;
import GapiV2.Garlands.service.SaleBillHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale-bills")
public class SaleBillHistoryController {
    private final SaleBillHistoryService saleBillHistoryService;

    public SaleBillHistoryController(SaleBillHistoryService saleBillHistoryService) {
        this.saleBillHistoryService = saleBillHistoryService;
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<GetSaleBillHistoryResponse>> getAll(){
        return new ResponseEntity<>(saleBillHistoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<GetSaleBillHistoryResponse> getById(@PathVariable int id){
        return new ResponseEntity<>(saleBillHistoryService.getResponseById(id), HttpStatus.OK);
    }

    @GetMapping("/get-all-user/{userId}")
    public ResponseEntity<List<GetSaleBillHistoryResponse>> getAllByUser(@PathVariable int userId){
        return new ResponseEntity<>(saleBillHistoryService.getAllByUser(userId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody SaleBillHistoryRequest saleBillHistoryRequest){
        int billsaleId  = saleBillHistoryService.add(saleBillHistoryRequest);
        return new ResponseEntity<>(billsaleId,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        saleBillHistoryService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
