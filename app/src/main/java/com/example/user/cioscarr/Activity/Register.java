package com.example.user.cioscarr.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.cioscarr.R;
import com.example.user.cioscarr.ViewModel.PersonViewModel;
import com.example.user.cioscarr.ViewModel.SupplierViewModel;
import com.example.user.cioscarr.entity.Person;

import java.util.List;

public class Register extends AppCompatActivity {
    private EditText uid;
    private EditText password;
    private EditText name;
    private EditText ic_num;
    private EditText contact;
    private EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sign Up");
        setContentView(R.layout.activity_register);

        uid = findViewById(R.id.txt_add_ct);
        password = findViewById(R.id.txt_add_cn);
        name = findViewById(R.id.txt_add_cc);
        ic_num = findViewById(R.id.txt_add_cd);
        contact = findViewById(R.id.txtCompany_address);
        email = findViewById(R.id.txtEmail);

        pvm = ViewModelProviders.of(this).get(PersonViewModel.class);


    }

    private PersonViewModel pvm;
    private SupplierViewModel svm;

    public void signUpListener(View view) {
      String id = uid.getText().toString();
        String pass = password.getText().toString();
        String name1 = name.getText().toString();
        String ic = ic_num.getText().toString();
        String contact1 = contact.getText().toString();
        String email1 = email.getText().toString();
             List<Person> person = pvm.getPerson();
         // List<Supplier> supplier = svm.getSupplier();
         int count = 0 ;

//          uid.setText(person.get(0).getUid());
//        password.setText(id);
        for(Person p : person) {
          //  for(Supplier s :supplier ){
            if(id.equals(p.getUid())){
                Toast.makeText(this, "Username has been exists! ",
                        Toast.LENGTH_LONG).show();
                count = 1;
            }else if( contact1.equals(p.getContact())) {
                    Toast.makeText(this, "Contact Number has been exists ! ",
                            Toast.LENGTH_LONG).show();
                    count = 1;
            }else if (email1.equals(p.getEmail())){
                Toast.makeText(this, "Email has been exists ! ",
                        Toast.LENGTH_LONG).show();
                count = 1;
            }
         //   }
        }

        if(count == 0) {

        Person person1 = new Person(id,name1, pass,ic, contact1,email1,null );
        pvm.insert(person1);
       // uid.setText(pvm.getPerson().get(3).getUid());
        Intent intent = new Intent(this,reservation.class);
        startActivity(intent);
        }

    }



//    public void imageListener(View view) {
//        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
//                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(pickPhoto, 1);
//    }
//    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
//        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
//        switch(requestCode) {
//            case 0:
//                if(resultCode == RESULT_OK){
//                    Uri selectedImage = imageReturnedIntent.getData();
//
//                }
//
//                break;
//            case 1:
//                if(resultCode == RESULT_OK){
//                    Uri selectedImage = imageReturnedIntent.getData();
//                }
//                break;
//        }
//    }
}
