package com.example.quizappnative.sscQuestions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;

public class SSCChemistryActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1HTUAQApbUL6kIBI2Mt-AYsC0Fuk8Wu3W/view?usp=sharing",
            "https://drive.google.com/file/d/1rFpbCbrVrFPIvWjNviMHS-inhmOICqZN/view?usp=sharing",
            "https://drive.google.com/file/d/1jG_ypBA6xMrDWS4hfny1MbmEsFPxGFXq/view?usp=sharing",
            "https://drive.google.com/file/d/12k6qeJpJEdT68Bb3VLNulfabf5thc2Px/view?usp=sharing",
            "https://drive.google.com/file/d/1XKtHeoRb-zCYZ54P23FbVxDkoXNR4f12/view?usp=sharing",
    };

    private final String[] names = {
            "Chemistry 2015",
            "Chemistry 2016",
            "Chemistry 2017",
            "Chemistry 2018",
            "Chemistry 2019",
    };

    private final int[] image = {
            R.drawable.ssc_exam,
            R.drawable.ssc_exam,
            R.drawable.ssc_exam,
            R.drawable.ssc_exam,
            R.drawable.ssc_exam,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssc_chemistry);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.scc_chem_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.ssc_chem_all);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.scc_chem_list_view);
        MyListAdapter adapter = new MyListAdapter(SSCChemistryActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(SSCChemistryActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}