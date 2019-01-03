package com.example.user.cioscarr;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.user.cioscarr.DAO.order_carDAO;
import com.example.user.cioscarr.entity.Order_car;

import java.util.List;

public class OrderCarRepository {
    private com.example.user.cioscarr.DAO.order_carDAO order_carDAO;
    private LiveData<List<Order_car>> allOrderCar;

    OrderCarRepository(Application application) {
        PersonRoomDatabase db = PersonRoomDatabase.getDatabase(application);
        order_carDAO = db.order_carDAO();
        allOrderCar = order_carDAO.getAllOrder_car();


    }
    LiveData<List<Order_car>> getAllOrder_car() {
        return allOrderCar;
    }
    public void insert (Order_car orderCar) {
        new OrderCarRepository.insertAsyncTask(order_carDAO).execute(orderCar);
    }

    private static class insertAsyncTask extends AsyncTask<Order_car, Void, Void> {

        private order_carDAO mAsyncTaskDao;

        insertAsyncTask(order_carDAO order_carDAO) {
            mAsyncTaskDao = order_carDAO;
        }

        @Override
        protected Void doInBackground(final Order_car... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
