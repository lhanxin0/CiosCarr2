package com.example.user.cioscarr;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface order_carDAO {

    @Insert
    void insert(Order_car order_car);

    @Query("DELETE FROM Order_car")
    void deleteAll();

    @Query("SELECT * from Order_car ")
    LiveData<List<Order_car>> getAllOrder_car();
}