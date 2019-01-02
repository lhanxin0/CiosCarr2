package com.example.user.cioscarr;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;
@Entity(tableName = "Order_car")
public class Order_car {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="order_car_id")
    private String order_car_id;

    @ColumnInfo(name="order_car_sDate")
    private String start_date;

    @ColumnInfo(name="order_car_rDate")
    private String return_date;

    @ColumnInfo(name="order_car_sTime")
    private String start_time;

    @ColumnInfo(name="order_car_rTime")
    private String return_time;

    @ForeignKey(entity = Order.class,
            parentColumns = "order_id",
            childColumns = "order_id")
    @NonNull
    @ColumnInfo(name = "order_id")
    private String  order_id;

    @ForeignKey(entity = Car.class,
            parentColumns = "car_id",
            childColumns = "car_id")
    @NonNull
    @ColumnInfo(name = "car_id")
    private String  car_id;


    public Order_car(@NonNull String order_car_id, String start_date, String return_date, String start_time, String return_time, @NonNull String order_id, @NonNull String car_id) {
        this.order_car_id = order_car_id;
        this.start_date = start_date;
        this.return_date = return_date;
        this.start_time = start_time;
        this.return_time = return_time;
        this.order_id = order_id;
        this.car_id = car_id;
    }

    @NonNull
    public String getOrder_car_id() {
        return order_car_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getReturn_time() {
        return return_time;
    }

    @NonNull
    public String getOrder_id() {
        return order_id;
    }

    @NonNull
    public String getCar_id() {
        return car_id;
    }
}
