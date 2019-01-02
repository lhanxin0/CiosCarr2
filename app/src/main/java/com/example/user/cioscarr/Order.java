package com.example.user.cioscarr;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
@Entity(tableName = "Order")
public class Order {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="order_id")
    private String order_ID;

    @ColumnInfo(name="quantity")
    private int quantity;

    @ColumnInfo(name="price")
    private double price;


    @ForeignKey(entity = Person.class,
            parentColumns = "uid",
            childColumns = "cust_id")
    @ColumnInfo(name="uid")
    private String cust_id;

    @ForeignKey(entity = Supplier.class,
            parentColumns = "supplier_id",
            childColumns = "supplier_id")
    @ColumnInfo(name="supplier_id")
    private String supplier_id;

    @ForeignKey(entity = Order_car.class,
            parentColumns = "order_car_id",
            childColumns = "order_car_id")
    @ColumnInfo(name="order_car_id")
    private String order_car_id;


    public Order(String order_ID, int quantity, double price, String cust_id, String supplier_id, String order_car_id) {
        this.order_ID = order_ID;
        this.quantity = quantity;
        this.price = price;
        this.cust_id = cust_id;
        this.supplier_id = supplier_id;
        this.order_car_id = order_car_id;
    }

    public String getOrder_ID() {
        return order_ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getCust_id() {
        return cust_id;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public String getOrder_car_id() {
        return order_car_id;
    }
}

