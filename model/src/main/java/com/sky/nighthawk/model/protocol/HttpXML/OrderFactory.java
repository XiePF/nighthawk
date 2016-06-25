package com.sky.nighthawk.model.protocol.HttpXML;

/**
 * Created by xpf on 2016/06/25.
 */
public class OrderFactory {
    public static Order create(long orderID) {
        Order order = new Order();
        order.setOrderNumber(orderID);
        order.setTotal(9999.999f);
        Address address = new Address();
        address.setCity("西安");
        address.setCountry("中国");
        address.setPostCode("123321");
        address.setState("陕西");
        address.setStreet1("高新六路");
        order.setBillTo(address);
        Customer customer = new Customer();
        customer.setCustomerNumber(orderID);
        customer.setFirstName("小");
        customer.setLastName("明");
        order.setCustomer(customer);
        order.setShipping(Shipping.INTERNATIONAL_MAIL);
        order.setShipTo(address);
        return order;
    }
}
