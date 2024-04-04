package com.main.FiscalIQ.FinanceManagement.controller;

import com.main.FiscalIQ.common.Result;
import com.main.FiscalIQ.FinanceManagement.model.MonthlyFinances;
import com.main.FiscalIQ.FinanceManagement.service.MonthlyFinancesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class MonthlyFinancesController {

    private final MonthlyFinancesService monthlyFinancesService;

    public MonthlyFinancesController(MonthlyFinancesService monthlyFinancesService) {
        this.monthlyFinancesService = monthlyFinancesService;
    }

    @PostMapping("/monthly-finances")
    public ResponseEntity<Result> addMonthlyFinances(@RequestBody MonthlyFinances monthlyFinances) {
        Result result = Result.initInstance();

        try {
            // Call the service method to add the monthly finances data
            monthlyFinancesService.addMonthlyFinances(monthlyFinances);
            result.setMessage("Monthly finances data added successfully.");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("Failed to add monthly finances data: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }

    @PutMapping("/monthly-finances/{id}")
    public ResponseEntity<Result> updateMonthlyFinances(@PathVariable("id") long id, @RequestBody MonthlyFinances updatedMonthlyFinances) {
        Result result = Result.initInstance();

        try {
            // Call the service method to update the monthly finances data
            monthlyFinancesService.updateMonthlyFinances(id, updatedMonthlyFinances);
            result.setMessage("Monthly finances data updated successfully.");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("Failed to update monthly finances data: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }

    @DeleteMapping("/monthly-finances/{id}")
    public ResponseEntity<Result> deleteMonthlyFinances(@PathVariable("id") long id) {
        Result result = Result.initInstance();

        try {
            // Call the service method to delete the monthly finances data
            monthlyFinancesService.deleteMonthlyFinances(id);
            result.setMessage("Monthly finances data deleted successfully.");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("Failed to delete monthly finances data: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }
}