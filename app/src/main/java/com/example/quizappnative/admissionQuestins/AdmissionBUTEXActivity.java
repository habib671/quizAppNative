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

public class AdmissionBUTEXActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1SPTMJj8giVH4nPli5dhd1gO8Slfs3D04/view?usp=sharing",
    };

    private final String[] names = {
            "BUTex Admission Test 2001-2019",
    };

    private final int[] image = {
            R.drawable.butex_logo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_butex);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.butex_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.uni_butex);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.butex_list_view);
        MyListAdapter adapter = new MyListAdapter(AdmissionBUTEXActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(AdmissionBUTEXActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}