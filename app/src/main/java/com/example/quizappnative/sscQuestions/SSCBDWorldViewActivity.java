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

public class SSCBDWorldViewActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1zyqwaFQP6eMNXIVDWOir2BHrvcsenoI3/view?usp=sharing",
            "https://drive.google.com/file/d/1mt2RS-egsICvApIpAuAw1fBKqY6XT3EE/view?usp=sharing",
            "https://drive.google.com/file/d/1UHHSQ-bROAO--Om4JR8D-umzHOo_gQm9/view?usp=sharing",
            "https://drive.google.com/file/d/14dLDfq1VpNcAc6gWsJx0vjvo_97KKced/view?usp=sharing",
            "https://drive.google.com/file/d/1KgrG4YtAzjb_XrfiHXG3XPYBplnJ21Mi/view?usp=sharing",
    };

    private final String[] names = {
            "Bangladesh and World 2015",
            "Bangladesh and World 2016",
            "Bangladesh and World 2017",
            "Bangladesh and World 2018",
            "Bangladesh and World 2019",
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
        setContentView(R.layout.activity_ssc_bd_world_view);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.scc_bdw_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.ssc_bdwrldview_all);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.scc_bdw_list_view);
        MyListAdapter adapter = new MyListAdapter(SSCBDWorldViewActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(SSCBDWorldViewActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}