package com.example.user.cioscarr.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.cioscarr.Activity.Car_list;
import com.example.user.cioscarr.R;
import com.example.user.cioscarr.entity.Supplier;

import java.util.List;

public class SupplierAdapter extends RecyclerView.Adapter<SupplierAdapter.SupplierViewHolder> {
    private final LayoutInflater sInflater;
    private List<Supplier> supplierList;
    private int selectedPos=RecyclerView.NO_POSITION;

    public SupplierAdapter(Context context) {
        sInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public SupplierAdapter.SupplierViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = sInflater.inflate(R.layout.recyclerview_supplier, viewGroup, false);
        return new SupplierViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SupplierAdapter.SupplierViewHolder supplierViewHolder, int i) {
        if(supplierList!=null){
            Supplier current=supplierList.get(i);
            supplierViewHolder.supplierCom_name.setText(current.getCompany_name());
            supplierViewHolder.supplierCom_contact.setText(current.getCompany_contact());
            supplierViewHolder.supplierCom_add.setText(current.getCompany_address());
            supplierViewHolder.supplierName.setText(current.getSupplier_Name());
            supplierViewHolder.supplierContact.setText(current.getSupplier_contact());
            supplierViewHolder.itemView.setSelected(selectedPos==i);
        }
        else{
            supplierViewHolder.supplierCom_name.setText("No data");
            supplierViewHolder.supplierCom_contact.setText("No data");
            supplierViewHolder.supplierCom_add.setText("No data");
            supplierViewHolder.supplierName.setText("No data");
            supplierViewHolder.supplierContact.setText("No data");
        }

    }

    public void setSupplierList(List<Supplier> supplierList) {
        this.supplierList = supplierList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(supplierList!=null){
            return supplierList.size();
        }
        return 0;
    }

    public class SupplierViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView supplierCom_name;
        private final TextView supplierCom_contact;
        private final TextView supplierCom_add;
        private final TextView supplierName;
        private final TextView supplierContact;

        public SupplierViewHolder(@NonNull View itemView) {
            super(itemView);
            supplierCom_name=itemView.findViewById(R.id.txtSupplierCom_name);
            supplierCom_contact=itemView.findViewById(R.id.txtSupplierCom_contact);
            supplierCom_add=itemView.findViewById(R.id.txtSupplierCom_add);
            supplierName=itemView.findViewById(R.id.txtSupplierName);
            supplierContact=itemView.findViewById(R.id.txtSupplierContact);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(getAdapterPosition()==RecyclerView.NO_POSITION) return;

            notifyItemChanged(selectedPos);
            selectedPos=getAdapterPosition();
            notifyItemChanged(selectedPos);

            Supplier supplier=supplierList.get(selectedPos);
            Intent intent=new Intent(view.getContext(),Car_list.class);
            intent.putExtra("supplierID",supplier.getSupplier_ID());
            view.getContext().startActivity(intent);
        }
    }
}
