package com.example.etest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private RecyclerView testView;
    private Toolbar toolbar;
    private List<TestModel> testList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        int cat_index = getIntent().getIntExtra("CAT_INDEX",0);
        Intent intent = getIntent();
        String []myTitles = intent.getStringArrayExtra("SAMPLE TITLE");
        getSupportActionBar().setTitle(myTitles[cat_index]);

        testView = findViewById(R.id.test_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        testView.setLayoutManager(layoutManager);

        loadTestData();

        TestAdapter adapter = new TestAdapter(testList);
        testView.setAdapter(adapter);

    }

    private void loadTestData()
    {
        testList = new ArrayList<>();
        testList.add(new TestModel("1",10,10 ));
        testList.add(new TestModel("2",20,20 ));
        testList.add(new TestModel("3",30,30 ));
        testList.add(new TestModel("4",40,40 ));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            TestActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}