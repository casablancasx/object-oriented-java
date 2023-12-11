public class MyComparator implements Comparable<Product>{

    @Override
    public int compareTo(Product p1, Product p2) {
        return p1.price.compareTo(p2.price);
    }
}
