package com.example.user.cioscarr.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.cioscarr.R;
import com.example.user.cioscarr.entity.Car;

import java.util.List;

public class carAdapter_withoutSelect extends RecyclerView.Adapter<carAdapter_withoutSelect.cawsViewHolder> {

    private final LayoutInflater cawsInflater;
    private List<Car> allcars;

    public carAdapter_withoutSelect(Context context) {
        cawsInflater = LayoutInflater.from(context);
    }

    public void setCaws(List<Car> cars){

        allcars = cars;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public carAdapter_withoutSelect.cawsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = cawsInflater.inflate(R.layout.recycler_view_car, viewGroup, false);

        return new cawsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull carAdapter_withoutSelect.cawsViewHolder cawsViewHolder, int i) {
        if (allcars != null) {

            Car current = allcars.get(i);
            cawsViewHolder.wordItemView.setText(current.getCar_name());
            cawsViewHolder.wordItemView2.setText("Car ID: "+current.getCar_id()+"\nDescription: "+current.getCar_desc() + "\nColor: " + current.getCar_color() +
                    "\nPlate No:" + current.getCar_plate_no() + "\nBrand: " + current.getCar_type() + "\nYear of Car: " + current.getCar_year());
            cawsViewHolder.wordItemView3.setText(String.format("RM %.2f",current.getCar_price()));
            if(current.getCarImg()!=null){
                Bitmap bitmap = BitmapFactory.decodeByteArray(current.getCarImg(), 0, current.getCarImg().length);
                cawsViewHolder.imgview.setImageBitmap(bitmap);
            }else{
                Resources resource = cawsViewHolder.itemView.getContext().getResources();
                Drawable drawable = resource.getDrawable(R.drawable.logo);
                cawsViewHolder.imgview.setImageDrawable(drawable);
            }
        } else {
            // Covers the case of data not being ready yet.
            cawsViewHolder.wordItemView.setText("No Word");
            cawsViewHolder.wordItemView2.setText("No Word");
        }

    }

    @Override
    public int getItemCount() {
        if (allcars != null)
        {
            return allcars.size();
        }
        return 0;
    }

    public class cawsViewHolder extends RecyclerView.ViewHolder{
        private final TextView wordItemView;
        private final TextView wordItemView2;
        private final TextView wordItemView3;
        private final ImageView imgview;



        private cawsViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.txtCarName);
            wordItemView2 = itemView.findViewById(R.id.txtCarDetail);
            wordItemView3 = itemView.findViewById(R.id.txtPrice);
            imgview = itemView.findViewById(R.id.imgCar);

        }
    }
}
