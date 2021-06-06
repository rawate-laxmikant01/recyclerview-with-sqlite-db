package com.example.recycler_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.email_login);
        password=findViewById(R.id.password_login);

    }

    public void login(View view) {
        String Username=username.getText().toString().trim();
        String Password=password.getText().toString().trim();

        //object created for Database class DbHelper

        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //content  values is used to put values that we want to put in the table
        ContentValues values = new ContentValues();
        values.put("username", Username);
        values.put("password", Password);

        long rowId = db.insert("user_login", null, values);

        Log.e("Row Id", "**********" + rowId);
        Toast.makeText(this, " Data Inserted Sucessfully\n" + Username + "\n " + Password + "\n " + rowId, Toast.LENGTH_LONG).show();
    }

    public void show(View view) {

        startActivity(new Intent(Login.this,MainActivity.class));

        //  Toast.makeText(this, ""+ password, Toast.LENGTH_SHORT).show();
    }

}