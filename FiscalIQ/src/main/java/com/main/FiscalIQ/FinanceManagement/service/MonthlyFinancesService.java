package com.main.FiscalIQ.FinanceManagement.service;

import com.main.FiscalIQ.FinanceManagement.model.MonthlyFinances;
import org.springframework.stereotype.Service;

@Service
public class MonthlyFinancesService {

    private MonthlyFinances monthlyFinances;

    public void addMonthlyFinances(MonthlyFinances monthlyFinances) {
        // Logic to store the monthly finances data (e.g., save to database)
    }

    public void updateMonthlyFinances(long id, MonthlyFinances updatedMonthlyFinances) {
        // Logic to update the monthly finances data with the specified ID
    }

    public void deleteMonthlyFinances(long id) {
        // Logic to delete the monthly finances data with the specified ID
    }
}