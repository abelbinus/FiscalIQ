package com.main.FiscalIQ.service;

import com.main.FiscalIQ.repository.FinanceRepository;
import com.main.FiscalIQ.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is for handling project.
 */
@Service
public class FinanceManagementService {

    @Autowired
    private FinanceRepository financeRepository;
    @Autowired
    private UserRepository userRepository;

}
