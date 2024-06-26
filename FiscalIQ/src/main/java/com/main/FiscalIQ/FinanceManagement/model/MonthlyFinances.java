package com.main.FiscalIQ.FinanceManagement.model;

public class MonthlyFinances {
    private int monthlyFinanceId;
    private int userId;
    private double salary;
    private double selfEmploymentIncome;
    private double otherIncome;
    private double mortgagePayment;
    private double utilityBills;

    // Constructors
    public MonthlyFinances() {
    }

    public MonthlyFinances(int monthlyFinanceId, int userId, double salary, double selfEmploymentIncome, double otherIncome, double mortgagePayment, double utilityBills) {
        this.monthlyFinanceId = monthlyFinanceId;
        this.userId = userId;
        this.salary = salary;
        this.selfEmploymentIncome = selfEmploymentIncome;
        this.otherIncome = otherIncome;
        this.mortgagePayment = mortgagePayment;
        this.utilityBills = utilityBills;
    }

    // Getters and setters
    public double getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getMonthlyFinanceId() {
        return userId;
    }

    public double setMonthlyFinanceId() {
        return userId;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSelfEmploymentIncome() {
        return selfEmploymentIncome;
    }

    public void setSelfEmploymentIncome(double selfEmploymentIncome) {
        this.selfEmploymentIncome = selfEmploymentIncome;
    }

    public double getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(double otherIncome) {
        this.otherIncome = otherIncome;
    }

    public double getMortgagePayment() {
        return mortgagePayment;
    }

    public void setMortgagePayment(double mortgagePayment) {
        this.mortgagePayment = mortgagePayment;
    }

    public double getUtilityBills() {
        return utilityBills;
    }

    public void setUtilityBills(double utilityBills) {
        this.utilityBills = utilityBills;
    }
}