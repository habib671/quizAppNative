package com.example.quizappnative.sscQuestions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;

import java.util.Objects;

public class SSCMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssc_main);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.ssc_all_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.ssc);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void openSSCAccounting(View view) {
        Intent intent = new Intent(SSCMainActivity.this, SSCAccountingActivity.class);
        startActivity(intent);
    }

    public void openSSCAgriculture(View view) {
        Intent intent = new Intent(SSCMainActivity.this, SSCAgricultureActivity.class);
        startActivity(intent);
    }

    public void openSSCBangla1st(View view) {
        Intent intent = new Intent(SSCMainActivity.this, SSCBangla1stActivity.class);
        startActivity(intent);
    }

    public void openSSCBangla2nd(View view) {
        Intent intent = new Intent(SSCMainActivity.this, SSCBangla2ndActivity.class);
        startActivity(intent);
    }

    public void openSSCBissoPrichoy(View view) {
        Intent intent = new Intent(SSCMainActivity.this, SSCBDWorldViewActivity.class);
        startActivity(intent);
    }

    public void openSSCBiology(View view) {
        Intent intent = new Intent(SSCMainActivity.this, SSCBiologyActivity.class);
        startActivity(intent);
    }

    public void openSSCBussinessInit(View view) {
        Intent intent = new Intent(SSCMainActivity.this, SSCBusinessInitActivity.class);
        startActivity(intent);
    }

    public void openSSCChemistry(View view) {
        Intent intent = new Intent(SSCMainActivity.this, SSCChemistryActivity.class);
        startActivity(intent);
    }

    public void openSSCCivics(View view) {
        Intent intent = new Intent(SSCMainActivity.this, SSCCivicsActivity.class);
        startActivity(intent);
    }

    public void openSSCEconomics(View view) {
        Intent intent = new Intent(SSCMainActivity.this, SSCEconomicsActivity.class);
        startActivity(intent);
    }

    public void openSSCEnglish1st(View view) {
        Intent intent = new Intent(SSCMainActivity.this, SSCEnglish1stActivity.class);
        startActivity(intent);
    }

    public void openSSCEnglish2nd(View view) {
    }

    public void openSSCFinanceBanking(View view) {
    }

    public void openSSCGeography(View view) {
    }

    public void openSSCHigherMath(View view) {
    }

    public void openSSCGeneralMath(View view) {
    }

    public void openSSCPhysics(View view) {
    }

    public void openSSCHomeScience(View view) {
    }

    public void openSSCIslam(View view) {
    }

    public void openSSCScience(View view) {
    }

    public void openSSC_ICT(View view) {
    }

    public void openSSCHindu(View view) {
    }
}