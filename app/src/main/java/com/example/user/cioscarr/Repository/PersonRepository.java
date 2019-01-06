package com.example.user.cioscarr.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.user.cioscarr.DAO.personDAO;
import com.example.user.cioscarr.PersonRoomDatabase;
import com.example.user.cioscarr.entity.Person;

import java.util.List;

public class PersonRepository  {

    private personDAO personDao;
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

    public Person getPersonById(String id){
        return personDao.getPersonbyID(id);
    }

    public void update (Person updatePerson) {
        new updateAsycnTask(personDao).execute(updatePerson);
    }

    public void insert (Person uid) {
        new insertAsyncTask(personDao).execute(uid);
    }

    private static class insertAsyncTask extends AsyncTask<Person, Void, Void> {

        private personDAO mAsyncTaskDao;

        insertAsyncTask(personDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Person... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
    private static class updateAsycnTask extends AsyncTask<Person, Void, Void> {

        private personDAO pDao;

       public updateAsycnTask(personDAO dao) {
            pDao = dao;
        }

        @Override
        protected Void doInBackground(final Person... params) {
            pDao.update(params[0]);
            return null;
        }
    }
}
