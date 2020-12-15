package com.example.quizappnative.jobBankQuestions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;

public class BankSonaliActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1qGKvgDjvAI8MfngK8qxuTZrdW19V7cHW/view?usp=sharing",
            "https://drive.google.com/file/d/1wOS0YfZVRDxgmXHxQ6VXVpZuynND7nqE/view?usp=sharing",
            "https://drive.google.com/file/d/1kvKVUj__mMiiBtSU30aJqwCtlcO7hvl3/view?usp=sharing",
            "https://drive.google.com/file/d/1-agtITv_6p8zxj4-gY4kcu_kmLupWpTC/view?usp=sharing",
            "https://drive.google.com/file/d/1Liyc7WDYx1xBFrZzfnN48epYsk0LuHAR/view?usp=sharing",
            "https://drive.google.com/file/d/1flAVRoisKiFAMauHA2a_dBLi0PvjSOaw/view?usp=sharing",
            "https://drive.google.com/file/d/1eSUQTITASQfO4ApXK2PWm-3S5A06RAPg/view?usp=sharing",
            "https://drive.google.com/file/d/1p6I4eqkUxtLh-XlqQSB8G93Xhhgcj2S4/view?usp=sharing",
            "https://drive.google.com/file/d/1VsKjvQ2FxwYp8Aaia5Gf39dKqfFjYYu0/view?usp=sharing",
    };

    private final String[] names = {
            "SBL Officer 2013",
            "SBL Officer-Cash 2010",
            "SBL Cash 2018",
            "SBL SO 2013",
            "SBL SO 2010",
            "SBL Officer-Cash 2014",
            "SBL IT 2018",
            "SBL SO 2018",
            "SBL TAO 2018",
    };

    private final int[] image = {
            R.drawable.sonali_bank,
            R.drawable.sonali_bank,
            R.drawable.sonali_bank,
            R.drawable.sonali_bank,
            R.drawable.sonali_bank,
            R.drawable.sonali_bank,
            R.drawable.sonali_bank,
            R.drawable.sonali_bank,
            R.drawable.sonali_bank,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_sonali);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.bank_son_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.sonali_bank);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.bank_son_list_view);
        MyListAdapter adapter = new MyListAdapter(BankSonaliActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BankSonaliActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });

    }
}