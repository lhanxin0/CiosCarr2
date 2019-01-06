package com.example.user.cioscarr.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.cioscarr.R;
import com.example.user.cioscarr.entity.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.WordViewHolder> {

    private final LayoutInflater pInflater;
    private List<Person> allPerson;
    private String id;
   public PersonAdapter(Context context)
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
        if (allPerson != null) {
            //Person current = allPerson.get(position);
            for(Person pp: allPerson) {
                if(pp.getUid().equals(id)) {
                    holder.wordItemView.setText(pp.getName());
                    holder.wordItemView2.setText(pp.getIc_num());
                    holder.wordItemView3.setText(pp.getContact());
                    holder.wordItemView4.setText(pp.getEmail());
                }
            }
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
            holder.wordItemView2.setText("No Word");
        }
    }
    public void setWords(List<Person> persons){
        allPerson = persons;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (allPerson != null)
            return 1;
         else return 0;
    }
    public void setID(String id){
       this.id = id;
    }
    public class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        private final TextView wordItemView2;
        private final TextView wordItemView3;
        private final TextView wordItemView4;


        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.txtUser_name);
            wordItemView2 = itemView.findViewById(R.id.txtUser_ic);
            wordItemView3 = itemView.findViewById(R.id.txtUser_contact);
            wordItemView4 = itemView.findViewById(R.id.txtUser_email);


        }
    }

}
