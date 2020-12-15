package com.example.quizappnative.admissionQuestins;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;

public class AdmissionChittagongUniActivity extends AppCompatActivity {


    private final String[] links = {
            "https://drive.google.com/file/d/1pBBfm0Jm8SlIUBqyoB2ROfkw76gWzDHk/view?usp=sharing",
    };

    private final String[] names = {
            "Chittagong University Admission Test",
    };

    private final int[] image = {
            R.drawable.chittagong_university_logo
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_chittagong_uni);
        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.chi_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.uni_chitt);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.chi_list_view);
        MyListAdapter adapter = new MyListAdapter(AdmissionChittagongUniActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(AdmissionChittagongUniActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}