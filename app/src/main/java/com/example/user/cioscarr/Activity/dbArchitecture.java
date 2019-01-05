package com.example.user.cioscarr.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.cioscarr.Adapter.PersonAdapter;
import com.example.user.cioscarr.R;
import com.example.user.cioscarr.Repository.PersonRepository;
import com.example.user.cioscarr.ViewModel.PersonViewModel;
import com.example.user.cioscarr.entity.Person;

import java.util.List;

public class dbArchitecture extends AppCompatActivity {
    private PersonViewModel pvm;
    private PersonRepository pvr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_architecture);


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final PersonAdapter adapter = new PersonAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pvm = ViewModelProviders.of(this).get(PersonViewModel.class);

                pvm.getAllPerson().observe(this, new Observer<List<Person>>() {
                    @Override
                    public void onChanged(@Nullable final List<Person> person) {
                        // Update the cached copy of the words in the adapter.
                        //adapter.setID("P0002");
                        adapter.setWords(person);
            }
        });





    }
  /*  public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Person person = new Person(data.getStringExtra(Login.Extra_Message),data.getStringExtra(Login.Extra_Message1));
            personViewModel.insert(person);
        } else {
            Toast.makeText(this, "aa", Toast.LENGTH_SHORT).show();
        }
    }*/
}
