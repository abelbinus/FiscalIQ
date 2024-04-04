package com.main.FiscalIQ.NotificationManagement.model;

import java.util.Map;

public class Reminder extends Notification {
    public Reminder(Map<Long, String> notification) {
        super(notification);
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending reminder: ");
    }

    public String getReminder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReminder'");
    }
}
