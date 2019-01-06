package com.example.user.cioscarr.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.cioscarr.Activity.Booking_detail;
import com.example.user.cioscarr.R;
import com.example.user.cioscarr.entity.Car;

import java.util.List;

public class carAdapter extends RecyclerView.Adapter<carAdapter.WordViewHolder> {

    private final LayoutInflater pInflater;
    private List<Car> allcars;
    private String type;
    private String area;
    private String custId;
    private String takedate;
    private String returndate;
    private int selectedPos = RecyclerView.NO_POSITION;


    public carAdapter(Context context)
    {
        pInflater = LayoutInflater.from(context);
    }
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = pInflater.inflate(R.layout.recycler_view_car, parent, false);

        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {

        if (allcars != null) {

            Car current = allcars.get(position);
            holder.wordItemView.setText(current.getCar_name());
            holder.wordItemView2.setText(current. getCar_desc());
            holder.wordItemView3.setText(String.format("RM %.2f",current.getCar_price()));
            holder.itemView.setSelected(selectedPos == position);
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
            holder.wordItemView2.setText("No Word");
        }
    }
    public void setWords(List<Car> cars){

        allcars = cars;
//        cars = allcars;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (allcars != null)
        {
            return allcars.size();
        }
        else
            return 0;
    }

    public void setCustID(String custid, String taked, String returnd)
    {
        custId = custid;
        takedate = taked;
        returndate = returnd;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView wordItemView;
        private final TextView wordItemView2;
        private final TextView wordItemView3;



        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.txtCarName);
            wordItemView2 = itemView.findViewById(R.id.txtCarDetail);
            wordItemView3 = itemView.findViewById(R.id.txtPrice);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            // Below line is just like a safety check, because sometimes holder could be null,
            // in that case, getAdapterPosition() will return RecyclerView.NO_POSITION
            if (getAdapterPosition() == RecyclerView.NO_POSITION) return;

            // Updating old as well as new positions
            notifyItemChanged(selectedPos);
            selectedPos = getAdapterPosition();
            notifyItemChanged(selectedPos);

            // Do your another stuff for your onClick
            Car current = allcars.get(selectedPos);

            Intent intent=new Intent(v.getContext(), Booking_detail.class);


            intent.putExtra("selectedName", current.getCar_name());
            intent.putExtra("carid", current.getCar_id());
            intent.putExtra("selectedPrice",String.format("%.2f",current.getCar_price()));
            intent.putExtra("custID", custId);
            intent.putExtra("takedate", takedate);
            intent.putExtra("returndate", returndate);

            v.getContext().startActivity(intent);
        }
    }

}