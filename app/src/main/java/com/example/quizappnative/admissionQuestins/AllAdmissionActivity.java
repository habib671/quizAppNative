package com.example.quizappnative.admissionQuestins;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.MainActivity;
import com.example.quizappnative.R;
import com.example.quizappnative.SearchActivity;

import java.util.Objects;

public class AllAdmissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_all);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.admi_all_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.admission);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void openAdmissionMedical(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionMedicalActivity.class);
        startActivity(intent);
    }

    public void openAdmissionBUET(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionBUETActivity.class);
        startActivity(intent);
    }

    public void openAdmissionBUTEX(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionBUTEXActivity.class);
        startActivity(intent);
    }

    public void openAdmissionChittagong(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionChittagongUniActivity.class);
        startActivity(intent);
    }

    public void openAdmissionComilla(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionComillaUniActivity.class);
        startActivity(intent);
    }

    public void openAdmissionCUET(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionCUETActivity.class);
        startActivity(intent);
    }

    public void openAdmissionDU(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionDhakaUniActivity.class);
        startActivity(intent);
    }

    public void openAdmissionJahangirnagar(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionJahangirnagarActivity.class);
        startActivity(intent);
    }

    public void openAdmissionJagannath(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionJagannathActivity.class);
        startActivity(intent);
    }

    public void openAdmissionKaziNazrul(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionKaziNazrulActivity.class);
        startActivity(intent);
    }

    public void openAdmissionKhulnaUni(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionKhulnaUniActivity.class);
        startActivity(intent);
    }

    public void openAdmissionKUET(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionKUETActivity.class);
        startActivity(intent);
    }

    public void openAdmissionNoakhali(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionNoakhaliActivity.class);
        startActivity(intent);
    }

    public void openAdmissionRajshahi(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionRajshahiUniActivity.class);
        startActivity(intent);
    }

    public void openAdmissionRUET(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionRUETActivity.class);
        startActivity(intent);
    }

    public void openAdmissionSUST(View view) {
        Intent intent = new Intent(AllAdmissionActivity.this, AdmissionSUSTActivity.class);
        startActivity(intent);
    }

}