package com.example.user.cioscarr.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.user.cioscarr.Repository.SupplierRepository;
import com.example.user.cioscarr.entity.Supplier;

import java.util.List;

public class SupplierViewModel extends AndroidViewModel {

    private SupplierRepository sRepository;
    private LiveData<List<Supplier>> allSupplier;
    private List<Supplier> Supplier;

    public SupplierViewModel (Application application) {
        super(application);
        sRepository = new SupplierRepository(application);
        allSupplier = sRepository.getAllSupplier();
        Supplier = sRepository.getSupplier();
    }

   public LiveData<List<Supplier>> getAllSupplier() {
        return allSupplier;
    }

    public Supplier getSupplierById(String sid)
    {
        return sRepository.getSupplierById(sid);
    }
   public List<Supplier> getSupplier() {
        return Supplier;
    }

    public void insert(Supplier supplier) {
        sRepository.insert(supplier);
    }

}
