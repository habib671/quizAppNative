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

public class BankUttaraActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1mBcv8ecYgvW241X3ghGbsJGWtZdc-Rju/view?usp=sharing",
            "https://drive.google.com/file/d/1sNI_xLRgBKtTAeyxBti4rU-V7xDoX5hM/view?usp=sharing",
            "https://drive.google.com/file/d/1CtbYYQqu-fTZHEmKXcHqwMlajiexLyyg/view?usp=sharing",
    };

    private final String[] names = {
            "Uttara Bank 2017",
            "Uttara Bank AO-Cash 2017",
            "Uttara Bank PBO 2017",
    };

    private final int[] image = {
            R.drawable.uattara_bank,
            R.drawable.uattara_bank,
            R.drawable.uattara_bank,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_uttara);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.bank_utt_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.uttara_bank);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.bank_utt_list_view);
        MyListAdapter adapter = new MyListAdapter(BankUttaraActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BankUttaraActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });

    }
}