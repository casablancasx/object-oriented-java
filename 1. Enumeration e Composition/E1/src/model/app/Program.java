package model.app;

import model.entities.Department;
import model.entities.HourContract;
import model.entities.Worker;
import model.entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.print("Enter department's name:");
        Scanner scanner = new Scanner(System.in);
        String departName = scanner.nextLine();
        System.out.println("Enter worker dataEnter worker data: ");
        System.out.print("Name: ");
        String nameWorker = scanner.nextLine();
        System.out.print("Level: ");
        String levelWorker = scanner.next().toUpperCase();
        System.out.print("Base salary: ");
        double baseSalary = scanner.nextDouble();

        Worker worker = new Worker(nameWorker, WorkerLevel.valueOf(levelWorker),baseSalary,new Department(departName));
        System.out.print("How many contracts to this worker?: ");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (dd/MM/yyyy): ");
            String dateString = scanner.next();
            System.out.print("Value per hour: ");
            double valuePerHour = scanner.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = scanner.nextInt();


            String[] dateVect = dateString.split("/");
            LocalDate date = LocalDate.of(Integer.parseInt(dateVect[2]),Integer.parseInt(dateVect[1]),Integer.parseInt(dateVect[0]));

            HourContract contract = new HourContract(date,valuePerHour,hours);
            worker.addContract(contract);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String dateString = scanner.next();
        String[] vect = dateString.split("/");
        int month = Integer.parseInt(vect[0]);
        int year = Integer.parseInt(vect[1]);
        System.out.println("Name: " + worker.getName());
        System.out.println("Department " + worker.getDepartment().getName());
        System.out.printf("Income for %s: %.2f %n", dateString, worker.income(year,month));

    }
}
