package com.example.user.cioscarr.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Supplier")
public class Supplier {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "supplier_ID")
    private String supplier_ID;

    @ColumnInfo(name = "supplier_name")
    private String supplier_Name;

    @ColumnInfo(name = "supplier_contact")
    private String supplier_contact;

    @ColumnInfo(name = "company_contact")
    private String company_contact;

    @ColumnInfo(name = "company_name")
    private String company_name;

    @ColumnInfo(name = "company_address")
    private String company_address;

    @ColumnInfo(name = "area")
    private String area;

    public Supplier(@NonNull String supplier_ID, String supplier_Name, String supplier_contact, String company_contact, String company_name, String company_address, String area) {
        this.supplier_ID = supplier_ID;
        this.supplier_Name = supplier_Name;
        this.supplier_contact = supplier_contact;
        this.company_contact = company_contact;
        this.company_name = company_name;
        this.company_address = company_address;
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public String getCompany_address() {
        return company_address;
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
