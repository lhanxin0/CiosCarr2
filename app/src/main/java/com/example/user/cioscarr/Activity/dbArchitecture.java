package com.example.user.cioscarr.Activity;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.cioscarr.Adapter.PersonAdapter;
import com.example.user.cioscarr.R;
import com.example.user.cioscarr.Repository.PersonRepository;
import com.example.user.cioscarr.ViewModel.PersonViewModel;
import com.example.user.cioscarr.entity.Person;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class dbArchitecture extends main_navDrawer {
    private PersonViewModel pvm;
    private PersonRepository pvr;

    EditText txtCustName ;
    EditText txtCustContact;
    EditText txtCustEmail ;
    EditText txtCustIC ;
    EditText txtPassword ;
    String id;
    ImageView profilePic ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_db_architecture);
        setTitle("Profile");
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_db_architecture, null, false);
        drawer.addView(contentView, 0);

        Intent intent = getIntent();
      id = intent.getStringExtra("customerID");


        pvm = ViewModelProviders.of(this).get(PersonViewModel.class);

         txtCustName = findViewById(R.id.txtUser_name);
         txtCustContact = findViewById(R.id.txtUser_contact);
         txtCustEmail = findViewById(R.id.txtUser_email);
         txtCustIC = findViewById(R.id.txtUser_ic);
         txtPassword = findViewById(R.id.txtUser_pass);
        profilePic = findViewById(R.id.imgProfile);
        Person profile = pvm.getPersonById(id);

        txtCustName.setText(profile.getName());
        txtCustContact.setText(profile.getContact());
        txtCustEmail.setText(profile.getEmail());
        txtCustIC.setText(profile.getIc_num());
        txtPassword.setText(profile.getPassword());

        if(profile.getPro_pic()!=null) {
            bitmap = BitmapFactory.decodeByteArray(profile.getPro_pic(), 0, profile.getPro_pic().length);
            profilePic.setImageBitmap(bitmap);
        }else if(profile.getPro_pic() == null){
            Resources resource = getResources();
            Drawable drawable = resource.getDrawable(R.drawable.logo);
            profilePic.setImageDrawable(drawable);
        }





    }

    public void uploadPicListener(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),1);
    }
   private Bitmap bitmap ;
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {

                case 1:
                    if (resultCode == Activity.RESULT_OK) {
                        //data gives you the image uri. Try to convert that to bitmap
                        Uri ab = data.getData();
                         bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), ab);
                        profilePic.setImageBitmap(bitmap);
                        break;
                    } else if (resultCode == Activity.RESULT_CANCELED) {
                        Log.e("a", "Selecting picture cancelled");
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e("a", "Exception in onActivityResult : " + e.getMessage());
        }
    }
Button btnConfirm;
Button btnEdit;
FloatingActionButton uploadPic ;
    public void editProfileListener(View view) {
        txtCustIC.setEnabled(true);
        txtCustName.setEnabled(true);
        txtCustContact.setEnabled(true);
        txtCustEmail.setEnabled(true);
        txtPassword.setEnabled(true);
        txtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        btnConfirm = findViewById(R.id.btnEditConfirm);
        btnConfirm.setVisibility(view.VISIBLE);
        btnConfirm.setClickable(true);
        btnEdit = findViewById(R.id.btnCancelEdit);
        btnEdit.setVisibility(view.VISIBLE);
        btnEdit.setClickable(true);
        uploadPic = findViewById(R.id.floatingActionButton3);
        uploadPic.setAlpha(1.0f);
        uploadPic.setClickable(true);

    }

    public void confirmEditListener(View view) {

      String cname = txtCustName.getText().toString();
      String ccontact = txtCustContact.getText().toString();
      String cemail = txtCustEmail.getText().toString();
      String cic = txtCustIC.getText().toString();
      String cpass = txtPassword.getText().toString();


        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        Person updatePerson = null;
        if(byteArray!=null) {
             updatePerson = new Person(id, cname, cic, cpass, ccontact, cemail, byteArray);
        }else if (bitmap==null){
             updatePerson = new Person(id, cname, cic, cpass, ccontact, cemail, null);
        }
      pvm.update(updatePerson);
        bitmap.recycle();
        Toast.makeText(this, "Update Successful",
                Toast.LENGTH_LONG).show();
        finish();
        startActivity(getIntent());

    }

    public void cancelEditListener(View view) {
        finish();
        startActivity(getIntent());
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
