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

public class SSCBusinessInitActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1HEg9903_jEJTGXAAQyWdEQ0w-lNnsI22/view?usp=sharing",
            "https://drive.google.com/file/d/1_K_vrXmAhjupx7t1BwsdZEunrkHEvqQU/view?usp=sharing",
            "https://drive.google.com/file/d/1wom1y6uo-trbV4du733deBkGVibzTVlI/view?usp=sharing",
            "https://drive.google.com/file/d/10_o76oR6fHe2C0TyJ5kjCMXWOljLWCkX/view?usp=sharing",
            "https://drive.google.com/file/d/15ws2j-TK_1z2FSb1FaIDwhwiXGCEIqu3/view?usp=sharing",
    };

    private final String[] names = {
            "Business Initiative 2015",
            "Business Initiative 2016",
            "Business Initiative 2017",
            "Business Initiative 2018",
            "Business Initiative 2019",
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
        setContentView(R.layout.activity_ssc_business_init);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.scc_bis_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.ssc_biuini_all);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.scc_bis_list_view);
        MyListAdapter adapter = new MyListAdapter(SSCBusinessInitActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(SSCBusinessInitActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}