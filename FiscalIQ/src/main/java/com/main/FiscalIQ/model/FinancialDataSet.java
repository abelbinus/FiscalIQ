package com.main.FiscalIQ.model;

import java.util.Map;

public class FinancialDataSet {
    private Map<String, Double> interestRates;
    private Map<String, Double> loanRates;
    private Map<String, Double> mortgageRates;
    private Map<String, Double> sharePricesFTSE100;
    private Map<String, Double> investmentFundPerformance;
    private Map<String, Double> loanPerformance;
    private Map<String, Double> mortgagePerformance;

    // Constructor
    public FinancialDataSet(Map<String, Double> interestRates, Map<String, Double> loanRates,
                            Map<String, Double> mortgageRates, Map<String, Double> sharePricesFTSE100,
                            Map<String, Double> investmentFundPerformance) {
        this.interestRates = interestRates;
        this.loanRates = loanRates;
        this.mortgageRates = mortgageRates;
        this.sharePricesFTSE100 = sharePricesFTSE100;
        this.investmentFundPerformance = investmentFundPerformance;
    }

    // Getters and setters
    public Map<String, Double> getInterestRates() {
        return interestRates;
    }

    public void setInterestRates(Map<String, Double> interestRates) {
        this.interestRates = interestRates;
    }

    public Map<String, Double> getLoanRates() {
        return loanRates;
    }

    public void setLoanRates(Map<String, Double> loanRates) {
        this.loanRates = loanRates;
    }

    public Map<String, Double> getMortgageRates() {
        return mortgageRates;
    }

    public void setMortgageRates(Map<String, Double> mortgageRates) {
        this.mortgageRates = mortgageRates;
    }

    public Map<String, Double> getSharePricesFTSE100() {
        return sharePricesFTSE100;
    }

    public void setSharePricesFTSE100(Map<String, Double> sharePricesFTSE100) {
        this.sharePricesFTSE100 = sharePricesFTSE100;
    }

    public Map<String, Double> getInvestmentFundPerformance() {
        return investmentFundPerformance;
    }

    public void setInvestmentFundPerformance(Map<String, Double> investmentFundPerformance) {
        this.investmentFundPerformance = investmentFundPerformance;
    }

    public Map<String, Double> getloanPerformance() {
        return investmentFundPerformance;
    }

    public void setloanPerformance(Map<String, Double> investmentFundPerformance) {
        this.investmentFundPerformance = investmentFundPerformance;
    }

    public Map<String, Double> getmortgagePerformance() {
        return investmentFundPerformance;
    }

    public void setmortgageFundPerformance(Map<String, Double> investmentFundPerformance) {
        this.investmentFundPerformance = investmentFundPerformance;
    }
}
