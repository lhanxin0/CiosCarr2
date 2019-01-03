package com.example.user.cioscarr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class booking_summary extends main_navDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Booking Summary");
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_booking_summary, null, false);
        drawer.addView(contentView, 0);



    }

    public void returnPayment(View view) {


        Intent intent = new Intent(this, payment.class);
        startActivity(intent);
    }
}
