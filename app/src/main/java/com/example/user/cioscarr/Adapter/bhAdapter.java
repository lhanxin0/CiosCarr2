package com.example.user.cioscarr.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.cioscarr.R;
import com.example.user.cioscarr.entity.Bh;

import java.util.List;

public class bhAdapter extends RecyclerView.Adapter<bhAdapter.WordViewHolder> {

    private final LayoutInflater pInflater;
    private List<Bh> allPerson;
    private String id;
    public bhAdapter(Context context)
    {
        pInflater = LayoutInflater.from(context);
    }
    @Override
    public bhAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = pInflater.inflate(R.layout.recycleview_item, parent, false);
        return new bhAdapter.WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(bhAdapter.WordViewHolder holder, int position) {
        if(!allPerson.isEmpty())
        {
            Bh bh = allPerson.get(position);
            holder.bhcarname.setText(bh.getCar_name());
            holder.bhname.setText(bh.getName());
            holder.bhplateno.setText(bh.getCar_plate_no());
            holder.bhreturnd.setText(bh.getReturn_date());
            holder.bhtaked.setText(bh.getStart_date());
            holder.bhprice.setText(String.format("RM %.2f", bh.getPrice()));
        }
}
    public void setWords(List<Bh> persons){
        allPerson = persons;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (allPerson != null)
            return allPerson.size();
        else return 0;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView bhname;
        private final TextView bhtaked;
        private final TextView bhreturnd;
        private final TextView bhcarname;
        private final TextView bhplateno;
        private final TextView bhprice;



        private WordViewHolder(View itemView) {
            super(itemView);
            bhname = itemView.findViewById(R.id.txtBooking_history_uid);
            bhtaked = itemView.findViewById(R.id.txt_booking_history_tDate);
            bhreturnd = itemView.findViewById(R.id.txt_booking_history_RDate);
            bhcarname = itemView.findViewById(R.id.txt_booking_history_CarName);
            bhplateno = itemView.findViewById(R.id.txt_booking_history_PlateNo);
            bhprice = itemView.findViewById(R.id.txt_booking_history_Price);


        }
    }

}