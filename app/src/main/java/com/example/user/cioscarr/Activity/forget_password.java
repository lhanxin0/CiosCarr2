package com.example.user.cioscarr.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.cioscarr.R;

public class forget_password extends AppCompatActivity {
    private TextView id;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        id = findViewById(R.id.txtFpwID);
        email = findViewById(R.id.txtFpwEmail);
    }

    public void submit(View view) {
    }
}
