package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
    private LocalDate moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> orderItem = new ArrayList<>();

    public Order(LocalDate moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public LocalDate getMoment() {
        return this.moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItem() {
        return this.orderItem;
    }

}
