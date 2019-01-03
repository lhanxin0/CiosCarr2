package com.example.user.cioscarr.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.cioscarr.entity.Car;

import java.util.List;
@Dao
public interface carDAO {

    @Insert
    void insert(Car car);

    @Query("DELETE FROM Car")
    void deleteAll();

    @Query("SELECT * from Car ")
    LiveData<List<Car>> getAllCar();
}
