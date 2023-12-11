import java.util.*;

public class Program {
    public static void main(String[] args) {
        Product p1 = new Product("Casa", 900.00);
        Product p2 = new Product("iPhone", 300.00);
        Product p3 = new Product("Tv", 5000.00);
        Product p4 = new Product("Arroz", 200000.00);
        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        Collections.sort(productList);

        for (Product p : productList) {
            System.out.println(p);
        }
    }
}
