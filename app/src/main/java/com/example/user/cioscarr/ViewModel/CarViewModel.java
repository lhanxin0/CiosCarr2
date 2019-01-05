package com.example.user.cioscarr.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.user.cioscarr.Repository.CarRepository;
import com.example.user.cioscarr.entity.Car;

import java.util.List;

public class CarViewModel extends AndroidViewModel {

    private CarRepository cRepository;
    private LiveData<List<Car>> allCar;
    private List<String> allCarType;

    public CarViewModel (Application application) {
        super(application);
        cRepository = new CarRepository(application);
        allCar = cRepository.getAllCar();
        allCarType = cRepository.getAllCarType();
    }

    public LiveData<List<Car>> getAllCar() {
        return allCar;
    }
    public List<String> getAllCarType() {
        return allCarType;
    }

    public void insert(Car car) {
        cRepository.insert(car);
    }

}