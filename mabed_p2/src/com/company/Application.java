package com.company;

public class Application {

    public static void main(String[] args) {
	// write your code here
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        saver1.setSavingsBalance(2000);
        saver2.setSavingsBalance(3000);
        saver1.setRate(.04);
        saver2.setRate(.04);
        System.out.println("STARTING BALANCES:");
        System.out.print("Saver 1 Balance: ");
        System.out.printf("%.2f\n", saver1.getBalance());
        System.out.print("Saver 2 Balance: ");
        System.out.printf("%.2f\n\n", saver2.getBalance());
        System.out.println("ACCOUNT BALANCE FOR NEXT 12 MONTHS AT 4% ANNUAL INTEREST RATE");
        for(int i=0;i<12;i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.print("Saver 1 Balance after Month " + (i+1) + ": ");
            System.out.printf("%.2f\n", saver1.getBalance());
            System.out.print("Saver 2 Balance after Month " + (i+1) + ": ");
            System.out.printf("%.2f\n\n", saver2.getBalance());
        }

        saver1.setRate(.05);
        saver2.setRate(.05);
        System.out.println("NEXT MONTH'S BALANCE AT 5% ANNUAL INTEREST RATE");
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.print("Saver 1 Balance: ");
        System.out.printf("%.2f\n", saver1.getBalance());
        System.out.print("Saver 2 Balance: ");
        System.out.printf("%.2f\n\n", saver2.getBalance());
    }
}
