package com.example.user.cioscarr;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface supplierDAO {

    @Insert
    void insert(Supplier supplier);

    @Query("DELETE FROM Supplier")
    void deleteAll();

    @Query("SELECT * from Supplier ")
    LiveData<List<Supplier>> getAllSupplier();
}
