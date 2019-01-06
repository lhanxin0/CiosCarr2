package com.example.user.cioscarr.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.user.cioscarr.Adapter.carAdapter_withoutSelect;
import com.example.user.cioscarr.R;
import com.example.user.cioscarr.ViewModel.CarViewModel;
import com.example.user.cioscarr.entity.Car;

import java.util.List;

public class Car_list extends AppCompatActivity {

    private CarViewModel cvm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");

        setTitle("Supplier List");
        setContentView(R.layout.activity_choose_car);

        RecyclerView rv=findViewById(R.id.recyclerView1);
        final carAdapter_withoutSelect adapter=new carAdapter_withoutSelect(this);
        rv.setAdapter(adapter);
//        rv.setLayoutManager(new LinearLayoutManager(this));
        Intent intent=getIntent();
        String sid=intent.getStringExtra("supplierID");

        cvm=ViewModelProviders.of(this).get(CarViewModel.class);

        cvm.getAllCarBySid(sid).observe(this, new Observer<List<Car>>() {
            @Override
            public void onChanged(@Nullable List<Car> cars) {
                adapter.setCaws(cars);
            }
        });
    }
}
