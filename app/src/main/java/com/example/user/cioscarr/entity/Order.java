package com.example.user.cioscarr.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Order",
        foreignKeys = {
                @ForeignKey(
                        entity = Order_car.class,
                        parentColumns = "order_car_id",
                        childColumns = "order_car_id"
                ), @ForeignKey(entity = Person.class,
                parentColumns = "uid",
                childColumns = "cust_id")})
public class Order {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "order_id")
    private String order_ID;

    @ColumnInfo(name = "price")
    private double price;

    @ColumnInfo(name = "cust_id")
    private String cust_id;

    @ColumnInfo(name = "order_car_id")
    private String order_car_id;


    public Order(String order_ID, double price, String cust_id, String order_car_id) {
        this.order_ID = order_ID;
        this.price = price;
        this.cust_id = cust_id;

        this.order_car_id = order_car_id;
    }

    public String getOrder_ID() {
        return order_ID;
    }

    public double getPrice() {
        return price;
    }

    public String getCust_id() {
        return cust_id;
    }


    public String getOrder_car_id() {
        return order_car_id;
    }
}

