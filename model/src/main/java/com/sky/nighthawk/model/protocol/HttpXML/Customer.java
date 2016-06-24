package com.sky.nighthawk.model.protocol.HttpXML;

import java.util.List;

/**
 * Created by xpf on 2016/06/24.
 */
public class Customer {
    private long customerNumber;

    private  String firstName;

    private String lastName;

    private List<String> middleNames;


    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }
}
