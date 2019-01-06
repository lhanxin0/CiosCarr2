package com.example.user.cioscarr.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.user.cioscarr.R;
import com.example.user.cioscarr.ViewModel.CarViewModel;
import com.example.user.cioscarr.ViewModel.SupplierViewModel;
import com.example.user.cioscarr.entity.Supplier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class reservation extends main_navDrawer {

    public static final String Extra_Message = "com.example.user.cioscarr.Extra_Message";
    public static final String Extra_Message1 = "com.example.user.cioscarr.Extra_Message1";

    final Calendar myCalendar = Calendar.getInstance();
    TextView txtTake_Date;
    TextView txtReturn_Date;
    TextView txtTake_time;
    TextView txtReturn_time;

    private SupplierViewModel svm;
    private CarViewModel cvm;
    private Spinner s;
    private Spinner stype;



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
        cvm = ViewModelProviders.of(this).get(CarViewModel.class);
        svm = ViewModelProviders.of(this).get(SupplierViewModel.class);




       // txtReturn_Date.setText(cvm.getAllCarType().get(0));
       List<Supplier> SupplierArea = svm.getSupplier();
       List<String> CarType = cvm.getAllCarType();




       List<String> area = new ArrayList<>();
       List<String> ct = new ArrayList<>();
       List<String> car_type = new ArrayList<>();
       for(Supplier s : SupplierArea){
           area.add(s.getArea());
       }

       ct = cvm.getAllCarType();

       for(String cc:ct)
       {
           int count=0;
           if(car_type.size()==0)
               car_type.add(cc);
           else
           {
               for(String ccc:car_type)
               {
                   if(ccc.equals(cc))
                   {
                       count=1;
                   }
               }
               if(count==0)
               {
                   car_type.add(cc);
               }
           }
       }

        s = (Spinner) findViewById(R.id.spinnerArea);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, area);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        stype = (Spinner) findViewById(R.id.spinnerCarType);
        ArrayAdapter<String> adapterCType = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, car_type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stype.setAdapter(adapterCType);


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
        String cartype = stype.getSelectedItem().toString();
        String cararea = s.getSelectedItem().toString();
        Intent intent = new Intent(this, Choose_car.class);
        Intent intent2 = getIntent();
        intent.putExtra("carType", cartype);
        intent.putExtra("carArea", cararea);
        intent.putExtra("custID", intent2.getStringExtra("custID"));
        intent.putExtra("takedate", txtTake_Date.getText().toString());
        intent.putExtra("returndate", txtReturn_Date.getText().toString());
        startActivity(intent);


    }
}
