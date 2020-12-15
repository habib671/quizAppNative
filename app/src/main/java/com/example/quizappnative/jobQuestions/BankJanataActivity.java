package com.example.quizappnative.jobQuestions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;

public class BankJanataActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1JuDS-CqCW8L-hCX7_HmX2NVFwEb_v0kH/view?usp=sharing",
            "https://drive.google.com/file/d/1sAouKzdVp4EDgDEKdwGTI_V4GE2EcFV4/view?usp=sharing",
            "https://drive.google.com/file/d/19WIF3OY5EZjt5aWeUpepvH4ejZu3B4oy/view?usp=sharing",
    };

    private final String[] names = {
            "Janata Bank AEO Teller 2020",
            "Janata Bank 2018",
            "Janata Bank AEO 2019",
    };

    private final int[] image = {
            R.drawable.janata_bank,
            R.drawable.janata_bank,
            R.drawable.janata_bank,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_janata);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.bank_jan_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.janata_bank);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.bank_jan_list_view);
        MyListAdapter adapter = new MyListAdapter(BankJanataActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BankJanataActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });
    }
}