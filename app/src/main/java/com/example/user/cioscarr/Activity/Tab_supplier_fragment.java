package com.example.user.cioscarr.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.cioscarr.R;
import com.example.user.cioscarr.ViewModel.CarViewModel;
import com.example.user.cioscarr.ViewModel.SupplierViewModel;
import com.example.user.cioscarr.entity.Car;
import com.example.user.cioscarr.entity.Supplier;

public class Tab_supplier_fragment extends Fragment {
    private CarViewModel cvm;
    private SupplierViewModel svm;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.tab_supplier_fragment, container, false);

        TextView tvdetails = contentView.findViewById(R.id.txtSupplierDetail);
        TextView tvlocation = contentView.findViewById(R.id.textView11);


        Intent intent = getActivity().getIntent();
        String carid = intent.getStringExtra("carid");
        String cid = intent.getStringExtra("custID");

        cvm = ViewModelProviders.of(this).get(CarViewModel.class);
        svm = ViewModelProviders.of(this).get(SupplierViewModel.class);
        Car c = cvm.getCarById(carid);
        Supplier s = svm.getSupplierById(c.getSupplier_id());

        tvdetails.setText("Company Name: "+s.getCompany_name()+"\nCompany Contact: "+s.getCompany_contact()+"\nSupplier Name: "+s.getSupplier_Name()+"\nSupplier Contact: "+s.getSupplier_contact()+"\n"+s.getArea());
        tvlocation.setText(s.getCompany_address());
        


        return contentView;
    }
}
