package com.main.FiscalIQ.FinanceManagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.FiscalIQ.common.Result;
import com.main.FiscalIQ.FinanceManagement.model.FinancialDataSet;
import com.main.FiscalIQ.FinanceManagement.service.FinancialDatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FinancialDataController {

    private final FinancialDatasetService financialDataService;

    @Autowired
    public FinancialDataController(FinancialDatasetService financialDataService) {
        this.financialDataService = financialDataService;
    }

    @PostMapping("/update-financial-data")
    public ResponseEntity<Result> updateFinancialData() {
        Result result = Result.initInstance();
        try {
            // Call the external API to get the updated financial data
            String apiUrl = "your_external_api_url_here"; // Replace with your external API URL
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                // Convert the JSON response body into FinancialDataSet object
                ObjectMapper objectMapper = new ObjectMapper();
                FinancialDataSet updatedData = objectMapper.readValue(response.getBody(), FinancialDataSet.class);

                // Call the service method to update financial data with the retrieved data
                financialDataService.updateFinancialData(updatedData);

                result.setMessage("Financial data updated successfully.");
                return ResponseEntity.ok(result);
            } else {
                result.setMessage("Failed to update financial data. External API returned: " + response.getStatusCode());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("Failed to update financial data: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }

    @Scheduled(cron = "0 0 0 ? * MON") // Run every Monday at midnight
    public void weeklyUpdate() {
        // Call the updateFinancialData method
        updateFinancialData();
    }

    @GetMapping("/financial-data")
    public ResponseEntity<FinancialDataSet> getFinancialData() {
        FinancialDataSet financialDataSet = financialDataService.getFinancialData();
        return ResponseEntity.ok(financialDataSet);
    }
}
