package com.example.user.cioscarr;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.user.cioscarr.DAO.supplierDAO;
import com.example.user.cioscarr.entity.Supplier;

import java.util.List;

public class SupplierRepository {
    private com.example.user.cioscarr.DAO.supplierDAO supplierDAO;
    private LiveData<List<Supplier>> allSupplier;
    private LiveData<List<String>> allSupplierID;

    SupplierRepository(Application application) {
        PersonRoomDatabase db = PersonRoomDatabase.getDatabase(application);
        supplierDAO = db.supplierDAO();
        allSupplier = supplierDAO.getAllSupplier();
        allSupplierID = supplierDAO.getAllSupplierID();


    }
    LiveData<List<Supplier>> getAllSupplier() {
        return allSupplier;
    }
    LiveData<List<String>> getAllSupplierID() {
        return allSupplierID;
    }
    public void insert (Supplier supplier) {
        new SupplierRepository.insertAsyncTask(supplierDAO).execute(supplier);
    }

    private static class insertAsyncTask extends AsyncTask<Supplier, Void, Void> {

        private supplierDAO mAsyncTaskDao;

        insertAsyncTask(supplierDAO supplierDAO) {
            mAsyncTaskDao = supplierDAO;
        }

        @Override
        protected Void doInBackground(final Supplier... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
