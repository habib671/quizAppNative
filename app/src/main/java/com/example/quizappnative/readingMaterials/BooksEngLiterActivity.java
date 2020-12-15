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

public class BooksEngLiterActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1Q4DEt-ISfCDbZvW5qemO71Og5etY5Iec/view?usp=sharing",
            "https://drive.google.com/file/d/1zjcV5OC18OKytH8ZK-NEKgxMxznMwrDO/view?usp=sharing",
            "https://drive.google.com/file/d/1WA7k2WIoyLk57ncPU_J3aKRBGlEVu6zd/view?usp=sharing",
            "https://drive.google.com/file/d/1NL-NQF0MLQfzBu6QHKAT1c-iVoXxB_iL/view?usp=sharing",
            "https://drive.google.com/file/d/1LogmbHO2RPnUwCmNLYcWxQ3DjkTeWPUE/view?usp=sharing",
            "https://drive.google.com/file/d/1rBPPqbkOgbeTmSJ-9Mqxkd3j89RlEq50/view?usp=sharing",
    };

    private final String[] names = {
            "English Literature Period Hand Note",
            "English Literature Short Note",
            "A Hand Note on English Literature",
            "Oracle English Literature",
            "A Compilation of Last 18 years Eng.Literature Ques",
            "MCQ English Literature-Maneesh Rastogi"

    };

    private final int[] image = {
            R.drawable.english_literature,
            R.drawable.english_literature,
            R.drawable.english_literature,
            R.drawable.english_literature,
            R.drawable.english_literature,
            R.drawable.english_literature,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_eng_liter);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.eng_li_books_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.english_literature_books);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.eng_li_books_list_view);
        MyListAdapter adapter = new MyListAdapter(BooksEngLiterActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BooksEngLiterActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}