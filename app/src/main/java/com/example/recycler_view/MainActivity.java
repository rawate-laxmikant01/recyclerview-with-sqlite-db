package com.example.recycler_view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_data;

    ArrayList<Model> modellist;
    RecyclerviewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_data=findViewById(R.id.rv_data);

        modellist=new ArrayList<Model>();
        rv_data.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter=new RecyclerviewAdapter(modellist,this);


        DbHelper dbHelper=new DbHelper(this);
        SQLiteDatabase db=dbHelper.getReadableDatabase();

        String[] col={"username","password"};

        Cursor cursor=db.query("user_login",col,"",null,"","","");

        while (cursor.moveToNext()){
            String userName=cursor.getString(cursor.getColumnIndexOrThrow("username"));
            String passWord=cursor.getString(cursor.getColumnIndexOrThrow("password"));

            Model p1=new Model(""+userName,""+passWord);

            modellist.add(p1);

        }

        cursor.close();
        rv_data.setAdapter(recyclerViewAdapter);

    }
}