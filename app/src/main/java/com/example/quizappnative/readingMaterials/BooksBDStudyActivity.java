package com.example.quizappnative.readingMaterials;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;

public class BooksBDStudyActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1gwpwdQ1Oyya-iOdkkGrMqwbn41zT3cwi/view?usp=sharing",
            "https://drive.google.com/file/d/1yYXmf1Ouk9Abrm3Uvevq6yrUcOUkOpKX/view?usp=sharing",
            "https://drive.google.com/file/d/1M52Mge07fd_AS9MWhE-uN83AdK5F5YYf/view?usp=sharing",
            "https://drive.google.com/file/d/14VbNwJFPvf9wYoijRf1PtpOKSEhjWiM2/view?usp=sharing",
            "https://drive.google.com/file/d/16ansWPmjYvpd06m8dWubhahgek8ameLt/view?usp=sharing",
            "https://drive.google.com/file/d/1UkIRbn5A2gntD3MCkpL8Ljgg1iHLCpX-/view?usp=sharing",
            "https://drive.google.com/file/d/1jGuC98gAmrnr4G3kVR_9BRBJCBFUlOIA/view?usp=sharing",
            "https://drive.google.com/file/d/1ucJsIsF4USbEOl3t0G3S5h-42_ZOX8uV/view?usp=sharing",
            "https://drive.google.com/file/d/1qu0HIVo45QACyJKA4oN1tEx_DTrGt91E/view?usp=sharing",
            "https://drive.google.com/file/d/1pfMfuv5XM0KeQEenwWZJv9EFwCne65VC/view?usp=sharing",
    };

    private final String[] names = {
            "Bangla Andoloner Itihas",
            "Karagarer Rojnamocha Note-2",
            "3000 Question on Bangladesh Affairs",
            "MP3 Bangladesh Affairs",
            "Bongobondhu Short-Note",
            "Bongobondhu All Details",
            "Karagarer Rojnamocha Note-2",
            "17 Ti Songbidhan",
            "Written Mania",
            "Professors BCS Bangladesh",
    };

    private final int[] image = {
            R.drawable.bd,
            R.drawable.bd,
            R.drawable.bd,
            R.drawable.bd,
            R.drawable.bd,
            R.drawable.bd,
            R.drawable.bd,
            R.drawable.bd,
            R.drawable.bd,
            R.drawable.bd,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_bd_study);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.bd_study_books_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.bd_study_books);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.bd_study_books_list_view);
        MyListAdapter adapter = new MyListAdapter(BooksBDStudyActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BooksBDStudyActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}