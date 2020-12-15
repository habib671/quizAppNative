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

public class BooksEnglishActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1R7PjLD94aiVzy_2WOy8DOyIj_RyUQVUY/view?usp=sharing",
            "https://drive.google.com/file/d/1lC_YYbtjZ3h3WZ8cEUO_U9j6pUogJdc9/view?usp=sharing",
            "https://drive.google.com/file/d/1mIRnOnTsLepN4qFA0sKTyeq0Sblc4EDx/view?usp=sharing",
            "https://drive.google.com/file/d/1xEz96sv0ECGe7KcTggSRDN0hc4LepBx5/view?usp=sharing",
            "https://drive.google.com/file/d/1uiX5TbTPdXMWrsIuiqvRfiAys45jXxsO/view?usp=sharing",
            "https://drive.google.com/file/d/1pynM7EhYMwQFuGKjI9Y5wB2JuVp9RMwu/view?usp=sharing",
            "https://drive.google.com/file/d/1Y3AefOHRzNyXGLUIc9mHWBSyql0vc0mv/view?usp=sharing",
            "https://drive.google.com/file/d/11CoTipwsxLQIVwberlS115yS6bRVAM6E/view?usp=sharing",
            "https://drive.google.com/file/d/1yyKq2OoUhf0UNo42-a1fSFTWIC6htsMi/view?usp=sharing",
            "https://drive.google.com/file/d/17jMKJlxtlqWjMzU6anwL-SztI5lm6ksA/view?usp=sharing",
            "https://drive.google.com/file/d/1n0Odb2rleDRBtJTwjpemZSImxSxJUjX-/view?usp=sharing",
            "https://drive.google.com/file/d/1UHFC5DdfPV3yS7pJENiWInkz0vFO9AUa/view?usp=sharing",
            "https://drive.google.com/file/d/1UDIbLwZOBwXnp7ZZW2nVDAOPe9N9_KHw/view?usp=sharing",
            "https://drive.google.com/file/d/1XWJzPC0DHL6OZIQWS-dEvcLo1B6ebLoX/view?usp=sharing",
            "https://drive.google.com/file/d/1PsgvZUGVpMo90CY5rhg5FE07VfwSpE4e/view?usp=sharing",
            "https://drive.google.com/file/d/1MgcyvK3eap9uOO3VfNBHhfP2Feg1Ro6b/view?usp=sharing",
            "https://drive.google.com/file/d/19SJkfYugJ5dzdiLrNMwcvR62VFAqMGeV/view?usp=sharing",
            "https://drive.google.com/file/d/1PCQ536dIVPgGFB-928ynEQAGyZ6Uee2C/view?usp=sharing",
            "https://drive.google.com/file/d/1SYlqhL7ttb6nMrwcteX8h1H6HTdpDX5X/view?usp=sharing",
            "https://drive.google.com/file/d/1GXGRc0x7Aep_sOla0dVt499zQzE-HvMK/view?usp=sharing",
    };

    private final String[] names = {
            "Mnemonic Vocabulary by Maker's",
            "Barrons TOEFL Selected Ques",
            "Saifurs Hard Vocabulary",
            "35 BCS Professor English",
            "A Systemic Approach to Critical Reasoning & Analytical",
            "Barrons Mnemonics",
            "Common Mistakes in English",
            "MP3 English Review",
            "Oracle English",
            "Saifurs Spoken Vocabulary",
            "Saifurs Analogy",
            "Silent Letters in English Words",
            "Students Favourite English Grammar",
            "Word Smart Part 1+2",
            "1100 Words BCS",
            "Faculty Based Job English",
            "GRE Big Book",
            "Mnemonic Vocabulary Book",
            "Oracle Vocabulary with Mnemonic",
            "Sushanto Paul English Note"

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
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
            R.drawable.flat,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_english);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.english_books_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.english_books);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.english_books_list_view);
        MyListAdapter adapter = new MyListAdapter(BooksEnglishActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BooksEnglishActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });
    }
}