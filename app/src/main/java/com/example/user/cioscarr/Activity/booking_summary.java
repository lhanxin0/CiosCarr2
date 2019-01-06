package com.example.user.cioscarr.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.user.cioscarr.R;

import org.w3c.dom.Text;

public class booking_summary extends main_navDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Booking Summary");
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_booking_summary, null, false);
        drawer.addView(contentView, 0);

        TextView carName = findViewById(R.id.txtCar_name);
        TextView pickUpDetail2 = findViewById(R.id.txtPickup_location);
        TextView pickUpDetail = findViewById(R.id.txtPickup_detail);
        TextView dropOffDate = findViewById(R.id.txtDropoff_datetime);
        TextView dropOffDetail = findViewById(R.id.txtDropoff_detail);
        TextView paymentDetail = findViewById(R.id.textView8);
        TextView totalPrice = findViewById(R.id.textView10);

        Intent intent = getIntent();
        String car_name = intent.getStringExtra(payment.carName);
        carName.setText(car_name);
        String card_cvv = intent.getStringExtra(payment.cardcvv);
        pickUpDetail.setText(card_cvv);
        String pay_date = intent.getStringExtra(payment.paydate);
        dropOffDetail.setText(pay_date);
        String payment_detail = intent.getStringExtra(payment.paymentDetails);
        paymentDetail.setText(payment_detail);

        String card_expiry = intent.getStringExtra(payment.cardExpiry);
        totalPrice.setText(card_expiry);

        pickUpDetail2.setText(card_expiry);
    }

    public void returnPayment(View view) {


        Intent intent = new Intent(this, payment.class);
        startActivity(intent);
    }
}
