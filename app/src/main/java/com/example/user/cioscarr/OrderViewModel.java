package com.example.user.cioscarr;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.user.cioscarr.entity.Order;

import java.util.List;

public class OrderViewModel extends AndroidViewModel {

    private OrderRepository oRepository;
    private LiveData<List<Order>> allOrder;

    public OrderViewModel (Application application) {
        super(application);
        oRepository = new OrderRepository(application);
        allOrder = oRepository.getAllOrder();
    }

    LiveData<List<Order>> getAllOrder() {
        return allOrder;
    }

    public void insert(Order order) {
        oRepository.insert(order);
    }

}
