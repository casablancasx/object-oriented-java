package app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Set<Integer> students = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many students for course A? :");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            students.add(sc.nextInt());
        }System.out.print("How many students for course B? :");
        int x = sc.nextInt();
        for (int i = 0; i < x; i++) {
            students.add(sc.nextInt());
        }System.out.print("How many students for course C? :");
        int z = sc.nextInt();
        for (int i = 0; i < z; i++) {
            students.add(sc.nextInt());
        }
        System.out.println("Total students: " + students.size());

    }
}
