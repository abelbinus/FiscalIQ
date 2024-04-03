package com.main.FiscalIQ.model;

import java.util.Map;

public class Alert extends Notification {
    public Alert(Map<Long, String> notification) {
        super(notification);
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending alert: ");
    }

}