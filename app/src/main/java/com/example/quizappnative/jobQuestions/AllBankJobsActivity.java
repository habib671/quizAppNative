package com.example.quizappnative.jobQuestions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;

import java.util.Objects;

public class AllBankJobsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banks_all);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.banks_all_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.banks);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void openBankAgrani(View view) {
        Intent intent = new Intent(AllBankJobsActivity.this, BankAgraniActivity.class);
        startActivity(intent);
    }

    public void openBankBD(View view) {
        Intent intent = new Intent(AllBankJobsActivity.this, BankBangladeshActivity.class);
        startActivity(intent);
    }

    public void openBankJanata(View view) {
        Intent intent = new Intent(AllBankJobsActivity.this, BankJanataActivity.class);
        startActivity(intent);
    }

    public void openBankPKB(View view) {
        Intent intent = new Intent(AllBankJobsActivity.this, BankPKBActivity.class);
        startActivity(intent);
    }

    public void openBankRupali(View view) {
        Intent intent = new Intent(AllBankJobsActivity.this, BankRupaliActivity.class);
        startActivity(intent);
    }

    public void openBankSonali(View view) {
        Intent intent = new Intent(AllBankJobsActivity.this, BankSonaliActivity.class);
        startActivity(intent);
    }

    public void openBankMixed(View view) {
        Intent intent = new Intent(AllBankJobsActivity.this, BanksMixedActivity.class);
        startActivity(intent);
    }

    public void openBankCombined(View view) {
        Intent intent = new Intent(AllBankJobsActivity.this, BanksCombinedActivity.class);
        startActivity(intent);
    }

    public void openBankUttara(View view) {
        Intent intent = new Intent(AllBankJobsActivity.this, BankUttaraActivity.class);
        startActivity(intent);
    }
}