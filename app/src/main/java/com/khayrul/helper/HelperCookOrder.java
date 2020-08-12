package com.khayrul.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperCookOrder {
    private String id, name, phone, email;
    private String address, pack, comment;
    private String quantity, price, status;
    private String date;

    public HelperCookOrder(String id, String name, String phone, String email,
                           String address, String pack, String comment, String quantity, String price, String status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.pack = pack;
        this.comment = comment;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        Date dateTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        this.date = sdf.format(dateTime);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPack() {
        return pack;
    }

    public String getComment() {
        return comment;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
