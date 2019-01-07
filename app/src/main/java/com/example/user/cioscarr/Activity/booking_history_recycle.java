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

import com.example.user.cioscarr.Adapter.bhAdapter;
import com.example.user.cioscarr.R;
import com.example.user.cioscarr.ViewModel.OrderCarViewModel;
import com.example.user.cioscarr.entity.Bh;

import java.util.List;

public class booking_history_recycle extends main_navDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_booking_history_recycle);
        setTitle("Booking History");
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_booking_history_recycle, null, false);
        drawer.addView(contentView, 0);


        Intent intent = getIntent();
       String id = intent.getStringExtra("customerID");

        RecyclerView rv = findViewById(R.id.rvbh);
        final bhAdapter adapter = new bhAdapter(this);
        rv.setAdapter(adapter);

        rv.setLayoutManager(new LinearLayoutManager(this));
        OrderCarViewModel ocvm = ViewModelProviders.of(this).get(OrderCarViewModel.class);

        ocvm.getBh(id).observe(this, new Observer<List<Bh>>() {
            @Override
            public void onChanged(@Nullable List<Bh> bhs) {
                adapter.setWords(bhs);;
            }
        });
    }
}
