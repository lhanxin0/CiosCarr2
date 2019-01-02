package com.example.user.cioscarr;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.cioscarr.Person;

import java.util.List;

@Dao
public interface personInterface {
    @Insert
    void insert(Person person);

    @Query("DELETE FROM Person")
    void deleteAll();

    @Query("SELECT * from person ")
    LiveData<List<Person>> getAllPerson();
}
