package com.example.user.cioscarr;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.user.cioscarr.DAO.PaymentDAO;
import com.example.user.cioscarr.entity.Payment_for_db;

import java.util.List;

public class PaymentRepository {
    private PaymentDAO paymentDAO;
    private LiveData<List<Payment_for_db>> allPayment;

    PaymentRepository(Application application) {
        PersonRoomDatabase db = PersonRoomDatabase.getDatabase(application);
        paymentDAO = db.paymentDAO();
        allPayment = paymentDAO.getAllPayment();


    }
    LiveData<List<Payment_for_db>> getAllPayment() {
        return allPayment;
    }
    public void insert (Payment_for_db payment) {
        new PaymentRepository.insertAsyncTask(paymentDAO).execute(payment);
    }

    private static class insertAsyncTask extends AsyncTask<Payment_for_db, Void, Void> {

        private PaymentDAO mAsyncTaskDao;

        insertAsyncTask(PaymentDAO paymentDAO) {
            mAsyncTaskDao = paymentDAO;
        }

        @Override
        protected Void doInBackground(final Payment_for_db... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
