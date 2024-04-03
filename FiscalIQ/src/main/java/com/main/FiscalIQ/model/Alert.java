package com.main.FiscalIQ.model;

public class Alert extends Notification {
    public Alert(String notification) {
        super(notification);
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending alert: " + notification);
    }

    public String getAlert() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAlert'");
    }
}