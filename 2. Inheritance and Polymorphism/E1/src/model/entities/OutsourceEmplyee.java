package model.entities;

public class OutsourceEmplyee extends Employee{
    private Double additionalCharge;
    public OutsourceEmplyee(){
        super();
    }
    public OutsourceEmplyee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    public Double getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(Double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    @Override
    public Double payment(){
        return super.payment() + getAdditionalCharge();
    }
}
