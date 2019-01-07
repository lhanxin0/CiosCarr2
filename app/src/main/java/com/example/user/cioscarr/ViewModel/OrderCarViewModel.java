package com.example.user.cioscarr.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.user.cioscarr.Repository.OrderCarRepository;
import com.example.user.cioscarr.entity.Bh;
import com.example.user.cioscarr.entity.Order_car;

import java.util.List;

public class OrderCarViewModel extends AndroidViewModel {

    private OrderCarRepository ocRepository;
    private LiveData<List<Order_car>> allOrderCar;

    public OrderCarViewModel (Application application) {
        super(application);
        ocRepository = new OrderCarRepository(application);
        allOrderCar = ocRepository.getAllOrder_car();
    }

    public LiveData<List<Order_car>> getAllOrder_car() {
        return allOrderCar;
    }

    public LiveData<List<Bh>> getBh(String pid)
    {
        return ocRepository.getBh(pid);
    }

    public void insert(Order_car order_car) {
        ocRepository.insert(order_car);
    }

}