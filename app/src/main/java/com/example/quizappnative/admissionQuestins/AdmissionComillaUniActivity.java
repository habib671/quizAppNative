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

public class AdmissionComillaUniActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/18YoNbv2TBYeYMUbPB_Z1zU7q43uESsmD/view?usp=sharing",
    };

    private final String[] names = {
            "Comilla University Admission Text"
    };

    private final int[] image = {
            R.drawable.comilla_university_logo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_comilla_uni);
        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.comi_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.uni_comilla);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.comi_list_view);
        MyListAdapter adapter = new MyListAdapter(AdmissionComillaUniActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(AdmissionComillaUniActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}