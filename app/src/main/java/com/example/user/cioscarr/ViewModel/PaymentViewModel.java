package com.example.user.cioscarr.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.user.cioscarr.Repository.PaymentRepository;
import com.example.user.cioscarr.entity.Payment_for_db;

import java.util.List;

public class PaymentViewModel extends AndroidViewModel {

    private PaymentRepository payRepository;
    private LiveData<List<Payment_for_db>> allPayment;

    public PaymentViewModel (Application application) {
        super(application);
        payRepository = new PaymentRepository(application);
        allPayment = payRepository.getAllPayment();
    }

    public LiveData<List<Payment_for_db>> getAllPayment() {
        return allPayment;
    }

    public void insert(Payment_for_db payment_for_db) {
        payRepository.insert(payment_for_db);
    }

}