package com.example.quizappnative.jobBankQuestions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;

public class BankBangladeshActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1RPglFIueSujFUGIjsXETmddm64l3tjZO/view?usp=sharing",
            "https://drive.google.com/file/d/10BGAqw93Xj-sLERH3UWA3lD9Mu58eYEG/view?usp=sharing",
            "https://drive.google.com/file/d/1-UmPXyAl5fn6k9k5NG4zAbsPGJfECPFD/view?usp=sharing",
            "https://drive.google.com/file/d/1ljaE6YG7r6H4EIHsBGJP-PDj7u8P9gr-/view?usp=sharing",
            "https://drive.google.com/file/d/12xs9bNmbGty1jBLD7Wrzq1mvwY18RAsl/view?usp=sharing",
    };

    private final String[] names = {
            "Bangladesh Bank 2018 Solve",
            "Bangladesh Bank 2001-2015",
            "Bangladesh Bank 2001-2019",
            "Bangladesh Bank 2016",
            "Bangladesh Bank 2017",
    };

    private final int[] image = {
            R.drawable.bd_bank,
            R.drawable.bd_bank,
            R.drawable.bd_bank,
            R.drawable.bd_bank,
            R.drawable.bd_bank,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_bangladesh);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.bank_bd_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.bangladesh_bank);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.bank_bd_list_view);
        MyListAdapter adapter = new MyListAdapter(BankBangladeshActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BankBangladeshActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}