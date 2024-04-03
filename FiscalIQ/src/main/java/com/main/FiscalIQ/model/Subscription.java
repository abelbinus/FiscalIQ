package com.main.FiscalIQ.model;

import java.sql.Timestamp;

public class Subscription {
    private boolean active = false;
    private Timestamp startTime;
    private int userId;
    private int subscriptionId;
    private SubscriptionType subType;

    public Subscription() {
        this.startTime = new Timestamp(System.currentTimeMillis());
    }

    // Getters and setters for the fields

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public SubscriptionType getSubType() {
        return subType;
    }

    public void setSubType(SubscriptionType subType) {
        this.subType = subType;
    }
}
