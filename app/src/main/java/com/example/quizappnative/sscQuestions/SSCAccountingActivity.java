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

public class SSCAccountingActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1MRgjtDnuYPFCmse_HC__MA30jIudxeZ8/view?usp=sharing",
            "https://drive.google.com/file/d/1QgihYAg7b8wESZGulZFH5Up9fvBKzLwA/view?usp=sharing",
            "https://drive.google.com/file/d/1wyDUR6TinxRzL-27ydhLYFCny9683oU8/view?usp=sharing",
            "https://drive.google.com/file/d/17ax8t0gzcYJmoNFEbksQysamvpv30oPd/view?usp=sharing",
            "https://drive.google.com/file/d/1yjQUzrYKkTDqxVyGagYS4tAkke4K-98C/view?usp=sharing",
    };

    private final String[] names = {
            "Accounting 2015",
            "Accounting 2016",
            "Accounting 2017",
            "Accounting 2018",
            "Accounting 2019",
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
        setContentView(R.layout.activity_ssc_accounting);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.scc_accounting_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.ssc_acc_all);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.scc_accounting_list_view);
        MyListAdapter adapter = new MyListAdapter(SSCAccountingActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(SSCAccountingActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}