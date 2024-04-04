package com.main.FiscalIQ.NotificationManagement.model;

import java.util.Map;

public class Message extends Notification {
    public Message(Map<Long, String> notification) {
        super(notification);
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending message: ");
    }

    public String getMessage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMessage'");
    }
}
