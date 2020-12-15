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

public class BooksMathsActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1-y-Ij-ggDaal7Ed51pYXmDTKGMVFxc-W/view?usp=sharing",
            "https://drive.google.com/file/d/1yW_CR-9WpFiohkgHhl92_ZZ_qXzk9Mrv/view?usp=sharing",
            "https://drive.google.com/file/d/1VQbImmY_si48x46KtEw3cRitZOJipvRD/view?usp=sharing",
            "https://drive.google.com/file/d/1HhZ4IaRDXuCHgECXmUXkJ83UtA22ypjz/view?usp=sharing",
            "https://drive.google.com/file/d/1ofRxzgv7N6DdQG53-c5AordaqxMrMNjY/view?usp=sharing",
            "https://drive.google.com/file/d/1pObLnqc-KJWbUf3KAMMiI7cfxr_aZvcR/view?usp=sharing",
            "https://drive.google.com/file/d/1VlRKMgHus-Hn1Rm9lIjlodCUJDicrnyO/view?usp=sharing",
            "https://drive.google.com/file/d/1w_hksml8QoK2y9LhL3orafDOl72pqYRs/view?usp=sharing",
            "https://drive.google.com/file/d/1JTDIhSNvXzxwGzby38bx4FvigGZuR9-P/view?usp=sharing",
            "https://drive.google.com/file/d/1bGMUDw9tyUgNa8AnpN3KrVFeT5qQc_Sn/view?usp=sharing",
    };

    private final String[] names = {
            "Faculty Based Bank Written",
            "Khairul's Advanced Math(Agarwal Selected Part)",
            "Khairul's Bank Written Math",
            "Khairul's Basic",
            "Khairul's Basic Mental Ability",
            "Oracle Math",
            "Oracle Mathematical Reasoning",
            "Professor's Gonit Special",
            "Saifurs Math",
            "Jemetik Songa"
    };

    private final int[] image = {
            R.drawable.math_logo,
            R.drawable.math_logo,
            R.drawable.math_logo,
            R.drawable.math_logo,
            R.drawable.math_logo,
            R.drawable.math_logo,
            R.drawable.math_logo,
            R.drawable.math_logo,
            R.drawable.math_logo,
            R.drawable.math_logo,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_maths);


        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.maths_books_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.math_books);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.maths_books_list_view);
        MyListAdapter adapter = new MyListAdapter(BooksMathsActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BooksMathsActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });
    }
}