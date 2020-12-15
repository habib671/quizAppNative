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

public class BanksCombinedActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1eGtts3SdAEstGW5qSY0E9RkTXIstftDr/view?usp=sharing",
            "https://drive.google.com/file/d/1Y6dN1aH_kLl5j6r9gygriVewtgCjSW-v/view?usp=sharing",
            "https://drive.google.com/file/d/1EIDyM9A1PWnNThay0I_qd50iXsobBtPS/view?usp=sharing",
            "https://drive.google.com/file/d/1nmmvuHw2_8t3M5-sMfX3cawDZ0M88dw8/view?usp=sharing",
            "https://drive.google.com/file/d/1_TR4BdsV3rTAO9xHqHbWlPopX01WM3Xu/view?usp=sharing",
            "https://drive.google.com/file/d/1qwCN7A4a2g-FbJzg4NEKGcgWq97nUBw2/view?usp=sharing",
            "https://drive.google.com/file/d/1vNvs_gfufG0gOXsvSsIOkW-MHWYpeWOT/view?usp=sharing",
    };

    private final String[] names = {
            "Combined 4 Bank IT 2018",
            "Combined 5 Bank",
            "Combined 8 Bank SO 2019",
            "Combined Bank 2019",
            "Combined 3 Bank 2018",
            "Combined 3 Bank",
            "Combined 8 Bank SO 2018",
    };

    private final int[] image = {
            R.drawable.combined_bank,
            R.drawable.combined_bank,
            R.drawable.combined_bank,
            R.drawable.combined_bank,
            R.drawable.combined_bank,
            R.drawable.combined_bank,
            R.drawable.combined_bank,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_combined);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.bank_com_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.combined);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.bank_com_list_view);
        MyListAdapter adapter = new MyListAdapter(BanksCombinedActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BanksCombinedActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}