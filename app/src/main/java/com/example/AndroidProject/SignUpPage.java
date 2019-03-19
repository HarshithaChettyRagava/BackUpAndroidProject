package com.example.AndroidProject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;

    public EditText nameET;
    public EditText emailIdET;
    public EditText addressET;
    public EditText phoneNoET;
    public EditText passwordET;
    public EditText confirmET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
         nameET = findViewById(R.id.nameET);
         emailIdET = findViewById(R.id.emailET);
         addressET = findViewById(R.id.addressET);
         phoneNoET = findViewById(R.id.phoneNoET);
         passwordET = findViewById(R.id.passwordET);
         confirmET = findViewById(R.id.confirmPwdET);
         mDatabaseHelper = new DatabaseHelper(this);
    }

    public void submitButton (View v){
        String newEntry1 = nameET.getText().toString();
        String newEntry2 = emailIdET.getText().toString();
        String newEntry3 = addressET.getText().toString();
        String newEntry4 = phoneNoET.getText().toString();
        String newEntry5 = passwordET.getText().toString();
        String newEntry6 = confirmET.getText().toString();

        if(newEntry1.length()==0){
            Toast.makeText(this,"please fill the name field!",Toast.LENGTH_SHORT).show();
        }
        else{
            AddData(newEntry1, newEntry2, newEntry3, newEntry4, newEntry5, newEntry6);
            nameET.setText("");
            emailIdET.setText("");
            addressET.setText("");
            phoneNoET.setText("");
            passwordET.setText("");
            confirmET.setText("");
        }

//        Intent inn = new Intent(this,CarBooking.class);
//        startActivity(inn);
    }


    public void AddData(String newEntry1, String newEntry2, String newEntry3, String newEntry4, String newEntry5, String newEntry6){
        boolean insertData = mDatabaseHelper.addData(newEntry1, newEntry2, newEntry3, newEntry4, newEntry5, newEntry6);
        if(insertData){
            Toast.makeText(this, "Data Sucessfully Inserted!",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Something went wrong..",Toast.LENGTH_SHORT).show();
        }
    }

}
