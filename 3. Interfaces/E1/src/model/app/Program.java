package model.app;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Enter with the contract data: ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Number :");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        String date = sc.next();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date,dtf);
        System.out.print("Contract value: ");
        double value = sc.nextDouble();
        Contract contract = new Contract(number,localDate,value);
        System.out.print("Enter with the number of installments: ");
        int months = sc.nextInt();

        ContractService service = new ContractService(new PaypalService());
        service.processContract(contract,months);

        System.out.println("Installaments");

        for (Installment i : contract.getInstallments()){
            System.out.println(i.toString());
        }
    }
}
