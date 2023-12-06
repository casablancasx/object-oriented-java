package app;

import entities.PrintService;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.print("How many values: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PrintService<Integer> ps = new PrintService<>();
        for (int i = 0; i < n; i++) {
            Integer value = sc.nextInt();
            ps.addValue(value);
        }
        ps.print();
    }
}
