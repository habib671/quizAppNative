package com.example.quizappnative.admissionQuestins;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;


public class AdmissionBUETActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1gIFl7m10qJ8W434AgO98H5qEIrFwzIR3/view?usp=sharing",
            "https://drive.google.com/file/d/1Pa66vCe8AWRO7InC-82WlUcQvNvbSQ6h/view?usp=sharing",
            "https://drive.google.com/file/d/1ZWw1ArkQnBWW1iHbgAleQouV5AAssgOD/view?usp=sharing",
            "https://drive.google.com/file/d/1U7bYYG1xXfYbPWj6ueQ2tt81EPn83Og8/view?usp=sharing",
            "https://drive.google.com/file/d/1cUQd3DBBug3IcPT-b9qtJ80w6N6X9IKX/view?usp=sharing",
            "https://drive.google.com/file/d/1t0Ks_4FevpuilEcgocJkJ0skIW2Bgydg/view?usp=sharing",
            "https://drive.google.com/file/d/104PpOVHIKFGKut9f1KOG_5SmqV2Nqacn/view?usp=sharing",
            "https://drive.google.com/file/d/1SQUlCEiUu9GBRfzrkcUso8JumNanOQiS/view?usp=sharing",
            "https://drive.google.com/file/d/1kxEHb-bEBm_dc0i6ujpIR2HCm4aglNBx/view?usp=sharing",
            "https://drive.google.com/file/d/1mZu0m8QDrubO3V_oHPiqg-xchw4-e8b8/view?usp=sharing",
            "https://drive.google.com/file/d/1EazKxo9v_Q6LgXBciRybv-8-fS2_xAuR/view?usp=sharing",
            "https://drive.google.com/file/d/1eyDf-sc3vFTQ1Q8Ia9dbS-SGOkTy9YiS/view?usp=sharing",
            "https://drive.google.com/file/d/1MbJmP9JISpoLsBgtG1_a0XPHR3i73X0Z/view?usp=sharing",
    };

    private final String[] names = {
            "BUET 2005-06",
            "BUET 2006-07",
            "BUET 2007-08",
            "BUET 2008-09",
            "BUET 2009-10",
            "BUET 2010-11",
            "BUET 2011-12",
            "BUET 2012-13",
            "BUET 2013-14",
            "BUET 2015-16",
            "BUET 2016-17",
            "BUET 2017-18",
            "BUET 2018-19",
    };

    private final int[] image = {
            R.drawable.buet_logo,
            R.drawable.buet_logo,
            R.drawable.buet_logo,
            R.drawable.buet_logo,
            R.drawable.buet_logo,
            R.drawable.buet_logo,
            R.drawable.buet_logo,
            R.drawable.buet_logo,
            R.drawable.buet_logo,
            R.drawable.buet_logo,
            R.drawable.buet_logo,
            R.drawable.buet_logo,
            R.drawable.buet_logo,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_buet);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.buet_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.uni_buet);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.buet_list_view);
        MyListAdapter adapter = new MyListAdapter(AdmissionBUETActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(AdmissionBUETActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}