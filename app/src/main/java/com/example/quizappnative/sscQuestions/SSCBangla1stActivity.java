package com.example.quizappnative.sscQuestions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;

public class SSCBangla1stActivity extends AppCompatActivity {
    private final String[] links = {
            "https://google.com",
            "https://google.com",
            "https://google.com",
            "https://google.com",
            "https://google.com",
    };

    private final String[] names = {
            "Int Aff",
            "Int Aff",
            "Int Aff",
            "Int Aff",
    };

    private final int[] image = {
            R.drawable.ssc_exam,
            R.drawable.ssc_exam,
            R.drawable.ssc_exam,
            R.drawable.ssc_exam,
            R.drawable.ssc_exam,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssc_bangla_1st);
        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.scc_b1_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.ssc_b1_all);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.scc_b1_list_view);
        MyListAdapter adapter = new MyListAdapter(SSCBangla1stActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(SSCBangla1stActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });
    }
}