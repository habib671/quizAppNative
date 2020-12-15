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

public class SSCEnglish1stActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1_WXYrp2_cMEjEQ-HgHbLYOOT-jcL_D79/view?usp=sharing",
            "https://drive.google.com/file/d/1ILthB4PmkIXC3vqVsNlkq40UPYoeT0OH/view?usp=sharing",
            "https://drive.google.com/file/d/1sX8UPcWgs-68XMtv5TbVubOgravV9bcg/view?usp=sharing",
            "https://drive.google.com/file/d/14jkxKvluDXeZ-ZLuc4W14oyb-RKhhVq-/view?usp=sharing",
            "https://drive.google.com/file/d/12tC_x6BOR-VFBhCkW_Kyz9vsQpzbWx-N/view?usp=sharing",
    };

    private final String[] names = {
            "English 1st 2015",
            "English 1st 2016",
            "English 1st 2017",
            "English 1st 2018",
            "English 1st 2019",
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
        setContentView(R.layout.activity_ssc_english_1st);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.scc_e1_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.ssc_e1_all);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.scc_e1_list_view);
        MyListAdapter adapter = new MyListAdapter(SSCEnglish1stActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(SSCEnglish1stActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });
    }
}