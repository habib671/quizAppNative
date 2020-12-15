package com.example.quizappnative.sscQuestions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;

public class SSCAgricultureActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1JACuDwzHaQUErjozF2t2KQKFabdfuZCp/view?usp=sharing",
            "https://drive.google.com/file/d/1p-PZHyFqRryp6kNYBLY4sSmuxb70SjS0/view?usp=sharing",
            "https://drive.google.com/file/d/15aJIMEas2T_YfujiWohT5ot2oc3mmN4j/view?usp=sharing",
            "https://drive.google.com/file/d/1IzYqSQRK7Lvks0X_UDzBJrkA-07EpEcS/view?usp=sharing",
            "https://drive.google.com/file/d/1gwSZ6SCDFnjwDgkw4RH4qQVyc8P8lUlT/view?usp=sharing",
    };

    private final String[] names = {
            "Agriculture 2015",
            "Agriculture 2016",
            "Agriculture 2017",
            "Agriculture 2018",
            "Agriculture 2019",
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
        setContentView(R.layout.activity_ssc_agriculture);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.scc_agri_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.ssc_agri_all);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.scc_agri_list_view);
        MyListAdapter adapter = new MyListAdapter(SSCAgricultureActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(SSCAgricultureActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });
    }
}