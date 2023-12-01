package model.app;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        Scanner scanner = new Scanner(System.in);
        String nameClient = scanner.nextLine();
        System.out.print("Email: ");
        String emailClient = scanner.next();
        System.out.print("Birth Date (dd/MM/yyyy): ");
        String birthDateClient = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthDateClient, formatter);
        Client client = new Client(nameClient,emailClient, localDate);
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String statusOrder = scanner.next().toUpperCase();
        System.out.print("How many items to this order?: ");
        int n = scanner.nextInt();
        Order order = new Order(LocalDate.now(),OrderStatus.valueOf(statusOrder),client);
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #"+i+" item data:");
            System.out.print("Product name: ");
            String productName = scanner.next();
            System.out.print("Product price: ");
            double productPrice = scanner.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = scanner.nextInt();

            OrderItem orderItem = new OrderItem(productQuantity,productPrice,new Product(productName,productPrice));

            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println("ORDER SUMARY");
        System.out.println(order);











    }
}
