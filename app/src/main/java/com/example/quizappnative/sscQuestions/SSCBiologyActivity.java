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

public class SSCBiologyActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1MrG3xPOO-ZQr_16krsaj0aFK8Q4gy78R/view?usp=sharing",
            "https://drive.google.com/file/d/1UvN24NWfP8KzUMk5DMZcCNcv4g6tCumu/view?usp=sharing",
            "https://drive.google.com/file/d/1M-3kQcCvX0xzgZwhXnBnm3Lei4mrPL-Y/view?usp=sharing",
            "https://drive.google.com/file/d/1wZIbECx54uDRmKmg_ibaEiW_6Vlj26Dl/view?usp=sharing",
            "https://drive.google.com/file/d/1SmmMqK73nav2zTCqnpw37Dl5BEuervfx/view?usp=sharing",
    };

    private final String[] names = {
            "Biology 2015",
            "Biology 2016",
            "Biology 2017",
            "Biology 2018",
            "Biology 2019",
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
        setContentView(R.layout.activity_ssc_biology);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.scc_bio_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.ssc_bio_all);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.scc_bio_list_view);
        MyListAdapter adapter = new MyListAdapter(SSCBiologyActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(SSCBiologyActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}