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

public class SSCBangla2ndActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1pLM2WsMRi6mrZ2b0HqqDM3lFpny43VGH/view?usp=sharing",
            "https://drive.google.com/file/d/1uQaMre7eOnjiqGZXwE0taiu53q1Wwnd3/view?usp=sharing",
            "https://drive.google.com/file/d/1b5NQs2oAIAR6NGYBnVJJ7o5eF9X9DdOq/view?usp=sharing",
            "https://drive.google.com/file/d/13KQbsEqdvnLVBzVem_I-ikUUTnB-7-XX/view?usp=sharing",
            "https://drive.google.com/file/d/1C3xwc5CCYK8gVD8Fj6s4XEdx5W2lID_x/view?usp=sharing",
    };

    private final String[] names = {
            "Bangla 2nd 2015",
            "Bangla 2nd 2016",
            "Bangla 2nd 2017",
            "Bangla 2nd 2018",
            "Bangla 2nd 2019",
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
        setContentView(R.layout.activity_ssc_bangla_2nd);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.scc_b2_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.ssc_b2_all);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.scc_b2_list_view);
        MyListAdapter adapter = new MyListAdapter(SSCBangla2ndActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(SSCBangla2ndActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });
    }
}