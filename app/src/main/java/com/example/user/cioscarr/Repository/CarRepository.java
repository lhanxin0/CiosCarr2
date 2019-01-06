package com.example.user.cioscarr.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.user.cioscarr.DAO.carDAO;
import com.example.user.cioscarr.PersonRoomDatabase;
import com.example.user.cioscarr.entity.Car;

import java.util.List;

public class CarRepository {
    private com.example.user.cioscarr.DAO.carDAO carDAO;
    private LiveData<List<Car>> allCar;
    private List<String> allCarType;
    private LiveData<List<Car>> allCarTypeArea;
    private LiveData<List<Car>> allCarBySid;
    private List<Car> car;


   public CarRepository(Application application) {
        PersonRoomDatabase db = PersonRoomDatabase.getDatabase(application);
        carDAO = db.carDAO();
        allCar = carDAO.getAllCar();
        allCarType = carDAO.getAllCarType();
        car=carDAO.getCar();



    }
    public LiveData<List<Car>> getAllCar() {
        return allCar;
    }

    public List<Car> getCar() {
        return car;
    }

    public LiveData<List<Car>> getAllCarTypeArea(String ctype, String carea)
    {
        return carDAO.getAllCarByTypeArea(ctype, carea);
    }

    public LiveData<List<Car>> getAllCarBySid(String sid) {
        return carDAO.getAllCarBySid(sid);
    }

    public List<String> getAllCarType() {
        return allCarType;
    }
    public void insert (Car car) {
        new CarRepository.insertAsyncTask(carDAO).execute(car);
    }

    private static class insertAsyncTask extends AsyncTask<Car, Void, Void> {

        private carDAO mAsyncTaskDao;

        insertAsyncTask(carDAO carDAO) {
            mAsyncTaskDao = carDAO;
        }

        @Override
        protected Void doInBackground(final Car... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
