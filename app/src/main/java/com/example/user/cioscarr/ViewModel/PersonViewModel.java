package com.example.user.cioscarr.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.user.cioscarr.Repository.PersonRepository;
import com.example.user.cioscarr.entity.Person;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {

    private PersonRepository pRepository;
    private LiveData<List<Person>> allPerson;
    private List<Person> getPerson;

    public PersonViewModel(Application application) {
        super(application);
        pRepository = new PersonRepository(application);
        allPerson = pRepository.getAllPerson();
        getPerson = pRepository.getPerson();

    }

    public Person getPersonById(String id){
        return pRepository.getPersonById(id);
    }

    public LiveData<List<Person>> getAllPerson() {
        return allPerson;
    }
    public List<Person> getPerson() {
        return getPerson;
    }

    public void insert(Person uid) {
        pRepository.insert(uid);
    }

}
