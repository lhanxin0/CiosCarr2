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

    @Query("SELECT * from Car ")
    List<Car> getCar();

    @Query("SELECT car_type from Car ")
    List<String> getAllCarType();

    @Query("SELECT c.* from Car c , Supplier s WHERE car_type=:ctype AND c.supplier_id=s.supplier_ID AND s.area =:carea")
    LiveData<List<Car>> getAllCarByTypeArea(String ctype, String carea);

    @Query("SELECT * from Car WHERE car_id=:carid")
    Car getCarById(String carid);

    @Query("SELECT c.* from Car c , Supplier s WHERE c.supplier_id=s.supplier_ID AND s.supplier_ID=:sid")
    LiveData<List<Car>> getAllCarBySid(String sid);
}
