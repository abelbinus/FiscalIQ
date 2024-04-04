package com.main.FiscalIQ.SubscriptionManagement.controller;

import com.main.FiscalIQ.common.Result;
import com.main.FiscalIQ.SubscriptionManagement.service.PaymentService;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@CrossOrigin(origins = "*")
public class PaymentController {

    public ResponseEntity<Result> callPaymentAPI(int userId, int amount) {
        Result result = Result.initInstance();

        // Make the external API call
        String apiUrl = "../TestPaymentAPI"; // Replace this with the actual API URL
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestBody = "{\"userId\":" + userId + ",\"amount\":" + amount + "}";
        // Build request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Make the HTTP POST request and get the response entity
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

        // Check if the call was successful
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            // Extract response body
            String responseBody = responseEntity.getBody();
            // Parse the response body as JSON
            JSONObject jsonResponse;
            try {
                jsonResponse = new JSONObject(responseBody);
                // Extract userId from the JSON response
                int responseUserId = jsonResponse.getInt("userId");
                int responseUserAmount = jsonResponse.getInt("userAmount");
                boolean responsePaymentStatus = jsonResponse.getBoolean("userPaymentStatus");

                // Process the response and make payment
                String paymentResult = PaymentService.addPayment(responseUserId, responseUserAmount, responsePaymentStatus);

                // Return a success response
                return ResponseEntity.ok(result);
            } catch (JSONException ex) {
                ex.printStackTrace();
                result.setMessage("Failed to parse response body");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
            }
        } else {
            // Handle API call failure
            result.setMessage("Failed to make payment. External API returned: " + responseEntity.getStatusCode());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }
}