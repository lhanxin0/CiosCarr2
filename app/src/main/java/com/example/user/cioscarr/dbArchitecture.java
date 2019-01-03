package com.example.user.cioscarr;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.cioscarr.entity.Payment_for_db;
import com.example.user.cioscarr.entity.Supplier;

import java.util.List;

public class dbArchitecture extends AppCompatActivity {
    private SupplierViewModel supplierViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_architecture);


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final PersonAdapter adapter = new PersonAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        supplierViewModel = ViewModelProviders.of(this).get(SupplierViewModel.class);

        supplierViewModel.getAllSupplier().observe(this, new Observer<List<Supplier>>() {
            @Override
            public void onChanged(@Nullable final List<Supplier> suppliers) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(suppliers);
            }
        });





    }
  /*  public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Person person = new Person(data.getStringExtra(Login.Extra_Message),data.getStringExtra(Login.Extra_Message1));
            personViewModel.insert(person);
        } else {
            Toast.makeText(this, "aa", Toast.LENGTH_SHORT).show();
        }
    }*/
}
