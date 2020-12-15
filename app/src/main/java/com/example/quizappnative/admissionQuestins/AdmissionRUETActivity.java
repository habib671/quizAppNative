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

public class AdmissionRUETActivity extends AppCompatActivity {

    private final String[] links = {

    };

    private final String[] names = {

    };

    private final int[] image = {

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_ruet);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.ruet_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.uni_ruet);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.ruet_list_view);
        MyListAdapter adapter = new MyListAdapter(AdmissionRUETActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(AdmissionRUETActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}