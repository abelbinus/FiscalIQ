package com.main.FiscalIQ.controller;

import com.main.FiscalIQ.common.Result;
import com.main.FiscalIQ.model.FinanceDetail;
import com.main.FiscalIQ.service.FinanceManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling project-related endpoints.
 */
@RestController
@RequestMapping("/api/projectshare")
public class FinanceController {

    @Autowired
    private FinanceManagementService financeManagementService;

}
