package com.example.user.cioscarr;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Supplier")
public class Supplier {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "supplier_id")
    private String supplier_ID;

    @ColumnInfo(name = "supplier_name")
    private String supplier_Name;

    @ColumnInfo(name = "supplier_contact")
    private String supplier_contact;

    @ColumnInfo(name = "company_contact")
    private String company_contact;

    @ColumnInfo(name = "company_name")
    private String company_name;

    public Supplier(String supplier_ID, String supplier_Name, String supplier_contact, String company_contact, String company_name) {
        this.supplier_ID = supplier_ID;
        this.supplier_Name = supplier_Name;
        this.supplier_contact = supplier_contact;
        this.company_contact = company_contact;
        this.company_name = company_name;
    }

    public String getSupplier_ID() {
        return supplier_ID;
    }

    public String getSupplier_Name() {
        return supplier_Name;
    }

    public String getSupplier_contact() {
        return supplier_contact;
    }

    public String getCompany_contact() {
        return company_contact;
    }

    public String getCompany_name() {
        return company_name;
    }
}
