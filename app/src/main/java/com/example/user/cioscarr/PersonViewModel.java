package com.example.user.cioscarr;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.user.cioscarr.entity.Person;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {

    private PersonRepository pRepository;
    private LiveData<List<Person>> allPerson;

    public PersonViewModel (Application application) {
        super(application);
        pRepository = new PersonRepository(application);
        allPerson = pRepository.getAllPerson();
    }

    LiveData<List<Person>> getAllPerson() {
        return allPerson;
    }

    public void insert(Person uid) {
        pRepository.insert(uid);
    }

}
