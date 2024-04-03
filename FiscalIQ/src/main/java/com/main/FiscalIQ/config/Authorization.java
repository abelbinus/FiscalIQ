package com.main.FiscalIQ.config;

public class Authorization {

    private int userId;
    private String rollType;
    private SessionManagement sessionManagement;

    public String authorize(int userId) {
        sessionManagement.createSession(userId);
        return "";
    }
}
