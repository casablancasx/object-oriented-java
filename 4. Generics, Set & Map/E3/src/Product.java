import java.util.Comparator;
import java.util.Objects;

public class Product implements Comparable<Product>{
    private String nome;
    private double price;
    public Product(){}
    public Product(String nome, double price){
        this.nome = nome;
        this.price = price;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(nome, product.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, price);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getNome() + ", " + getPrice());
        return sb.toString();
    }


}
