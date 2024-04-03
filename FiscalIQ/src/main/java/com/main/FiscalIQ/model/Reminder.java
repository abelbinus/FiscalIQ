package com.main.FiscalIQ.model;

public class Reminder extends Notification {
    public Reminder(String notification) {
        super(notification);
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending reminder: " + notification);
    }

    public String getReminder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReminder'");
    }
}
