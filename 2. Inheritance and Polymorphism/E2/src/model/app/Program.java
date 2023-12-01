package model.app;

import model.entities.ImportedProduct;
import model.entities.Product;
import model.entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.print("Enter the number of products: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.println("Product #"+i+" data:");
            System.out.print("Common, used or imported (c/u/i)?  ");
            String decision = sc.next();
            if (decision.equals("c")){
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                Product product = new Product(name,price);
                products.add(product);
            } else if (decision.equals("u")) {
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String date = sc.next();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.parse(date,dtf);
                Product productUsed = new UsedProduct(name,price,localDate);
                products.add(productUsed);
            } else {
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                Product productImported = new ImportedProduct(name,price,customsFee);
                products.add(productImported);
            }
        }
        System.out.println();
        System.out.println("PRICE TAG");
        for (Product p: products){
            System.out.println(p.priceTag());
        }
    }
}
