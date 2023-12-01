package model.app;

import model.entities.Company;
import model.entities.Individual;
import model.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of tax payers: ");
        int n = sc.nextInt();
        List<TaxPayer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax player #" +i+ " data:");
            System.out.println("Individual or company (i/c)? ");
            String decision = sc.next();
            if (decision.equals("i")) {
                System.out.println("Name: ");
                String name = sc.next();
                System.out.println("Anual income: ");
                double anualIncome = sc.nextDouble();
                System.out.println("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                Individual individual = new Individual(name, anualIncome, healthExpenditures);
                list.add(individual);
                System.out.println("Taxes: " + individual.tax());
            } else if (decision.equals("c")) {
                System.out.println("Name: ");
                String name = sc.next();
                System.out.println("Anual income: ");
                double anualIncome = sc.nextDouble();
                System.out.println("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                Company company = new Company(name, anualIncome, numberOfEmployees);
                System.out.println("Taxes: " + company.tax());
                list.add(company);
            }
        }
        System.out.println("TAXEX PAID: ");
        for (TaxPayer tp : list) {
            System.out.println(tp);
        }
        sc.close();
    }
}
