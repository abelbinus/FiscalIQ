package com.main.FiscalIQ.controller;

import com.main.FiscalIQ.model.Investment;
import com.main.FiscalIQ.model.Loan;
import com.main.FiscalIQ.model.Recommendation;
import com.main.FiscalIQ.model.Savings;
import com.main.FiscalIQ.model.Subscription;
import com.main.FiscalIQ.model.SubscriptionType;
import com.main.FiscalIQ.service.FinancialOptionsService;
import com.main.FiscalIQ.service.SubscriptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/financial-performance")
public class FinancialOptionsController {

    private final FinancialOptionsService financialOptionsService;
    private final SubscriptionService subscriptionService;

    @Autowired
    public FinancialOptionsController(FinancialOptionsService financialOptionsService, SubscriptionService subscriptionService) {
        this.financialOptionsService = financialOptionsService;
        this.subscriptionService = subscriptionService;
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

    // Recommendations CRUD operations

    @PostMapping("/recommendations")
    public ResponseEntity<Void> createRecommendation(@RequestBody Recommendation<Loan> recommendation) {
        financialOptionsService.createRecommendation(recommendation);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/recommendations/{recommendationId}")
    public ResponseEntity<Recommendation<Loan>> getRecommendation(@PathVariable int recommendationId) {
        Recommendation<Loan> recommendation = financialOptionsService.getRecommendation(recommendationId);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/recommendations")
    public ResponseEntity<List<Recommendation<Loan>>> getAllRecommendations() {
        List<Recommendation<Loan>> recommendations = financialOptionsService.getAllRecommendations();
        return ResponseEntity.ok(recommendations);
    }

    @PutMapping("/recommendations/{recommendationId}")
    public ResponseEntity<Void> updateRecommendation(@PathVariable int recommendationId, @RequestBody Recommendation<Loan> recommendation) {
        recommendation.setId(recommendationId);
        financialOptionsService.updateRecommendation(recommendation);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/recommendations/{recommendationId}")
    public ResponseEntity<Void> deleteRecommendation(@PathVariable int recommendationId) {
    financialOptionsService.deleteRecommendation(recommendationId);
           return ResponseEntity.ok().build();
       }

    // Method to calculate performance for recommendations
    @PostMapping("/recommendations/{recommendationId}/performance")
    public ResponseEntity<Void> calculateRecommendationPerformance(@PathVariable int recommendationId) {
        Recommendation recommendation = financialOptionsService.getRecommendation(recommendationId);
        if (recommendation != null) {
            financialOptionsService.calcPerformance(recommendation);
            financialOptionsService.updateRecommendation(recommendation); // Update recommendation with calculated performance
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/community-forum")
    public ResponseEntity<Object> accessCommunityForum(@RequestParam int userId) {
        Subscription subscription = subscriptionService.getSubscriptionByUserId(userId);
        if (subscription != null && subscription.getTier() == SubscriptionType.TIER2) {
            // Allow access to the community forum
            // Implement logic to retrieve forum posts and threads
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User does not have Tier 2 subscription.");
        }
    }

    @PostMapping("/expert-advice")
    public ResponseEntity<Object> getExpertAdvice(@RequestParam int userId) {
        Subscription subscription = subscriptionService.getSubscriptionByUserId(userId);
        if (subscription != null && subscription.getTier() == SubscriptionType.TIER2) {
            // Make external API call to get advice from a human expert
            // Implement logic to handle the response
            financialOptionsService.accessCommunityForum(userId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User does not have Tier 2 subscription.");
        }
    }

    @PostMapping("/compare-performance")
    public ResponseEntity<Object> comparePerformance(@RequestBody Map<String, Double> comparisonRequest) {
        // Here, Result is returned which can be any object representing the result of the operation.
        // You may replace Object with the actual result type if it's not Result.
        Object result = financialOptionsService.comparePerformance(comparisonRequest);
        return ResponseEntity.ok(result);
    }
}
    
