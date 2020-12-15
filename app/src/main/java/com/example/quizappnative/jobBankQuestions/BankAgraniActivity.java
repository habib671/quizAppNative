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

public class BankAgraniActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1aOu-LqZ4qlD89shHW4LqGKKIrk8BXQBj/view?usp=sharing",
            "https://drive.google.com/file/d/1rQvtc5EvhAOXhret0zrT1mCqM4DaNUOK/view?usp=sharing",
            "https://drive.google.com/file/d/1YltaBCQdOLV4VUKxZ9r3MYPR381yoWIw/view?usp=sharing",
            "https://drive.google.com/file/d/1JFY1HqdI0_0OllnpTgzW_7o1WPybgb4B/view?usp=sharing",
    };

    private final String[] names = {
            "Agrani Bank 2017",
            "Agrani Bank Cash 2017",
            "Agrani Bank SO 2015",
            "Agrani Bank SO 2017 SOlve",
    };

    private final int[] image = {
            R.drawable.agrani_bank,
            R.drawable.agrani_bank,
            R.drawable.agrani_bank,
            R.drawable.agrani_bank,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_agrani);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.bank_agra_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.agrani_bank);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.bank_agra_list_view);
        MyListAdapter adapter = new MyListAdapter(BankAgraniActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BankAgraniActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}