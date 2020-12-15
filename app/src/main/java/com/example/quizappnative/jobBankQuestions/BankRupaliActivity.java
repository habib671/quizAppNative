package com.example.quizappnative.jobBankQuestions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;

public class BankRupaliActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1mhtpGtWjsHJxtGyPKOuVbyPaEiGSovmK/view?usp=sharing",
            "https://drive.google.com/file/d/1JRsRuWngI2LTd_ekyLCJU3f5gn2axPia/view?usp=sharing",
            "https://drive.google.com/file/d/10KafqgOpWpLnG1qpgAY9-K76_FAOq82q/view?usp=sharing",
            "https://drive.google.com/file/d/1c98FlkOCsb9bF3xhqEEyWhTVOKhzo_SN/view?usp=sharing",
    };

    private final String[] names = {
            "Rupali Bank 2019",
            "Rupali Bank Cash 2018",
            "Rupali Bank SO 2019",
            "Rupali Bank 2019",
    };

    private final int[] image = {
            R.drawable.rupali_bank,
            R.drawable.rupali_bank,
            R.drawable.rupali_bank,
            R.drawable.rupali_bank,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_rupali);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.bank_rup_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.rupali_bank);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.bank_rup_list_view);
        MyListAdapter adapter = new MyListAdapter(BankRupaliActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BankRupaliActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });

    }
}