package com.main.FiscalIQ.controller;

import com.main.FiscalIQ.common.Result;
import com.main.FiscalIQ.model.SubscriptionType;
import com.main.FiscalIQ.service.BillingInvoiceManagement;
import com.main.FiscalIQ.service.SubscriptionService;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
            subscriptionService.addSubscription(userId, SubscriptionType.valueOf(subType.toUpperCase()));
            BillingInvoiceManagement billingInvoiceManagement = new BillingInvoiceManagement();
            billingInvoiceManagement.generateInvoice(userId);
            result.setMessage("Subscription successful!");
            return ResponseEntity.ok(result);
        } else {
            // If payment failed, return the payment response
            return paymentResponse;
        }
    }

    @PostMapping("/updateSubscription")
    public ResponseEntity<Result> updateSubscription(@RequestBody String requestBody) {
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

        PaymentController paymentController = new PaymentController();
        ResponseEntity<Result> paymentResponse = paymentController.callPaymentAPI(userId, getCostForSubscriptionType(subType));

        // Check if the payment was successful
        if (paymentResponse.getStatusCode() == HttpStatus.OK) {
            // Subscription logic goes here
            // For now, let's just return a success response
            SubscriptionService subscriptionService = new SubscriptionService();
            subscriptionService.updateSubscription(userId, SubscriptionType.valueOf(subType.toUpperCase()));
            BillingInvoiceManagement billingInvoiceManagement = new BillingInvoiceManagement();
            billingInvoiceManagement.generateInvoice(userId);
            // Return success response
            result.setMessage("Subscription updated successfully!");
            return ResponseEntity.ok(result);
        } else {
            // If payment failed, return the payment response
            return paymentResponse;
        }

    }

    @PostMapping("/removeSubscription")
    public ResponseEntity<Result> removeSubscription(@RequestBody String requestBody) {
        Result result = Result.initInstance();

        // Parse userId from the request body
        int userId;
        try {
            JSONObject json = new JSONObject(requestBody);
            userId = json.getInt("userId");
        } catch (JSONException e) {
            e.printStackTrace();
            result.setMessage("Invalid request body format");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

        // Remove subscription
        SubscriptionService subscriptionService = new SubscriptionService();
        subscriptionService.removeSubscription(userId);

        // Return success response
        result.setMessage("Subscription removed successfully!");
        return ResponseEntity.ok(result);
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
