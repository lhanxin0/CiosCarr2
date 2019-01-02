package com.example.user.cioscarr;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class OrderRepository {
    private orderDAO orderDAO;
    private LiveData<List<Order>> allOrder;

    OrderRepository(Application application) {
        PersonRoomDatabase db = PersonRoomDatabase.getDatabase(application);
        orderDAO = db.orderDAO();
        allOrder = orderDAO.getAllOrder();


    }
    LiveData<List<Order>> getAllOrder() {
        return allOrder;
    }
    public void insert (Order order) {
        new OrderRepository.insertAsyncTask(orderDAO).execute(order);
    }

    private static class insertAsyncTask extends AsyncTask<Order, Void, Void> {

        private orderDAO mAsyncTaskDao;

        insertAsyncTask(orderDAO orderDAO) {
            mAsyncTaskDao = orderDAO;
        }

        @Override
        protected Void doInBackground(final Order... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
