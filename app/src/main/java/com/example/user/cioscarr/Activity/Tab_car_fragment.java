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
import com.example.user.cioscarr.entity.Car;

public class Tab_car_fragment extends Fragment {

    private CarViewModel cvm;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView=inflater.inflate(R.layout.tab_car_fragment,container,false);

//        TextView tvCName = contentView.findViewById(R.id.txtCarName_frag);
//        TextView tvPrice = contentView.findViewById(R.id.txtPrice_frag);
        TextView tvname = contentView.findViewById(R.id.txtCarName_frag);
        TextView txtprice = contentView.findViewById(R.id.txtPrice_frag);
        TextView txtcolor = contentView.findViewById(R.id.textView4);
        TextView txtdesc = contentView.findViewById(R.id.txtCarDescription);

//        Intent intent = getActivity().getIntent();
//        String carName = intent.getStringExtra("selectedName");
//        String carPrice = intent.getStringExtra("selectedPrice");
//        tvCName.setText(carName);
//        tvPrice.setText(carPrice);
        Intent intent = getActivity().getIntent();
        String carname = intent.getStringExtra("selectedName");
        String carprice = intent.getStringExtra("selectedPrice");
        String custID = intent.getStringExtra("custID");
        String carid = intent.getStringExtra("carid");

        cvm = ViewModelProviders.of(this).get(CarViewModel.class);
        Car c = cvm.getCarById(carid);

        tvname.setText(carname);
        txtprice.setText(carprice);
        txtcolor.setText(c.getCar_color());
        txtdesc.setText(c.getCar_desc());

        return contentView;
    }
}
