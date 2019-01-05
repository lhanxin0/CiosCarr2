package com.example.user.cioscarr.Activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.user.cioscarr.R;
import com.example.user.cioscarr.ViewModel.PaymentViewModel;
import com.example.user.cioscarr.ViewModel.PersonViewModel;
import com.example.user.cioscarr.entity.Payment_for_db;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class payment extends main_navDrawer {

    final Calendar myCalendar = Calendar.getInstance();
    private EditText card_number;
    private EditText card_name;
    private EditText card_expiry;
    private EditText card_cvv;

    private PaymentViewModel paymentVM;


    public static final String carName = "com.example.android.cioscarr.EXTRA_MESSAGE";
    public static final String cardcvv = "com.example.android.cioscarr.EXTRA_MESSAGE2";
    public static final String cardExpiry = "com.example.android.cioscarr.EXTRA_MESSAGE3";
    public static final String paymentDetails = "com.example.android.cioscarr.EXTRA_MESSAGE4";
    public static final String paydate = "com.example.android.cioscarr.EXTRA_MESSAGE5";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Payment Details");
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_payment, null, false);
        drawer.addView(contentView, 0);

        card_number = findViewById(R.id.txtCard_num);
        card_name = findViewById(R.id.txtName_on_card);
        card_expiry = findViewById(R.id.txtExpiry_date);
        card_cvv = findViewById(R.id.txtCvv);

        paymentVM = ViewModelProviders.of(this).get(PaymentViewModel.class);

        final DatePickerDialog.OnDateSetListener card_expiry_date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);

                updateLabel();
            }
        };

        card_expiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(payment.this, card_expiry_date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


    }

    private void updateLabel() {
        // String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        card_expiry.setText(sdf.format(myCalendar.getTime()));

    }


    public void booking_summary(View view) {
        Intent intent = new Intent(this, booking_summary.class);
        String carName = card_name.getText().toString();
        intent.putExtra(carName, carName);
        String cardCvv = card_cvv.getText().toString();
        intent.putExtra(cardcvv, cardCvv);
        String cardExpiry = card_expiry.getText().toString();
        intent.putExtra(cardExpiry, cardExpiry);
        String cardNumber = card_number.getText().toString();
        intent.putExtra(paymentDetails, cardNumber);
        String payDate = "12/21/2019";
        intent.putExtra(paydate, payDate);
        startActivity(intent);
    }


    public void booknowListener(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage("Are you sure want to book this car?")
                .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                    //String paymentID = "P0000" + String.valueOf(paymentVM.getAllPayment().getValue().size());
                    String paymentID = "P00001";
                    String cardExp = card_expiry.getText().toString();
                    String cardName = card_name.getText().toString();

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat();

                    String payDate = sdf.format(date);
                    String cardNum = card_number.getText().toString();
                    String cardCvv = card_cvv.getText().toString();
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        List<Payment_for_db> payment = paymentVM.getPayment();
                        if(cardNum != null && cardName != null && cardExp != null && cardCvv != null) {
                            Payment_for_db payment1 = new Payment_for_db(paymentID, "Master Card", payDate, cardNum, "Complete", "O00001");
                            paymentVM.insert(payment1);
                        }


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                })
                .show();

    }



}

