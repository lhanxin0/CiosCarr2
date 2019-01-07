package com.example.user.cioscarr.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.user.cioscarr.Adapter.carAdapter_withoutSelect;
import com.example.user.cioscarr.R;
import com.example.user.cioscarr.ViewModel.CarViewModel;
import com.example.user.cioscarr.entity.Car;

import java.util.List;

public class Car_list extends AppCompatActivity {

    private CarViewModel cvm;
    private String sid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");

        setTitle("Car List");
        setContentView(R.layout.car_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView rv=findViewById(R.id.recyclerView_car);
        final carAdapter_withoutSelect adapter=new carAdapter_withoutSelect(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Intent intent=getIntent();
        if(intent.getStringExtra("supplierID")!=null){
            sid=intent.getStringExtra("supplierID");
        }
        else{
            sid=intent.getStringExtra("SID");
        }

        cvm=ViewModelProviders.of(this).get(CarViewModel.class);

        cvm.getAllCarBySid(sid).observe(this, new Observer<List<Car>>() {
            @Override
            public void onChanged(@Nullable List<Car> cars) {
                adapter.setCaws(cars);
            }
        });
    }

    public void gotoAddcar(View view) {
        Intent intent=new Intent(this,add_car.class);
        intent.putExtra("supplierID",sid);
        startActivity(intent);

    }
    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(this,Supplier_list.class);
        startActivity(intent);
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.actionbar_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_logout){
            Intent intent = new Intent(this,Login.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
