package com.example.user.cioscarr.entity;

import android.arch.persistence.room.ColumnInfo;

public class Bh {
    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name = "car_plate_no")
    private String car_plate_no;

    @ColumnInfo(name = "car_name")
    private String car_name;

    @ColumnInfo(name="order_car_sDate")
    private String start_date;

    @ColumnInfo(name="order_car_rDate")
    private String return_date;

    @ColumnInfo(name = "price")
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar_plate_no() {
        return car_plate_no;
    }

    public void setCar_plate_no(String car_plate_no) {
        this.car_plate_no = car_plate_no;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
