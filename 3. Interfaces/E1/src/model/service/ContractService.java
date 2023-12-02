package model.service;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
    }

    public OnlinePaymentService getOnlinePaymentService() {
        return onlinePaymentService;
    }

    public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months){
        double basicQuota = contract.getTotalValue()/ months;
        LocalDate date = contract.getDate();
        int yearDate = date.getYear();
        int monthDate = date.getMonthValue();
        int dayDate = date.getDayOfMonth();
        double value = 0.0;
        for (int i = 1; i <= months; i++) {
            monthDate += 1;
            double valueInterst = basicQuota + onlinePaymentService.interest(basicQuota, i);
            double valueFee = valueInterst + onlinePaymentService.paymentFee(valueInterst);
            Installment installment =new Installment(LocalDate.of(yearDate,monthDate,dayDate), valueFee);
            contract.addInstallment(installment);
        }
    }
}
