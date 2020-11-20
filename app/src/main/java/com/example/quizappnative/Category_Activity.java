package com.example.quizappnative;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import static com.example.quizappnative.Splash_Activity.catList;


public class Category_Activity extends AppCompatActivity {

    private GridView catGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quiz Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        catGridView=findViewById(R.id.catGridView);

       /* List<String> catList = new ArrayList<>();

        catList.add("Category 1");
        catList.add("Category 2");
        catList.add("Category 3");
        catList.add("Category 4");
        catList.add("Category 5");
        catList.add("Category 6");
        catList.add("Category 7");
        catList.add("Category 8");
        catList.add("Category 9");
        catList.add("Category 10");*/

        CateegoryGridAdapter adapter = new CateegoryGridAdapter(catList);
        catGridView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Category_Activity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}