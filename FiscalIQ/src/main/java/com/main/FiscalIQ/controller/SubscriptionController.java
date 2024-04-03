package com.main.FiscalIQ.controller;

import com.main.FiscalIQ.common.Result;
import com.main.FiscalIQ.model.SubscriptionType;
import com.main.FiscalIQ.service.PaymentService;
import com.main.FiscalIQ.service.SubscriptionService;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class SubscriptionController {

    @PostMapping("/subscribe")
    public ResponseEntity<Result> subscribe(@RequestBody String requestBody) {
        Result result = Result.initInstance();

        // Parse userId and subType from the request body
        int userId;
        String subType;
        try {
            JSONObject json = new JSONObject(requestBody);
            userId = json.getInt("userId");
            subType = json.getString("subType");
        } catch (JSONException e) {
            e.printStackTrace();
            result.setMessage("Invalid request body format");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

        // Get the cost based on the subscription type
        int amount = getCostForSubscriptionType(subType);

        // Call the testPayment method from PaymentController
        PaymentController paymentController = new PaymentController();
        ResponseEntity<Result> paymentResponse = paymentController.callPaymentAPI(userId, amount);

        // Check if the payment was successful
        if (paymentResponse.getStatusCode() == HttpStatus.OK) {
            // Subscription logic goes here
            // For now, let's just return a success response
            SubscriptionService subscriptionService = new SubscriptionService();
            
            result.setMessage("Subscription successful!");
            return ResponseEntity.ok(result);
        } else {
            // If payment failed, return the payment response
            return paymentResponse;
        }
    }

    private int getCostForSubscriptionType(String subType) {
        int cost = 0; // Default cost

        // Map subscription type to cost
        switch (subType.toUpperCase()) {
            case "TIER1":
                cost = SubscriptionType.TIER1.getCost();
                break;
            case "TIER2":
                cost = SubscriptionType.TIER2.getCost();
                break;
            default:
                // Handle invalid subscription type
                break;
        }

        return cost;
    }
}
