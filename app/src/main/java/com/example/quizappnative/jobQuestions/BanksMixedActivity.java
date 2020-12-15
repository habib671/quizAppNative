package com.example.quizappnative.jobQuestions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;

public class BanksMixedActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1aIuRMGhTy2xcPcsZlVWqKYlFDUVQsr1l/view?usp=sharing",
            "https://drive.google.com/file/d/1dvtY9_kkYAfKNu53eSII2yKCSJmiEp3N/view?usp=sharing",
            "https://drive.google.com/file/d/12RIYj4epxtH4Vg_p5xGEE2E-p9W6XPu0/view?usp=sharing",
            "https://drive.google.com/file/d/16XV1cRzjYYZsY50bRVUJn66khPQFnljK/view?usp=sharing",
            "https://drive.google.com/file/d/196SmznAoBx30KOw9cZws90dCs6y3UiZF/view?usp=sharing",
            "https://drive.google.com/file/d/1ivx-2wLVH_PjCT_fDHDZLTZB35WnRqja/view?usp=sharing",
            "https://drive.google.com/file/d/1mYutj5PG_sCX4Wr0xkXbSaQ0vKsREX7P/view?usp=sharing",
            "https://drive.google.com/file/d/12zVb9ydMFid7pKI2_vjC4ojGgvo0twy8/view?usp=sharing",
            "https://drive.google.com/file/d/1Gm4n43T5VccpOhaejq34TsUkrmYV84JB/view?usp=sharing",
            "https://drive.google.com/file/d/1e35u2f8nbBEltAaote2Drk7kFD9nVGJw/view?usp=sharing",
            "https://drive.google.com/file/d/1jJnIntpIjQ4OJop_h2fTix2trPuahLDd/view?usp=sharing",
            "https://drive.google.com/file/d/1n1bzvOnJwBr-EzuVMLhNTi2fOcSXwv-i/view?usp=sharing",
            "https://drive.google.com/file/d/1NPu-L_r00ZySYLzFeOIL9kD9l6nkdRHG/view?usp=sharing",
            "https://drive.google.com/file/d/10UcoAj6Ue4t1oRvOHpyIV-Jnmn-gcbQj/view?usp=sharing",
            "https://drive.google.com/file/d/1BIlkpszaHTryQc2v__W61aSij1hlscPO/view?usp=sharing",
            "https://drive.google.com/file/d/1enW7t9_aLaLfChvdzNQkYNZ7CHD0PJOE/view?usp=sharing",
            "https://drive.google.com/file/d/1rFO4t4w-jWE-32zI4OeHDqIjJ_zNch_5/view?usp=sharing",
            "https://drive.google.com/file/d/1ocs_zk3xr2yuRcH6HGx-4pRg_bjidMcd/view?usp=sharing",
            "https://drive.google.com/file/d/12DOOvVKoGpqsfdMpBpL-A5aUOWHUpTs-/view?usp=sharing",
            "https://drive.google.com/file/d/1x2EHXcrILAg0POael7ZbPLTBjz2xnNlA/view?usp=sharing",
    };

    private final String[] names = {
            "Arts Faculty Mixed Question",
            "Basic Bank AM 2018",
            "Basic Bank General 2018",
            "BDBL SO 2017",
            "EXIM Bank 2020",
            "BKB Cash 2017",
            "IFIC MTO 2018",
            "IFIC TAO 2018",
            "IFIC TSO 2019",
            "Meghna Bank MTO 2017",
            "KRISHI Bank Cash 2017",
            "All in one Updated Question",
            "NB PBO 2017",
            "Pubali Bank So 2017",
            "Pubali Bank Cash 2017",
            "Premier Bank 2020",
            "One Bank SCO 2017",
            "Cash Officer Q&A 2016",
            "Cash Officer Written Solve",
            "EXIM Bank TAO 2018",
    };

    private final int[] image = {
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
            R.drawable.mixed_bank,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_mixed);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.bank_mx_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.miscellaneous);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.bank_mx_list_view);
        MyListAdapter adapter = new MyListAdapter(BanksMixedActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(BanksMixedActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.PDF_NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.DRIVE_LINK_URL_KEY, links[position]);
            startActivity(intent);
        });
    }
}