package com.main.FiscalIQ.controller;

import com.main.FiscalIQ.model.*;
import com.main.FiscalIQ.service.FinancialModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financial-options")
public class FinancialOptionsController {

    private final FinancialModelService financialModelService;

    @Autowired
    public FinancialOptionsController(FinancialModelService financialDataService) {
        this.financialModelService = financialDataService;
    }

    // Recommendations CRUD operations

    @PostMapping("/recommendations")
    public ResponseEntity<Void> createRecommendation(@RequestBody Recommendation recommendation) {
        financialModelService.createRecommendation(recommendation);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/recommendations/{recommendationId}")
    public ResponseEntity<Recommendation> getRecommendation(@PathVariable int recommendationId) {
        Recommendation recommendation = financialModelService.getRecommendation(recommendationId);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/recommendations")
    public ResponseEntity<List<Recommendation>> getAllRecommendations() {
        List<Recommendation> recommendations = financialModelService.getAllRecommendations();
        return ResponseEntity.ok(recommendations);
    }

    @PutMapping("/recommendations/{recommendationId}")
    public ResponseEntity<Void> updateRecommendation(@PathVariable int recommendationId, @RequestBody Recommendation recommendation) {
        recommendation.setId(recommendationId);
        financialModelService.updateRecommendation(recommendation);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/recommendations/{recommendationId}")
    public ResponseEntity<Void> deleteRecommendation(@PathVariable int recommendationId) {
        financialModelService.deleteRecommendation(recommendationId);
        return ResponseEntity.ok().build();
    }

    // Savings CRUD operations

    @PostMapping("/savings")
    public ResponseEntity<Void> createSavings(@RequestBody Savings savings) {
        financialModelService.createSavings(savings);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/savings/{savingsId}")
    public ResponseEntity<Savings> getSavings(@PathVariable int savingsId) {
        Savings savings = financialModelService.getSavings(savingsId);
        return ResponseEntity.ok(savings);
    }

    @GetMapping("/savings")
    public ResponseEntity<List<Savings>> getAllSavings() {
        List<Savings> savings = financialModelService.getAllSavings();
        return ResponseEntity.ok(savings);
    }

    @PutMapping("/savings/{savingsId}")
    public ResponseEntity<Void> updateSavings(@PathVariable int savingsId, @RequestBody Savings savings) {
        savings.setId(savingsId);
        financialModelService.updateSavings(savings);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/savings/{savingsId}")
    public ResponseEntity<Void> deleteSavings(@PathVariable int savingsId) {
        financialModelService.deleteSavings(savingsId);
        return ResponseEntity.ok().build();
    }

    // Loans CRUD operations
    @PostMapping("/loans")
    public ResponseEntity<Void> createLoan(@RequestBody Loan loan) {
        financialModelService.createLoan(loan);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/loans/{loanId}")
    public ResponseEntity<Loan> getLoan(@PathVariable int loanId) {
        Loan loan = financialModelService.getLoan(loanId);
        return ResponseEntity.ok(loan);
    }

    @GetMapping("/loans")
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = financialModelService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    @PutMapping("/loans/{loanId}")
    public ResponseEntity<Void> updateLoan(@PathVariable int loanId, @RequestBody Loan loan) {
        loan.setId(loanId);
        financialModelService.updateLoan(loan);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/loans/{loanId}")
    public ResponseEntity<Void> deleteLoan(@PathVariable int loanId) {
        financialModelService.deleteLoan(loanId);
        return ResponseEntity.ok().build();
    }


    // Method to calculate performance for savings
    @PostMapping("/savings/{savingsId}/performance")
    public ResponseEntity<Void> calculateSavingsPerformance(@PathVariable int savingsId) {
        Savings savings = financialModelService.getSavings(savingsId);
        if (savings != null) {
            financialModelService.calcPerformance(savings);
            financialModelService.updateSavings(savings); // Update savings with calculated performance
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Method to calculate performance for loans
    @PostMapping("/loans/{loanId}/performance")
    public ResponseEntity<Void> calculateLoanPerformance(@PathVariable int loanId) {
        Loan loan = financialModelService.getLoan(loanId);
        if (loan != null) {
            financialModelService.calcPerformance(loan);
            financialModelService.updateLoan(loan); // Update loan with calculated performance
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Method to calculate performance for recommendations
    @PostMapping("/recommendations/{recommendationId}/performance")
    public ResponseEntity<Void> calculateRecommendationPerformance(@PathVariable int recommendationId) {
        Recommendation recommendation = financialModelService.getRecommendation(recommendationId);
        if (recommendation != null) {
            financialModelService.calcPerformance(recommendation);
            financialModelService.updateRecommendation(recommendation); // Update recommendation with calculated performance
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}