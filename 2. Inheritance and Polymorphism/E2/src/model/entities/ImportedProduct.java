package model.entities;

public class ImportedProduct extends Product{
    private double customsFee;
    public ImportedProduct(){}
    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) {
        this.customsFee = customsFee;
    }

    public Double totalPrice(){
        return getPrice() + customsFee;
    }

    @Override
    public String priceTag(){
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + " $ " + getPrice() + " (Customs fee: $ " + totalPrice() + " )" );

        return sb.toString();
    }
}
