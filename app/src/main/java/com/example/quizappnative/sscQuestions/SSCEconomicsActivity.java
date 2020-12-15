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

public class SSCEconomicsActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1LcXTs1WH1Jx2t_AK9g59ScqHq1MqZu_q/view?usp=sharing",
            "https://drive.google.com/file/d/191ZTu7R-1Zq2tLuhspXSEkmskrO-5O2J/view?usp=sharing",
            "https://drive.google.com/file/d/1KWi7tZvPVh4kqxLiG8MTD_815ex_wI19/view?usp=sharing",
            "https://drive.google.com/file/d/1eWclylX7HM66o4wtbIe0ftQzgWS-g_jB/view?usp=sharing",
            "https://drive.google.com/file/d/1OwdRPE9DIU3QINRdhtRNyaQDQiyLpzRU/view?usp=sharing",
    };

    private final String[] names = {
            "Economics 2015",
            "Economics 2016",
            "Economics 2017",
            "Economics 2018",
            "Economics 2019",
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
        setContentView(R.layout.activity_ssc_economics);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.scc_eco_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.ssc_econ_all);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.scc_eco_list_view);
        MyListAdapter adapter = new MyListAdapter(SSCEconomicsActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(SSCEconomicsActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}