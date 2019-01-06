package com.example.user.cioscarr.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.user.cioscarr.Adapter.carAdapter;
import com.example.user.cioscarr.R;
import com.example.user.cioscarr.ViewModel.CarViewModel;
import com.example.user.cioscarr.entity.Car;

import java.util.List;

public class Choose_car extends main_navDrawer {
    private CarViewModel cvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Choose Car");
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_choose_car, null, false);
        drawer.addView(contentView, 0);


//        cvm = ViewModelProviders.of(this).get(CarViewModel.class);""

//        List<String> aa = cvm.getAllCarType();
//
        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        final carAdapter adapter1 = new carAdapter(this);
        Intent custintent = getIntent();
        adapter1.setCustID(custintent.getStringExtra("custID"), custintent.getStringExtra("takedate"), custintent.getStringExtra("returndate"));
        recyclerView.setAdapter(adapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cvm = ViewModelProviders.of(this).get(CarViewModel.class);
        Intent intent = getIntent();
        String cartype=intent.getStringExtra("carType");
        String cararea=intent.getStringExtra("carArea");
        String custID=intent.getStringExtra("custID");



        cvm.getAllCarTypeArea(cartype, cararea).observe(this, new Observer<List<Car>>() {
            @Override
            public void onChanged(@Nullable final List<Car> cars) {
                // Update the cached copy of the words in the adapter.
                //adapter.setID("P0002");
               adapter1.setWords(cars);
            }
        });



    }
}
