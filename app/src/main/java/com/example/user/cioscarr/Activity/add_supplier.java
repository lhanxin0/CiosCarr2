package com.example.user.cioscarr.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.cioscarr.R;
import com.example.user.cioscarr.ViewModel.SupplierViewModel;
import com.example.user.cioscarr.entity.Supplier;

import java.util.List;

public class add_supplier extends AppCompatActivity {
    private EditText supplierName;
    private EditText supplierContact;
    private EditText supplierCom_name;
    private EditText supplierCom_add;
    private EditText supplierCom_contact;
    private EditText supplierArea;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supplier);

        setTitle("Add new supplier");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        supplierName=findViewById(R.id.txtSn);
        supplierContact=findViewById(R.id.txtSupContact);
        supplierCom_name=findViewById(R.id.txtComName);
        supplierCom_add=findViewById(R.id.txtComAdd);
        supplierCom_contact=findViewById(R.id.txtComContact);
        supplierArea=findViewById(R.id.txtSArea);



    }

    private void saveSupplier(){
        String sName=supplierName.getText().toString();
        String sContact=supplierContact.getText().toString();
        String sCom_name=supplierCom_name.getText().toString();
        String sCom_add=supplierCom_add.getText().toString();
        String sCom_contact=supplierCom_contact.getText().toString();
        String sArea=supplierArea.getText().toString();

        if(sName.trim().isEmpty()){
            this.supplierName.setError("Please insert Supplier Name");
            this.supplierName.requestFocus();
            return;
        }
        if(sContact.trim().isEmpty()){
            this.supplierContact.setError("Please insert Supplier Contact");
            this.supplierContact.requestFocus();
            return;
        }
        if(sCom_name.trim().isEmpty()){
            this.supplierCom_name.setError("Please insert Company name");
            this.supplierCom_name.requestFocus();
            return;
        }
        if(sCom_add.trim().isEmpty()){
            this.supplierCom_add.setError("Please insert Company address");
            this.supplierCom_add.requestFocus();
            return;
        }
        if(sCom_contact.trim().isEmpty()){
            this.supplierCom_contact.setError("Please insert Company contact");
            this.supplierCom_contact.requestFocus();
            return;
        }
        if(sArea.trim().isEmpty()){
            this.supplierArea.setError("Please insert Area");
            this.supplierArea.requestFocus();
            return;
        }


        SupplierViewModel svm = ViewModelProviders.of(this).get(SupplierViewModel.class);
        List<Supplier> sList = svm.getSupplier();

        if(!sList.isEmpty()){
            for(Supplier s:sList){
                if(sContact.equals(s.getSupplier_contact())){
                    this.supplierCom_name.setError("Duplicate phone num");
                    this.supplierCom_name.requestFocus();
                    return;
                }
            }
        }

        String sid="S0001";

        try {


            if (!sList.isEmpty()) {
                sid = sList.get(sList.size() - 1).getSupplier_ID();
                int idnum = Integer.parseInt(sid.substring(1)) + 1;
                sid = "S" + String.format("%04d", idnum);
            }
            Supplier supplier = new Supplier(sid, sName, sContact, sContact, sCom_name, sCom_add, sArea);
            svm.insert(supplier);
        }catch (Exception ex){
            Log.d("add_supplier",ex.toString());
        }

        Toast.makeText(this,"Added",Toast.LENGTH_LONG).show();

        Intent intent=new Intent(this,Supplier_list.class);
        startActivity(intent);
        finish();

    }

    public void registerNewSupplier(View view) {
        saveSupplier();
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(this,Supplier_list.class);
        startActivity(intent);
        finish();
        return true;
    }



}
