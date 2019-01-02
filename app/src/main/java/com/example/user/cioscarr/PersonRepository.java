package com.example.user.cioscarr;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.user.cioscarr.Person;
import com.example.user.cioscarr.PersonRoomDatabase;

import java.util.List;

public class PersonRepository  {

    private personInterface personDao;
    private LiveData<List<Person>> allPerson;

    PersonRepository(Application application) {
        PersonRoomDatabase db = PersonRoomDatabase.getDatabase(application);
        personDao = db.PersonDao();
        allPerson = personDao.getAllPerson();


    }
    LiveData<List<Person>> getAllPerson() {
        return allPerson;
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
