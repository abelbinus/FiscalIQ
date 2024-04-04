package com.main.FiscalIQ.FinanceManagement.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Recommendation<T> {
    private int recommendationId;
    private T userOption; // User's decision
    private T recommendationOption; // Recommendation

    public Recommendation(T userOption, T recommendationOption) {
        this.userOption = userOption;
        this.recommendationOption = recommendationOption;
    }

    public void setId(int recommendationId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    public Integer getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

}