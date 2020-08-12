package com.khayrul.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeDeliveryOrder {

    String name, phone, address, order;
    String date, status, id, email;

    public HomeDeliveryOrder(String id, String name, String phone, String email, String address, String order, String status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.order = order;
        this.status = status;
        Date dateTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        this.date = sdf.format(dateTime);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getOrder() {
        return order;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
