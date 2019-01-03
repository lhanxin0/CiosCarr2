package com.example.user.cioscarr.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
@Entity(tableName = "Car",
        foreignKeys = {
                @ForeignKey(
                        entity = Supplier.class,
                        parentColumns = "supplier_id",
                        childColumns = "supplier_id"
                )})
public class Car {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "car_id")
    private String car_id;

    @ColumnInfo(name = "car_type")
    private String car_type;

    @ColumnInfo(name = "car_color")
    private String car_color;

    @ColumnInfo(name = "car_desc")
    private String car_desc;

    @ColumnInfo(name = "car_price")
    private double car_price;

    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "supplier_id")
    private String supplier_id;

    public Car(@NonNull String car_id, String car_type, String car_color, String car_desc, double car_price, String status, String supplier_id) {
        this.car_id = car_id;
        this.car_type = car_type;
        this.car_color = car_color;
        this.car_desc = car_desc;
        this.car_price = car_price;
        this.status = status;
        this.supplier_id = supplier_id;
    }

    @NonNull
    public String getCar_id() {
        return car_id;
    }

    public String getCar_type() {
        return car_type;
    }

    public String getCar_color() {
        return car_color;
    }

    public String getCar_desc() {
        return car_desc;
    }

    public double getCar_price() {
        return car_price;
    }

    public String getStatus() {
        return status;
    }

    public String getSupplier_id() {
        return supplier_id;
    }
}
