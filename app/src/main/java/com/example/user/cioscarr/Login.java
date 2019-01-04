package com.example.user.cioscarr;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.cioscarr.entity.Payment_for_db;
import com.example.user.cioscarr.entity.Person;
import com.example.user.cioscarr.entity.Supplier;

import java.util.ArrayList;
import java.util.List;


public class Login extends AppCompatActivity {

    private EditText txtId;
    private TextInputLayout txt ;
    private TextInputLayout txt1 ;
    private EditText txtPass;
    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";

    private PersonViewModel pvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login");
        setContentView(R.layout.activity_login);

        txtId = findViewById(R.id.txtUsername);
        txtPass = findViewById(R.id.txtPass);






     //   personViewModel = ViewModelProviders.of(this).get(PersonViewModel.class);


    }
    public static final String Extra_Message1 = "com.example.user.cioscarr.Extra_Message1";
    public static final String Extra_Message = "com.example.user.cioscarr.Extra_Message1";
    private List<Person> person;



    public void signIn(View view){
        String id = txtId.getText().toString();
        String pass = txtPass.getText().toString();




        //Sign in ( need link with db)


        if(id.equalsIgnoreCase("alpha")&&pass.equalsIgnoreCase("alpha")){
            Intent intent = new Intent(this,reservation.class);
            startActivity(intent);
        }else{
//final List<Person> b = new ArrayList<>();
//             pvm = ViewModelProviders.of(this).get(PersonViewModel.class);
//             pvm.getAllPerson().observe(this, new Observer<List<Person>>() {
//                 @Override
//                 public void onChanged(@Nullable List<Person> people) {
//                     for(Person p : people){
//
//                     }
//
//                 }
//             });
//            List<Person> a = pvm.getPerson();
      //      txtId.setText(b.toString());

//        Person person = new Person("hanxin","P0002", "langkawi","1231231313131", "123123131","1231313131" );
//        pvm.insert(person);

           // startActivity(intent);

        }
//    if(id.equals() && pass.equals())    {
//        Intent intent = new Intent(this,reservation.class);
//        intent.putExtra(Extra_Message,id);
//        startActivity(intent);
//    }

    }
    public void SignUp(View view) {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
}
