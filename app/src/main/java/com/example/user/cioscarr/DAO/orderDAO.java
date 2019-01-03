package com.example.user.cioscarr.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.cioscarr.entity.Order;

import java.util.List;
@Dao
public interface orderDAO {


    @Insert
    void insert(Order order);

    @Query("DELETE FROM `Order`")
    void deleteAll();

    @Query("SELECT * from `order` ")
    LiveData<List<Order>> getAllOrder();
}
