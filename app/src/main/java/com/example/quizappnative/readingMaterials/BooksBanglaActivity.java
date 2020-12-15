package com.example.quizappnative.readingMaterials;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;

public class BooksBanglaActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1rpRllMwVuaF806RGkTJ-mJsvLKQzJe0c/view?usp=sharing",
            "https://drive.google.com/file/d/1N81N3cqczOAKbRqIIM_5Mi_dVEh1WCw5/view?usp=sharing",
            "https://drive.google.com/file/d/10w2VV2ztavMiFdi4sEkOEoMwiU9ovdH-/view?usp=sharing",
            "https://drive.google.com/file/d/1jcYF0gpHkB-JxVIgnfnpISUSqJvFdmR_/view?usp=sharing",
            "https://drive.google.com/file/d/1hUnI7_vi6X2VDBkemLtx6JCVfudjBWyH/view?usp=sharing",
            "https://drive.google.com/file/d/1eNjEd-lGgG7mR2XzcjJ-bBY24zvFowQA/view?usp=sharing",
            "https://drive.google.com/file/d/10eQ5leFEs5PrBunwOkjRY4AUwQoe9Vs2/view?usp=sharing",
            "https://drive.google.com/file/d/1n-_Y9sB7rKmZ4ozRxzXQyJbnew_ToLhS/view?usp=sharing",
            "https://drive.google.com/file/d/1Kjic_fceF5UE3rUcP0zYepaD6nhRYcIB/view?usp=sharing",
            "https://drive.google.com/file/d/19xeR5xYO9Fe78wIJkH70z19hLTisxZCj/view?usp=sharing",
            "https://drive.google.com/file/d/1uiYrtVw_brpoUkcB1bj2tRe0rE8bkTX7/view?usp=sharing",
            "https://drive.google.com/file/d/1Oe44Ra5wzmyZ8y8jdLeQfnVUjiU0zZ3G/view?usp=sharing",
            "https://drive.google.com/file/d/1Ddnbe28IDNY2v6Yh5QRKQyrswMP0Q3C4/view?usp=sharing",
            "https://drive.google.com/file/d/1HCzjYJWEvyOlqGaeLeI3p_-mLI_T4MXh/view?usp=sharing",
            "https://drive.google.com/file/d/1g5-677AIoDVIHl97uctPUhYFN_OPS-7k/view?usp=sharing",
            "https://drive.google.com/file/d/16E8VlmTk9g0cLlm6gkkDE5oRKZlZc5X8/view?usp=sharing",
    };

    private final String[] names = {
            "Mp3- Bnagla",
            "Bangla Cyclone",
            "Bangla Sahitto",
            "Digest Bangla Literature",
            "Oracle Bangla",
            "Professor Bangla",
           "Rabindra-Nazrul 600 MCQ",
           "ALL Prev Question From 11 Poets",
           "কবি সাহিত্যিকদের নিয়ে বি সি এস এ আসা প্রশ্ন",
           "Bangla Biddar System",
           "Charzapad A 2 Z",
           "Rabindranath Tagore",
           "Shikar by Mohsina Nazila",
           "Bangla sahitter Tothyo O Tricks",
           "Bangla Vasha o Sahitto Note",
           "Bangla Sahitto Hand Note",

    };

    private final int[] image = {
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_bangla);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.bengali_books_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.bengali_books);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.bengali_books_list_view);
        MyListAdapter adapter = new MyListAdapter(BooksBanglaActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BooksBanglaActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });
    }
}