package com.example.user.cioscarr.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@Entity(tableName = "Person")
public class Person {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uid")
    private String uid;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="ic_num")
    private String ic_num;

    @ColumnInfo(name="password")
   private String password;

    @ColumnInfo(name="contact")
    private String contact;

    @ColumnInfo(name="email")
    private String email;

    public Person(String name, String uid, String password, String ic_num, String contact, String email) {
        this.name = name;
        this.uid = uid;
        this.password = password;
        this.ic_num = ic_num;
        this.contact = contact;
        this.email = email;
    }
/*
    public Person(@NonNull String uid,@Nullable String name ,String ic_num) {
        this.uid = uid;
        this.name = name;
        this.ic_num = ic_num;
    }*/

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }

    public String getIc_num() {
        return ic_num;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }
}
