package com.main.FiscalIQ.NotificationManagement.service;

import com.main.FiscalIQ.NotificationManagement.model.Alert;
import com.main.FiscalIQ.NotificationManagement.model.Message;
import com.main.FiscalIQ.NotificationManagement.model.Notification;
import com.main.FiscalIQ.NotificationManagement.model.Reminder;

public class NotificationManagementService {
    public void displayNotification(Notification notification) {
        if (notification instanceof Reminder) {
            Reminder reminder = (Reminder) notification;
            System.out.println("Displaying reminder: ");
            reminder.sendNotification();
        } else if (notification instanceof Alert) {
            Alert alert = (Alert) notification;
            System.out.println("Displaying alert: ");
            alert.sendNotification();
        } else if (notification instanceof Message) {
            Message message = (Message) notification;
            System.out.println("Displaying message: ");
            message.sendNotification();
        } else {
            System.out.println("Unknown notification type");
        }
    }
}
