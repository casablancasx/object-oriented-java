package model.service;

public class PaypalService implements OnlinePaymentService {
    @Override
    public double interest(double amount, int months) {
        double tax = amount * months/100;
        return tax;
    }

    @Override
    public double paymentFee(double amount) {
        return amount * 0.02;
    }
}
