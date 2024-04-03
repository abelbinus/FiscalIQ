package com.main.FiscalIQ.controller;

import com.main.FiscalIQ.model.Investment;
import com.main.FiscalIQ.model.Loan;
import com.main.FiscalIQ.model.Savings;
import com.main.FiscalIQ.service.FinancialOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/financial-performance")
public class FinancialOptionsController {

    private final FinancialOptionsService financialOptionsService;

    @Autowired
    public FinancialOptionsController(FinancialOptionsService financialOptionsService) {
        this.financialOptionsService = financialOptionsService;
    }

    @PostMapping("/savings/track-performance")
    public ResponseEntity<Void> trackSavingsPerformance(@RequestBody Savings savings) {
        financialOptionsService.trackSavingsPerformance(savings);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/investment/track-performance")
    public ResponseEntity<Void> trackInvestmentPerformance(@RequestBody Investment investment) {
        financialOptionsService.trackInvestmentPerformance(investment);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/loan/track-performance")
    public ResponseEntity<Void> trackLoanPerformance(@RequestBody Loan loan) {
        financialOptionsService.trackLoanPerformance(loan);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/savings/{userId}/view-performance")
    public ResponseEntity<Map<String, Double>> viewSavingsPerformance(@PathVariable int userId) {
        Map<String, Double> savingsPerformance = financialOptionsService.viewSavingsPerformance(userId);
        return ResponseEntity.ok(savingsPerformance);
    }

    @GetMapping("/investment/{userId}/view-performance")
    public ResponseEntity<Map<String, Double>> viewInvestmentPerformance(@PathVariable int userId) {
        Map<String, Double> investmentPerformance = financialOptionsService.viewInvestmentPerformance(userId);
        return ResponseEntity.ok(investmentPerformance);
    }

    @GetMapping("/loan/{userId}/view-performance")
    public ResponseEntity<Map<String, Double>> viewLoanPerformance(@PathVariable int userId) {
        Map<String, Double> loanPerformance = financialOptionsService.viewLoanPerformance(userId);
        return ResponseEntity.ok(loanPerformance);
    }

    @PostMapping("/savings/generate-recommendations")
    public ResponseEntity<Map<String, Double>> generateSavingsRecommendations(@RequestBody Savings userInput) {
        Map<String, Double> recommendations = financialOptionsService.generateSavingsRecommendations(userInput);
        return ResponseEntity.ok(recommendations);
    }

    @PostMapping("/investment/generate-recommendations")
    public ResponseEntity<Object> generateInvestmentRecommendations(@RequestBody Investment userInput) {
        // Here, Result is returned which can be any object representing the result of the operation.
        // You may replace Object with the actual result type if it's not Result.
        Object result = financialOptionsService.generateInvestmentRecommendations(userInput);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/loan/generate-recommendations")
    public ResponseEntity<Object> generateLoanRecommendations(@RequestBody Loan userInput) {
        // Here, Result is returned which can be any object representing the result of the operation.
        // You may replace Object with the actual result type if it's not Result.
        Object result = financialOptionsService.generateLoanRecommendations(userInput);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/compare-performance")
    public ResponseEntity<Object> comparePerformance(@RequestBody Map<String, Double> comparisonRequest) {
        // Here, Result is returned which can be any object representing the result of the operation.
        // You may replace Object with the actual result type if it's not Result.
        Object result = financialOptionsService.comparePerformance(comparisonRequest);
        return ResponseEntity.ok(result);
    }
}
    
