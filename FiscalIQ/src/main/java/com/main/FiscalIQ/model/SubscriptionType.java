package com.main.FiscalIQ.model;

public enum SubscriptionType {
    NOT_ACTIVE,
    TIER1,
    TIER2;

    public int getCost() {
        switch (this) {
            case TIER1:
                return 5;
            case TIER2:
                return 10;
            default:
                return 0; // Default cost for NOT_ACTIVE
        }
    }
}
