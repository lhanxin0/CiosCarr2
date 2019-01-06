package com.example.user.cioscarr.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.cioscarr.entity.Person;

import java.util.List;

@Dao
public interface personDAO {
    @Insert
    void insert(Person person);

    @Query("DELETE FROM Person")
    void deleteAll();

    @Query("SELECT * from person ")
    LiveData<List<Person>> getAllPerson();

    @Query("SELECT * from person ")
    List<Person> getPerson();

    @Query("SELECT * from person where uid=:id ")
    Person getPersonbyID(String id);
}
