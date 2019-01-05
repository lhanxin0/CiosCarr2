package com.example.user.cioscarr.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.user.cioscarr.DAO.personInterface;
import com.example.user.cioscarr.PersonRoomDatabase;
import com.example.user.cioscarr.entity.Person;

import java.util.List;

public class PersonRepository  {

    private personInterface personDao;
    private LiveData<List<Person>> allPerson;
    private List<Person>  person;



    public PersonRepository(Application application) {
        PersonRoomDatabase db = PersonRoomDatabase.getDatabase(application);
        personDao = db.PersonDao();
        allPerson = personDao.getAllPerson();
        person = personDao.getPerson();


    }


    public LiveData<List<Person>> getAllPerson() {
        return allPerson;
    }
    public List<Person> getPerson() {
        return person;
    }


    public void insert (Person uid) {
        new insertAsyncTask(personDao).execute(uid);
    }

    private static class insertAsyncTask extends AsyncTask<Person, Void, Void> {

        private personInterface mAsyncTaskDao;

        insertAsyncTask(personInterface dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Person... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
