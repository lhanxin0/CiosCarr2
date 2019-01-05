package com.example.user.cioscarr.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.cioscarr.R;
import com.example.user.cioscarr.entity.Car;

import java.util.List;

public class carAdapter extends RecyclerView.Adapter<carAdapter.WordViewHolder> {

    private final LayoutInflater pInflater;
    private List<Car> allcars;


    public carAdapter(Context context)
    {
        pInflater = LayoutInflater.from(context);
    }
    @Override
    public carAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = pInflater.inflate(R.layout.recycler_view_car, parent, false);
        return new carAdapter.WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(carAdapter.WordViewHolder holder, int position) {
        if (allcars != null) {
            Car current = allcars.get(position);
            holder.wordItemView.setText(current.getCar_name());
            holder.wordItemView2.setText(current. getCar_desc());
            holder.wordItemView3.setText(String.format("RM %.2f",current.getCar_price()));

        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
            holder.wordItemView2.setText("No Word");
        }
    }
    public void setWords(List<Car> cars){
        allcars = cars;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (allcars != null)
            return allcars.size();
        else return 0;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        private final TextView wordItemView2;
        private final TextView wordItemView3;



        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.txtCar_name);
            wordItemView2 = itemView.findViewById(R.id.txtCarDetail);
            wordItemView3 = itemView.findViewById(R.id.txtPrice);


        }
    }

}