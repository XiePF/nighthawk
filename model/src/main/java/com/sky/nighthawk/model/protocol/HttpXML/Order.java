package com.sky.nighthawk.model.protocol.HttpXML;

/**
 * Created by xpf on 2016/06/24.
 */
public class Order {
    private long orderNumber;

    private  Customer customer;

    private  Address billTo;

    private  Shipping shippiing;

    private  Address shipTo;

    private  Float total;

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getBillTo() {
        return billTo;
    }

    public void setBillTo(Address billTo) {
        this.billTo = billTo;
    }

    public Shipping getShippiing() {
        return shippiing;
    }

    public void setShippiing(Shipping shippiing) {
        this.shippiing = shippiing;
    }

    public Address getShipTo() {
        return shipTo;
    }

    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}