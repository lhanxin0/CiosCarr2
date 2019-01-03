package com.example.user.cioscarr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.cioscarr.entity.Supplier;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.WordViewHolder> {

    private final LayoutInflater pInflater;
    private List<Supplier> allSuppliers;
    PersonAdapter(Context context)
    {
        pInflater = LayoutInflater.from(context);
    }
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = pInflater.inflate(R.layout.recycleview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (allSuppliers != null) {
            Supplier current = allSuppliers.get(position);
            holder.wordItemView.setText(current.getCompany_contact());
            holder.wordItemView2.setText(current. getSupplier_ID());
            holder.wordItemView3.setText(current.getSupplier_Name());

        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
            holder.wordItemView2.setText("No Word");
        }
    }
    void setWords(List<Supplier> suppliers){
        allSuppliers = suppliers;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (allSuppliers != null)
            return allSuppliers.size();
        else return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        private final TextView wordItemView2;
        private final TextView wordItemView3;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
            wordItemView2 = itemView.findViewById(R.id.textVie);
            wordItemView3 = itemView.findViewById(R.id.textVie1);
        }
    }

}
