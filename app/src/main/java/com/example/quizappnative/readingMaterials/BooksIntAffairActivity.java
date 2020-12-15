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

public class BooksIntAffairActivity extends AppCompatActivity {

    private final String[] links = {
           "https://drive.google.com/file/d/1EX2he276axNYBOW-eFPtO3tHyLSSZ5sH/view?usp=sharing",
           "https://drive.google.com/file/d/1QOoW6Lmm-Boiv1eFx5-8upxvEYtr4B6w/view?usp=sharing",
           "https://drive.google.com/file/d/1J0VNxb59YLM1yzVXkYvFpsMUl6lk-pVL/view?usp=sharing",
    };

    private final String[] names = {
            "35 BCS Professor International Affairs",
            "MP3 International Affairs",
            "Oracle International Affairs",
    };

    private final int[] image = {
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_int_affair);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.int_aff_books_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.international_affair_books);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.int_aff_books_list_view);
        MyListAdapter adapter = new MyListAdapter(BooksIntAffairActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BooksIntAffairActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });
    }
}