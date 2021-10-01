package com.example.etest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    GridView gridView;
    String[] numWord = {"Computer Organization and Architecture", "Digital Electronics", "Discrete Mathematics", "Data Structures - 1", "Indian Constitution", "Principles of Programming with Python", "Object Oriented Programming", "Operating Systems", "Database Management System"};
    int[] numImage = {R.drawable.coa,R.drawable.de,R.drawable.dm,R.drawable.ds,R.drawable.ic,R.drawable.pplp,R.drawable.oop,R.drawable.os,R.drawable.dbms};

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.cat_grid);
        MainAdapter adapter = new MainAdapter(MainActivity.this, numWord, numImage);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), numWord[position], Toast.LENGTH_SHORT).show();
            }
        });

        //Initializing and assigning variables here
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);


        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.leaderboard:
                        startActivity(new Intent(getApplicationContext(), Leaderboard.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        return true;

                    case R.id.acc:
                        startActivity(new Intent(getApplicationContext(), Account.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

}