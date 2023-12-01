package model.entities;

import model.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDate moment;
    private OrderStatus status;
    private List<OrderItem> orderItemList = new ArrayList<>();
    private Client client;

    public Order(){}
    public Order(LocalDate moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrdemItemList() {
        return orderItemList;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        orderItemList.add(item);
    }
    public void removeItem(OrderItem item){
        orderItemList.remove(item);
    }
    public Double total(){
        Double sum = 0.0;
        for (OrderItem item : orderItemList){
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(getMoment() + "\n");
        sb.append("Order status: ");
        sb.append(getStatus() + "\n");
        sb.append("Client: ");
        sb.append(getClient().getName() + "\n");
        sb.append("Order items:\n");
        for (OrderItem item : orderItemList) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }



}
