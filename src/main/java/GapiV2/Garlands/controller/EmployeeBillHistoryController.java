package GapiV2.Garlands.controller;

import GapiV2.Garlands.request.EmployeeBillHistoryRequest;
import GapiV2.Garlands.request.PostAddRequest;
import GapiV2.Garlands.response.GetEmployeeBillHistoryResponse;
import GapiV2.Garlands.response.PostGetResponse;
import GapiV2.Garlands.service.EmployeeBillHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-bills")
public class EmployeeBillHistoryController {
    private final EmployeeBillHistoryService employeeBillHistoryService;

    public EmployeeBillHistoryController(EmployeeBillHistoryService employeeBillHistoryService) {
        this.employeeBillHistoryService = employeeBillHistoryService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<GetEmployeeBillHistoryResponse>> getAll(){
        return new ResponseEntity<>(employeeBillHistoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<GetEmployeeBillHistoryResponse> getById(@PathVariable int id){
        return new ResponseEntity<>(employeeBillHistoryService.getResponseById(id), HttpStatus.OK);
    }

    @GetMapping("/get-all-by-user/{userId}")
    public ResponseEntity<List<GetEmployeeBillHistoryResponse>> getAllByUser(@PathVariable int userId){
        return new ResponseEntity<>(employeeBillHistoryService.getAllByUser(userId),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody EmployeeBillHistoryRequest employeeBillHistoryRequest){
        int billemployeeId = employeeBillHistoryService.add(employeeBillHistoryRequest);
        return new ResponseEntity<>(billemployeeId, HttpStatus.CREATED);
    }

    public ResponseEntity<String> delete(@RequestParam int id){
        employeeBillHistoryService.delete(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
