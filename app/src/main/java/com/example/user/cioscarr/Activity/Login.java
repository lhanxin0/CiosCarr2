package com.example.user.cioscarr.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.user.cioscarr.R;
import com.example.user.cioscarr.ViewModel.CarViewModel;
import com.example.user.cioscarr.ViewModel.PersonViewModel;
import com.example.user.cioscarr.ViewModel.SupplierViewModel;
import com.example.user.cioscarr.entity.Person;

import java.util.List;


public class Login extends AppCompatActivity {

    private EditText txtId;
    private TextInputLayout txt;
    private TextInputLayout txt1;
    private EditText txtPass;
    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";

    private PersonViewModel pvm;
    private SupplierViewModel svm;
    private CarViewModel cvm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login");
        setContentView(R.layout.activity_login);

        txtId = findViewById(R.id.txtUsername);
        txtPass = findViewById(R.id.txtPass);

        pvm = ViewModelProviders.of(this).get(PersonViewModel.class);
        svm = ViewModelProviders.of(this).get(SupplierViewModel.class);
        cvm = ViewModelProviders.of(this).get(CarViewModel.class);


        //   personViewModel = ViewModelProviders.of(this).get(PersonViewModel.class);


    }

    public static final String Extra_Message1 = "com.example.user.cioscarr.Extra_Message1";
    public static final String Extra_Message = "com.example.user.cioscarr.Extra_Message1";
    private List<Person> person;


    public void signIn(View view) {
        String id = txtId.getText().toString();
        String pass = txtPass.getText().toString();

        //Sign in ( need link with db)

        person = pvm.getPerson();
        if (id.equalsIgnoreCase("alpha") && pass.equalsIgnoreCase("alpha")) {
            Intent intent = new Intent(this, Booking_detail.class);
            startActivity(intent);
        } else {
            for (Person p : person) {
                if (id.equals(p.getUid()) && pass.equals(p.getPassword())) {
                    Intent intent = new Intent(this, reservation.class);
                    intent.putExtra(Extra_Message, id);
                    startActivity(intent);
                }else{
//                    Toast.makeText(this, "Invalid Username or password! ",
//                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, Choose_car.class);
                    startActivity(intent);
                }

            }

        }


    }

    public void SignUp(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}
//final List<Person> b = new ArrayList<>();

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
