package com.main.FiscalIQ.controller;

import com.main.FiscalIQ.common.Result;
import com.main.FiscalIQ.config.AuthHandler;
import com.main.FiscalIQ.service.UserManagementService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Controller class for handling user login and logout operations.
 */
@RestController
@RequestMapping(("/api/authentication"))
public class LoginController {


    @Autowired
    UserManagementService userManagementService;
    
    private AuthHandler authHandler;

    /**
     * Endpoint for user login.
     *
     * @param request      HttpServletRequest object.
     * @param response     HttpServletResponse object.
     * @param userPassword UserPassword object containing user credentials.
     * @return ResponseEntity containing login result.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<Result> userLogin(HttpRequest request, @SuppressWarnings("rawtypes") HttpResponse response, @RequestBody String userPassword) {
        Result result = Result.initInstance();
        String userName = "";
        String password = "";
        authHandler.authenticate(userName, password);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }



    /**
     * Endpoint for user logout.
     *
     * @param request  HttpServletRequest object.
     * @param response HttpServletResponse object.
     */
    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
    }
}
