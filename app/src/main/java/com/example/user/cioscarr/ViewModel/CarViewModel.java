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
    private LiveData<List<Car>> allCarTypeArea;
    private LiveData<List<Car>> allCarBySid;
    private List<Car> car;

    public CarViewModel (Application application) {
        super(application);
        cRepository = new CarRepository(application);
        allCar = cRepository.getAllCar();
        allCarType = cRepository.getAllCarType();
        car=cRepository.getCar();
    }

    public LiveData<List<Car>> getAllCar() {
        return allCar;
    }

    public List<Car> getCar() {
        return car;
    }

    public LiveData<List<Car>> getAllCarTypeArea(String ctype, String carea)
    {
        return cRepository.getAllCarTypeArea(ctype,carea);
    }

    public LiveData<List<Car>> getAllCarBySid(String sid) {
        return cRepository.getAllCarBySid(sid);
    }

    public List<String> getAllCarType() {
        return allCarType;
    }

    public Car getCarById(String carid)
    {
        return cRepository.getCarById(carid);
    }

    public void insert(Car car) {
        cRepository.insert(car);
    }

}