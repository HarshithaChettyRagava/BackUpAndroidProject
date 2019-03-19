package com.example.AndroidProject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignInPage extends AppCompatActivity {

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
        db = new DatabaseHelper(this);
        Cursor cursor = db.allData();
        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"No rows found",Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                Toast.makeText(getApplicationContext(),"Name is :"+cursor.getString(0),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"EMail Id is :"+cursor.getString(1),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Address is :"+cursor.getString(2),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Phone No is :"+cursor.getString(3),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Password is :"+cursor.getString(4),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"ConfirmPwd is :"+cursor.getString(5),Toast.LENGTH_SHORT).show();
            }
        }
    }



    public void buttonLogin(View v){
        Intent inn = new Intent(this,CarBooking.class);
        startActivity(inn);
    }


}
