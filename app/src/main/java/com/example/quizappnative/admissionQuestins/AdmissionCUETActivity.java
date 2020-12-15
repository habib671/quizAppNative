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

public class AdmissionCUETActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1Y-NerfNyVSeyE8tKcBAHz6CsXoxceB4o/view?usp=sharing",
    };

    private final String[] names = {
            "CUET Admission Test",
    };

    private final int[] image = {
            R.drawable.cuet_logo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_cuet);
        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.cuet_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.uni_cuet);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.cuet_list_view);
        MyListAdapter adapter = new MyListAdapter(AdmissionCUETActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(AdmissionCUETActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}