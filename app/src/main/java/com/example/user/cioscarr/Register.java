package com.example.user.cioscarr;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.cioscarr.entity.Person;
import com.example.user.cioscarr.entity.Supplier;

public class Register extends AppCompatActivity {
    private EditText  uid;
    private EditText  password;
    private EditText  name;
    private EditText  ic_num;
    private EditText  contact;
    private EditText  email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sign Up");
        setContentView(R.layout.activity_register);

        uid = findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPass) ;
        name = findViewById(R.id.txtName);
        ic_num = findViewById(R.id.txtIc);
        contact = findViewById(R.id.txtContact);
        email = findViewById(R.id.txtEmail);


    }

// private PersonViewModel pvm ;
    public void signUpListener(View view) {
        String id = uid.getText().toString();
        String pass = password.getText().toString();
        String name1 = name.getText().toString();
        String ic = ic_num.getText().toString();
        String contact1 = contact.getText().toString();
        String email1 = email.getText().toString();

        int count = 0 ;

//        for(Person p : ) {
//            for(Supplier s : ){
//            if(id.equals(p.getUid())){
//                Toast.makeText(this, "Username has been exists! ",
//                        Toast.LENGTH_LONG).show();
//                count = 1;
//            }else if(contact1.equals(s.getSupplier_contact()) || contact1.equals(p.getContact())) {
//                    Toast.makeText(this, "Contact Number has been exists ! ",
//                            Toast.LENGTH_LONG).show();
//                    count = 1;
//            }else if (email1.equals(p.getEmail())){
//                Toast.makeText(this, "Email has been exists ! ",
//                        Toast.LENGTH_LONG).show();
//                count = 1;
//            }
//            }
//        }

        if(count == 0) {
            // pvm = ViewModelProviders.of(this).get(PersonViewModel.class);
//        Person person = new Person(name1,id, pass,ic, contact1,email1 );
//        personViewModel.insert(person);
        }

    }
}
