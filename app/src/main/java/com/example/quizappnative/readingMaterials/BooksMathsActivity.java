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

public class BooksMathsActivity extends AppCompatActivity {

    private final String[] links = {
            "https://google.com",
            "https://drive.google.com/file/d/1n-_Y9sB7rKmZ4ozRxzXQyJbnew_ToLhS/view?usp=sharing",
            "https://drive.google.com/file/d/1N81N3cqczOAKbRqIIM_5Mi_dVEh1WCw5/view?usp=sharing",
            "https://drive.google.com/file/d/1HCzjYJWEvyOlqGaeLeI3p_-mLI_T4MXh/view?usp=sharing"
    };

    private final String[] names = {
            "Google.com",
            "11 Poets",
            "Bangla Cyclone",
            "Bangla Shahitto"
    };

    private final int[] image = {
            R.drawable.logo,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_maths);


        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.maths_books_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.math_books);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.maths_books_list_view);
        MyListAdapter adapter = new MyListAdapter(BooksMathsActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BooksMathsActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });
    }
}