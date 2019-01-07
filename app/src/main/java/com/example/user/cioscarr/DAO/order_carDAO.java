package com.example.user.cioscarr.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.cioscarr.entity.Bh;
import com.example.user.cioscarr.entity.Order_car;

import java.util.List;
@Dao
public interface order_carDAO {

    @Insert
    void insert(Order_car order_car);

    @Query("DELETE FROM Order_car")
    void deleteAll();

    @Query("SELECT * from Order_car ")
    LiveData<List<Order_car>> getAllOrder_car();

    @Query("SELECT name, car_plate_no, car_name, order_car_sDate, order_car_rDate, price from Person p, Car c, Order_car oc, `Order` o WHERE oc.car_id = c.car_id AND oc.order_id = o.order_id AND o.cust_id = p.uid AND p.uid =:pid")
    LiveData<List<Bh>> getBh(String pid);
}
