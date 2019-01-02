package com.example.user.cioscarr;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class CarRepository {
    private carDAO carDAO;
    private LiveData<List<Car>> allCar;

    CarRepository(Application application) {
        PersonRoomDatabase db = PersonRoomDatabase.getDatabase(application);
        carDAO = db.carDAO();
        allCar = carDAO.getAllCar();



    }
    LiveData<List<Car>> getAllCar() {
        return allCar;
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
