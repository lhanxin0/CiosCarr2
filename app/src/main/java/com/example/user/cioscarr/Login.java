package com.example.user.cioscarr;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.se.omapi.Session;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.List;


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

    private SupplierViewModel personViewModel;
    public void signIn(View view){
        String id = txtId.getText().toString();
        String pass = txtPass.getText().toString();

        //Sign in ( need link with db)

        if(id.equalsIgnoreCase("alpha")&&pass.equalsIgnoreCase("alpha")){
            Intent intent = new Intent(this,reservation.class);
            startActivity(intent);
        }else{

            Intent intent = new Intent(this,dbArchitecture.class);
                    personViewModel = ViewModelProviders.of(this).get(SupplierViewModel.class);
        Supplier person = new Supplier("S0001",
                "teikChun","01223131313",
                "213112313","gg");
        personViewModel.insert(person);
            startActivity(intent);
        }


    }
    public void SignUp(View view) {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
}
