package com.example.user.cioscarr.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.cioscarr.Adapter.SupplierAdapter;
import com.example.user.cioscarr.R;
import com.example.user.cioscarr.ViewModel.SupplierViewModel;
import com.example.user.cioscarr.entity.Supplier;

import java.util.List;

public class Supplier_list extends AppCompatActivity {
    private SupplierViewModel svm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Supplier List");
        setContentView(R.layout.activity_supplier_list);

        RecyclerView rv=findViewById(R.id.recyclerView_supplier);
        final SupplierAdapter adapter=new SupplierAdapter(this);
        rv.setAdapter(adapter);
//        rv.setLayoutManager(new LinearLayoutManager(this));

        svm=ViewModelProviders.of(this).get(SupplierViewModel.class);

        svm.getAllSupplier().observe(this, new Observer<List<Supplier>>() {
            @Override
            public void onChanged(@Nullable List<Supplier> suppliers) {
                adapter.setSupplierList(suppliers);
            }
        });


    }
}
