package com.example.user.cioscarr.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.cioscarr.Adapter.PersonAdapter;
import com.example.user.cioscarr.R;
import com.example.user.cioscarr.Repository.PersonRepository;
import com.example.user.cioscarr.ViewModel.PersonViewModel;
import com.example.user.cioscarr.entity.Person;

import java.util.List;

public class dbArchitecture extends main_navDrawer {
    private PersonViewModel pvm;
    private PersonRepository pvr;

    EditText txtCustName ;
    EditText txtCustContact;
    EditText txtCustEmail ;
    EditText txtCustIC ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_db_architecture);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_db_architecture, null, false);
        drawer.addView(contentView, 0);

        Intent intent = getIntent();
     final String id = intent.getStringExtra("customerID");


        pvm = ViewModelProviders.of(this).get(PersonViewModel.class);

         txtCustName = findViewById(R.id.txtUser_name);
         txtCustContact = findViewById(R.id.txtUser_contact);
         txtCustEmail = findViewById(R.id.txtUser_email);
         txtCustIC = findViewById(R.id.txtUser_ic);

        Person profile = pvm.getPersonById("HanXin");

        txtCustName.setText(profile.getName());
        txtCustContact.setText(profile.getContact());
        txtCustEmail.setText(profile.getEmail());
        txtCustIC.setText(profile.getIc_num());




    }

    public void uploadPicListener(View view) {

        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, 1);
    }
        protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();

                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                }
                break;
        }
    }
Button btnConfirm;
    public void editProfileListener(View view) {
        txtCustIC.setEnabled(true);
        txtCustName.setEnabled(true);
        txtCustContact.setEnabled(true);
        txtCustEmail.setEnabled(true);
        btnConfirm = findViewById(R.id.btnEditConfirm);
        btnConfirm.setVisibility(view.VISIBLE);
        btnConfirm.setClickable(true);

    }

    public void confirmEditListener(View view) {

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
