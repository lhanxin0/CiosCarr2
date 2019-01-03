package com.example.user.cioscarr;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.user.cioscarr.entity.Car;

import java.util.List;

public class CarViewModel extends AndroidViewModel {

    private CarRepository cRepository;
    private LiveData<List<Car>> allCar;

    public CarViewModel (Application application) {
        super(application);
        cRepository = new CarRepository(application);
        allCar = cRepository.getAllCar();
    }

    LiveData<List<Car>> getAllCar() {
        return allCar;
    }

    public void insert(Car car) {
        cRepository.insert(car);
    }

}