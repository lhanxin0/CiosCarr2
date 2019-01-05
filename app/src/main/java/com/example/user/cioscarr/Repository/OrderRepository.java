package com.example.user.cioscarr.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.user.cioscarr.DAO.orderDAO;
import com.example.user.cioscarr.PersonRoomDatabase;
import com.example.user.cioscarr.entity.Order;

import java.util.List;

public class OrderRepository {
    private com.example.user.cioscarr.DAO.orderDAO orderDAO;
    private LiveData<List<Order>> allOrder;

    public OrderRepository(Application application) {
        PersonRoomDatabase db = PersonRoomDatabase.getDatabase(application);
        orderDAO = db.orderDAO();
        allOrder = orderDAO.getAllOrder();


    }
    public LiveData<List<Order>> getAllOrder() {
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
