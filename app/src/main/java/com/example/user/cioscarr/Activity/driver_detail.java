package com.example.user.cioscarr.Activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.user.cioscarr.R;

public class driver_detail extends main_navDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Driver Details");
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_driver_detail, null, false);
        drawer.addView(contentView, 0);

        Intent intent = getIntent();
        String take_date = intent.getStringExtra(reservation.Extra_Message);
        String return_date = intent.getStringExtra(reservation.Extra_Message1);



        EditText txtDate = findViewById(R.id.txtDriver_name);
        txtDate.setText(take_date);
        EditText txtRDate = findViewById(R.id.txtDriver_ic);
        txtRDate.setText(return_date);

    }

    public void paymentListener(View view) {

        Intent intent = new Intent(this, payment.class);
        startActivity(intent);

    }
}
