package com.company;

public class SavingsAccount {
    private double annualInterestRate;
    private double savingsBalance;

    SavingsAccount(){
        savingsBalance = 0;
        annualInterestRate =0;
    }

    public void calculateMonthlyInterest(){
        double interest;
        interest = ((this.savingsBalance * annualInterestRate)/12);
        this.savingsBalance += interest;
    }

    public void modifyInterestRate(double newRate){
        annualInterestRate = newRate;
    }

    public double getBalance(){
        return this.savingsBalance;
    }

    public void setRate(double rate){
        this.annualInterestRate = rate;
    }

    public void setSavingsBalance(double balance){
        this.savingsBalance = balance;
    }

    public double getRate(){
        return this.annualInterestRate;
    }

}
