package com.example.user.cioscarr.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.cioscarr.entity.Payment_for_db;

import java.util.List;
@Dao
public interface PaymentDAO {
    @Insert
    void insert(Payment_for_db payment_for_db);

    @Query("DELETE FROM Paymeny_for_db")
    void deleteAll();

    @Query("SELECT * from Paymeny_for_db ")
    LiveData<List<Payment_for_db>> getAllPayment();
}
