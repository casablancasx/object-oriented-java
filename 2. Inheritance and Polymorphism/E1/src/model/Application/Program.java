package model.Application;

import model.entities.Employee;
import model.entities.OutsourceEmplyee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.print("Enter the number of employeers: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            System.out.print("Outsourced (y/n): ");
            String decision = sc.next();
            System.out.println("Employee #" + i +" data:");
            if (decision.equals("n")){
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Hours: ");
                int hours = sc.nextInt();
                System.out.print("Value per hour: ");
                Double valuePerHour = sc.nextDouble();
                Employee employee = new Employee(name,hours,valuePerHour);
                employees.add(employee);
            } else {
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Hours: ");
                int hours = sc.nextInt();
                System.out.print("Value per hour: ");
                Double valuePerHour = sc.nextDouble();
                System.out.print("Additional charge: ");
                Double additionalCharge = sc.nextDouble();
                Employee outsourceEmployee = new OutsourceEmplyee(name,hours,valuePerHour,additionalCharge);
                employees.add(outsourceEmployee);
            }
        }
        System.out.println();
        System.out.println("PAYMENT");
        for (Employee e : employees){
            System.out.println(e);
        }
    }
}
