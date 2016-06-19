package com.sky.nighthawk.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/06/19.
 */
public class SubscribeReq implements Serializable {
    private static final long serialVersionUID = -467954931365156755L;
    private int subReqID;
    private String userName;
    private String productName;
    private String phoneNumber;
    private String address;

    public int getSubReqID() {
        return subReqID;
    }

    public void setSubReqID(int subReqID) {
        this.subReqID = subReqID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SubscribeReq [subReqID=" +
                subReqID + ", userName=" +
                userName + ", productName=" +
                productName + ", phoneNumber=" +
                phoneNumber + ", address=" +
                address + "]";
    }
}
