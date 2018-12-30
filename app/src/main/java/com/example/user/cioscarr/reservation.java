package com.example.user.cioscarr;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class reservation extends main_navDrawer {

    public static final String Extra_Message = "com.example.user.cioscarr.Extra_Message";
    public static final String Extra_Message1 = "com.example.user.cioscarr.Extra_Message1";

    final Calendar myCalendar = Calendar.getInstance();
    EditText txtTake_Date;
    EditText txtReturn_Date;
    EditText txtTake_time;
    EditText txtReturn_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Book A Car");
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_reservation, null, false);
        drawer.addView(contentView, 0);

        // Find date and time txtbox
        txtTake_Date = findViewById(R.id.txtDate);
        txtReturn_Date = findViewById(R.id.editText2);
        txtTake_time = findViewById(R.id.txtTime);
        txtReturn_time = findViewById(R.id.txtReturn_time);


        // Date picker
        final DatePickerDialog.OnDateSetListener take_date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();

            }

        };

        final DatePickerDialog.OnDateSetListener return_date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelReturn();
            }
        };

    // Date onclick
        txtTake_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(reservation.this, take_date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        txtReturn_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(reservation.this, return_date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


            //time picker
        txtTake_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
                int minute = myCalendar.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(reservation.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        txtTake_time.setText(hourOfDay + ":" + minute);

                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        txtReturn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
                int minute = myCalendar.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(reservation.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        txtReturn_time.setText(hourOfDay + ":" + minute);

                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });





    }





    //date picker setTex
    private void updateLabel() {
        // String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        txtTake_Date.setText(sdf.format(myCalendar.getTime()));

    }

    private void updateLabelReturn() {
        // String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        txtReturn_Date.setText(sdf.format(myCalendar.getTime()));
    }

    public void searchListener(View view) {

        String take_car_date = txtTake_Date.getText().toString();
        String return_car_date = txtReturn_Date.getText().toString();

        Intent intent = new Intent(this, driver_detail.class);
        intent.putExtra(Extra_Message, take_car_date);
        intent.putExtra(Extra_Message1, return_car_date);



        startActivity(intent);


    }
}
