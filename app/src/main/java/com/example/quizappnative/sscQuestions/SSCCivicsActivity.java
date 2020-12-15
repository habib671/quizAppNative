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

public class SSCCivicsActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1HVOUdIMS0gfl68HCFf5VFSqzHkhonDeL/view?usp=sharing",
            "https://drive.google.com/file/d/1XLqEhFJ82irKFzHMETxCVHuYmpidCTbJ/view?usp=sharing",
            "https://drive.google.com/file/d/1ggUkPtk4tvL0CWuc7rSwkZU9SkoAU5Ui/view?usp=sharing",
            "https://drive.google.com/file/d/1zrkjuwfVGUNCs40qATDBtzHGi2LK-Ciw/view?usp=sharing",
            "https://drive.google.com/file/d/1aK7singqld2OkCX94vqkrq8-6ZarJm0H/view?usp=sharing",
    };

    private final String[] names = {
            "Civics 2015",
            "Civics 2016",
            "Civics 2017",
            "Civics 2018",
            "Civics 2019",
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
        setContentView(R.layout.activity_ssc_civics);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.scc_civ_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.ssc_cvics_all);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.scc_civ_list_view);
        MyListAdapter adapter = new MyListAdapter(SSCCivicsActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(SSCCivicsActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}