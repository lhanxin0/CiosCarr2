package com.example.user.cioscarr;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.user.cioscarr.entity.Supplier;

import java.util.List;

public class SupplierViewModel extends AndroidViewModel {

    private SupplierRepository sRepository;
    private LiveData<List<Supplier>> allSupplier;

    public SupplierViewModel (Application application) {
        super(application);
        sRepository = new SupplierRepository(application);
        allSupplier = sRepository.getAllSupplier();
    }

    LiveData<List<Supplier>> getAllSupplier() {
        return allSupplier;
    }

    public void insert(Supplier supplier) {
        sRepository.insert(supplier);
    }

}
