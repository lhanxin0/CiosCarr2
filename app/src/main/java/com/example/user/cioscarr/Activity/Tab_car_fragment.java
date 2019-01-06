package com.example.user.cioscarr.Activity;

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

public class Tab_car_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView=inflater.inflate(R.layout.tab_car_fragment,container,false);

        TextView tvCName = contentView.findViewById(R.id.txtCarName_frag);
        TextView tvPrice = contentView.findViewById(R.id.txtPrice_frag);

        Intent intent = getActivity().getIntent();
        String carName = intent.getStringExtra("selectedName");
        String carPrice = intent.getStringExtra("selectedPrice");
        tvCName.setText(carName);
        tvPrice.setText(carPrice);

        return contentView;
    }
}
