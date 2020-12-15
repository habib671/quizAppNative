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
            "https://drive.google.com/file/d/1PHXBi97wU6QkrlujweMKjhp_Nzeqhhbd/view?usp=sharing",
            "https://drive.google.com/file/d/1668oxfxXjbfb8QeJrjLVQNWRNITgvJPL/view?usp=sharing",
            "https://drive.google.com/file/d/1DVpXcq3kqy7P-ni-J1D8ptJVhP6oo50g/view?usp=sharing",
            "https://drive.google.com/file/d/1AqVz3gcPjo2csgw0ClR4kfAIvqdIQYDM/view?usp=sharing",
            "https://drive.google.com/file/d/1RC8-iNh33xBC66I6ReoNqDq40Kf_itNW/view?usp=sharing",
    };

    private final String[] names = {
            "Bangla 1st 2015",
            "Bangla 1st 2016",
            "Bangla 1st 2017",
            "Bangla 1st 2018",
            "Bangla 1st 2019",

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