package com.main.FiscalIQ.model;

public class Message extends Notification {
    public Message(String notification) {
        super(notification);
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending message: " + notification);
    }

    public String getMessage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMessage'");
    }
}
