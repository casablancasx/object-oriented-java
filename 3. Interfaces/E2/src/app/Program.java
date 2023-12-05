package app;

import entities.BrazilInterestService;
import entities.InterestService;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.printf("Amount: ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();
        InterestService is = new BrazilInterestService(1);
        System.out.println("Payment after " + months + " months");
        System.out.printf("%.2f", is.payment(amount,months));
    }
}
