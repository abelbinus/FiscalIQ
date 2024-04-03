package com.main.FiscalIQ.service;

import com.main.FiscalIQ.model.Alert;
import com.main.FiscalIQ.model.Message;
import com.main.FiscalIQ.model.Notification;
import com.main.FiscalIQ.model.Reminder;

public class NotificationManagementService {
    public void displayNotification(Notification notification) {
        if (notification instanceof Reminder) {
            Reminder reminder = (Reminder) notification;
            System.out.println("Displaying reminder: " + reminder.getReminder());
        } else if (notification instanceof Alert) {
            Alert alert = (Alert) notification;
            System.out.println("Displaying alert: " + alert.getAlert());
        } else if (notification instanceof Message) {
            Message message = (Message) notification;
            System.out.println("Displaying message: " + message.getMessage());
        } else {
            System.out.println("Unknown notification type");
        }
    }
}
