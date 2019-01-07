package com.example.user.cioscarr.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.cioscarr.R;
import com.example.user.cioscarr.ViewModel.CarViewModel;
import com.example.user.cioscarr.entity.Car;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class add_car extends AppCompatActivity{
    final Calendar myCalendar = Calendar.getInstance();
    private EditText carType;
    private EditText carName;
    private EditText carColor;
    private EditText carDesc;
    private TextView carDate;
    private EditText carPrice;
    private ImageButton imgBtn;

    private String sid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Car");
        setContentView(R.layout.add_car);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imgBtn=findViewById(R.id.imageButton);
        carType=findViewById(R.id.txt_add_ct);
        carName=findViewById(R.id.txt_add_cn);
        carColor=findViewById(R.id.txt_add_cc);
        carDesc=findViewById(R.id.txt_add_cd);
        carDate=findViewById(R.id.txtAdd_car_date);
        carPrice=findViewById(R.id.txtAdd_car_price);



        final DatePickerDialog.OnDateSetListener take_date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();

            }

        };

        carDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(add_car.this, take_date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

    }






    private void updateLabel() {
        // String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        carDate.setText(sdf.format(myCalendar.getTime()));

    }
    private void saveCar(){
        String carType=this.carType.getText().toString();
        String carName=this.carName.getText().toString();
        String carColor=this.carColor.getText().toString();
        String carDesc=this.carDesc.getText().toString();
        String carDate=this.carDate.getText().toString();
        String carPrice=this.carPrice.getText().toString();

        if(carType.trim().isEmpty()){
            this.carType.setError("Please insert Car Type");
            this.carType.requestFocus();
            return;
        }
        if(carName.trim().isEmpty()){
            this.carName.setError("Please insert Car Name");
            this.carName.requestFocus();
            return;
        }
        if(carColor.trim().isEmpty()){
            this.carColor.setError("Please insert Car Color");
            this.carColor.requestFocus();
            return;
        }
        if(carDesc.trim().isEmpty()){
            this.carDesc.setError("Please insert Car Type");
            this.carDesc.requestFocus();
            return;
        }
        if(carDate.trim().isEmpty()){
            this.carDate.setError("Please insert Car Date");
            this.carDate.requestFocus();
            return;
        }
        if(carPrice.trim().isEmpty()){
            this.carPrice.setError("Please insert Car Price");
            this.carPrice.requestFocus();
            return;
        }
        if(bitmap==null){
            Toast.makeText( this,"Please Upload image", Toast.LENGTH_SHORT).show();
            return;
        }





        String cid="C0001";
        Intent intent=getIntent();
        String sid=intent.getStringExtra("supplierID");

        try {

            CarViewModel cvm = ViewModelProviders.of(this).get(CarViewModel.class);
            List<Car> cList = cvm.getCar();
            if (!cList.isEmpty()) {
                cid = cList.get(cList.size() - 1).getCar_id();
                int idnum = Integer.parseInt(cid.substring(1)) + 1;
                cid = "S" + String.format("%04d", idnum);
            }
            Double cp=Double.parseDouble(carPrice);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
            byte[] byteArray = stream.toByteArray();
            bitmap.recycle();
            Car car=null;
            car = new Car(cid, carType, carDate, carName, carColor, carDesc, cp, "Available", sid, byteArray);
            cvm.insert(car);
            Toast.makeText(this,"Added",Toast.LENGTH_LONG).show();
        }catch (Exception ex){
            Log.d("add_supplier",ex.toString());
        }



        intent=new Intent(this,Car_list.class);
        intent.putExtra("SID",sid);
        startActivity(intent);
        finish();

    }

    public void registerNewCar(View view) {saveCar();
    }

    public void uploadCarListener(View view) {
        Intent picIntent = new Intent();
        picIntent.setType("image/*");
        picIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(picIntent,"Select Picture"),1);
    }

    private Bitmap bitmap;

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {

                case 1:
                    if (resultCode == Activity.RESULT_OK) {
                        //data gives you the image uri. Try to convert that to bitmap
                        Uri ab = data.getData();
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), ab);
                        imgBtn.setImageBitmap(bitmap);
                        break;
                    } else if (resultCode == Activity.RESULT_CANCELED) {
                        Log.e("a", "Selecting picture cancelled");
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e("a", "Exception in onActivityResult : " + e.getMessage());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent=getIntent();
        String sid=intent.getStringExtra("supplierID");
        intent = new Intent(this,Car_list.class);
        intent.putExtra("SID",sid);
        startActivity(intent);
        finish();
        return true;
    }



}
