package com.main.FiscalIQ.model;

public enum SubscriptionType {
    NOT_ACTIVE,
    TIER1,
    TIER2;

    public int getCost() {
        return switch (this) {
            case TIER1 -> 5;
            case TIER2 -> 10;
            default -> 0; // Default cost for NOT_ACTIVE
        };
    }
}
