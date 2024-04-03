package com.main.FiscalIQ.service;

import com.main.FiscalIQ.model.FinanceDetail;
import com.main.FiscalIQ.model.UserDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is for handling project.
 */
@Service
public class FinanceManagementService {

    @Autowired
    private FinanceDetail financeDetail;
    @Autowired
    private UserDetail userDetail;

}
