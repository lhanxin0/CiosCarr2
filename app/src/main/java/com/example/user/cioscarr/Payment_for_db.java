package com.example.user.cioscarr;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;
@Entity(tableName = "Paymeny_for_db")
public class Payment_for_db {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="payment_id")
    private String payment_id;

    @ColumnInfo(name="pay_type")
    private String pay_type;

    @ColumnInfo(name="pay_date")
    private String pay_date;

    @ColumnInfo(name="card_num")
    private String card_num;

    @ColumnInfo(name="status")
    private String status;

    @ForeignKey(entity = Order.class,
            parentColumns = "order_id",
            childColumns = "order_id")
    @ColumnInfo(name="order_id")
    private String order_id;

    public Payment_for_db(@NonNull String payment_id, String pay_type, String pay_date, String card_num, String status, String order_id) {
        this.payment_id = payment_id;
        this.pay_type = pay_type;
        this.pay_date = pay_date;
        this.card_num = card_num;
        this.status = status;
        this.order_id = order_id;
    }

    @NonNull
    public String getPayment_id() {
        return payment_id;
    }

    public String getPay_type() {
        return pay_type;
    }

    public String getPay_date() {
        return pay_date;
    }

    public String getCard_num() {
        return card_num;
    }

    public String getStatus() {
        return status;
    }

    public String getOrder_id() {
        return order_id;
    }
}
