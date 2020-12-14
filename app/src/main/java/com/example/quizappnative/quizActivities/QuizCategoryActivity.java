package com.example.quizappnative.quizActivities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.adapterModels.QuizCategoryGridAdapter;

import java.util.Objects;

import static com.example.quizappnative.SplashActivity.catList;


public class QuizCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_category);

        Toolbar toolbar = findViewById(R.id.quiz_cat_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Quiz Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridView catGridView = findViewById(R.id.catGridView);

        QuizCategoryGridAdapter adapter = new QuizCategoryGridAdapter(catList);
        catGridView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            QuizCategoryActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}