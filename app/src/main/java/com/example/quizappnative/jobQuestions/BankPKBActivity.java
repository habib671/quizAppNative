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

public class BankPKBActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1p_kRiaJonQG3TT3hD5ZKaHSkjDMUHkQb/view?usp=sharing",
            "https://drive.google.com/file/d/1sVsItQ606gfrsuyfUpqoFcV98nBAoUem/view?usp=sharing",
            "https://drive.google.com/file/d/10DpB0ogTULrngASz2Tw-N0JbAC_RSgKm/view?usp=sharing",
            "https://drive.google.com/file/d/1c97jdArCswKp6GDoBUHFOsqaAwmuzzRV/view?usp=sharing",
            "https://drive.google.com/file/d/1s19t8yyFUlcEcadhzlUioKo5WqFd8P58/view?usp=sharing",
    };

    private final String[] names = {
            "PKB General 2017",
            "PKB Cash 2018",
            "PKB SO 2018",
            "PKB EO 2019",
            "PKB EO-Cash 2019",

    };

    private final int[] image = {
            R.drawable.pkb_bank,
            R.drawable.pkb_bank,
            R.drawable.pkb_bank,
            R.drawable.pkb_bank,
            R.drawable.pkb_bank,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_p_k_b);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.bank_pkb_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.probashi_kallyan_bank);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.bank_pkb_list_view);
        MyListAdapter adapter = new MyListAdapter(BankPKBActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BankPKBActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });

    }
}