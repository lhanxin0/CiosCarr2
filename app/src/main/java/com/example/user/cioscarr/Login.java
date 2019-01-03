package com.example.user.cioscarr;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.cioscarr.entity.Payment_for_db;
import com.example.user.cioscarr.entity.Supplier;


public class Login extends AppCompatActivity {

    private EditText txtId;
    private TextInputLayout txt ;
    private TextInputLayout txt1 ;
    private EditText txtPass;
    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login");
        setContentView(R.layout.activity_login);

        txtId = findViewById(R.id.txtUsername);
        txtPass = findViewById(R.id.txtPass);


    }
    public static final String Extra_Message1 = "com.example.user.cioscarr.Extra_Message1";
    public static final String Extra_Message = "com.example.user.cioscarr.Extra_Message1";

    private PaymentViewModel personViewModel;
    public void signIn(View view){
        String id = txtId.getText().toString();
        String pass = txtPass.getText().toString();

        //Sign in ( need link with db)

        if(id.equalsIgnoreCase("alpha")&&pass.equalsIgnoreCase("alpha")){
            Intent intent = new Intent(this,reservation.class);
            startActivity(intent);
        }else{

            Intent intent = new Intent(this,dbArchitecture.class);
                    personViewModel = ViewModelProviders.of(this).get(PaymentViewModel.class);
        Payment_for_db person = new Payment_for_db("P0001","Credit", "21/12/1111", "4848100049641080", "Paid", "O0001");
        personViewModel.insert(person);
            startActivity(intent);
        }


    }
    public void SignUp(View view) {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
}
