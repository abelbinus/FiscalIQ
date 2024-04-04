package com.main.FiscalIQ.NotificationManagement.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Notification {

    protected int notificationId;
    protected int userId;
    protected Map<Long, String> notificationMap;

    public Notification() {
        this.notificationMap = new HashMap<>();
    }

    public Notification(Map<Long, String> notification) {
        //TODO Auto-generated constructor stub
        this.notificationMap = notification;
    }

    public void addNotification(int userId, long timestamp, String message) {
        notificationMap.put(timestamp, message);
    }

    public void removeNotification(long timestamp) {
        notificationMap.remove(timestamp);
    }

    public String getNotification(long timestamp) {
        return notificationMap.get(timestamp);
    }

    public abstract void sendNotification();
}
