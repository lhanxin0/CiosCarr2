package com.example.user.cioscarr;

import android.content.Intent;
import android.se.omapi.Session;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


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
    public void signIn(View view){
        String id = txtId.getText().toString();
        String pass = txtPass.getText().toString();

        //Sign in ( need link with db)

        if(id.equalsIgnoreCase("alpha")&&pass.equalsIgnoreCase("alpha")){
            Intent intent = new Intent(this,reservation.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this,Register.class);
            startActivity(intent);
        }


    }
    public void SignUp(View view) {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
}
