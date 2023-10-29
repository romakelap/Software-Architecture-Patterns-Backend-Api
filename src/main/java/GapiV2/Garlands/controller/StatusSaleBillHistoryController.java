package GapiV2.Garlands.controller;

import GapiV2.Garlands.entity.Category;
import GapiV2.Garlands.entity.StatusSaleBillHistory;
import GapiV2.Garlands.service.StatusSaleBillHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status-sale-bill")
public class StatusSaleBillHistoryController {

    private final StatusSaleBillHistoryService saleBillHistoryService;

    public StatusSaleBillHistoryController(StatusSaleBillHistoryService saleBillHistoryService) {
        this.saleBillHistoryService = saleBillHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<StatusSaleBillHistory>> getAllStatus(){
        List<StatusSaleBillHistory> statusSaleBillHistories = saleBillHistoryService.getAllStatus();
        return new ResponseEntity<>(statusSaleBillHistories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusSaleBillHistory> getStatusById(@PathVariable int id) {
        StatusSaleBillHistory statusSaleBillHistory = saleBillHistoryService.getSaleById(id)
                .orElseThrow(() -> new IllegalArgumentException("Status not found with id: " + id));

        return new ResponseEntity<>(statusSaleBillHistory, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<StatusSaleBillHistory> createStatus(@RequestBody StatusSaleBillHistory statusSaleBillHistory) {
        StatusSaleBillHistory createdStatus = saleBillHistoryService.createStatus(statusSaleBillHistory);
        return new ResponseEntity<>(createdStatus, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusSaleBillHistory> updateStatus(@PathVariable int id, @RequestBody StatusSaleBillHistory statusSaleBillHistory) {
        StatusSaleBillHistory updatedStatus = saleBillHistoryService.updateStatus(id, statusSaleBillHistory);
        return new ResponseEntity<>(updatedStatus, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable int id) {
        saleBillHistoryService.deleteStatus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
