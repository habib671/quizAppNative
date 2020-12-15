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

public class AdmissionDhakaUniActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1UJiPmnbuXtsFi_tbO23rGTIoNx83nevZ/view?usp=sharing",
            "https://drive.google.com/file/d/1jSpif9_z5OGHlF8C0arh_VFL8JOykdv5/view?usp=sharing",
            "https://drive.google.com/file/d/1XO3w448fQfJebCQclLZdxbUXReOvtGzL/view?usp=sharing",
            "https://drive.google.com/file/d/1cEN3hdDv8h2P9DRGI-vNkzcMvHN7b1pI/view?usp=sharing",
            "https://drive.google.com/file/d/1JpMVp01Jyd8civvamkJYtdtYpt0lELhh/view?usp=sharing",
            "https://drive.google.com/file/d/1HtDpUSG9L9hpUwmn1msk6euOIEWoglwW/view?usp=sharing",
            "https://drive.google.com/file/d/1p8Nnbk4cIDZzThGTjHysDsgA4b7zf0_E/view?usp=sharing",
            "https://drive.google.com/file/d/1U4YKK6NWYZ3BbmXBXwox8AKvopEMFNZr/view?usp=sharing",
            "https://drive.google.com/file/d/1pReaSE1vXC5qdOh5GfYHvEl8VmGHwtRf/view?usp=sharing",
            "https://drive.google.com/file/d/1EzuGxoGgZXVkhVfi1llOdc5hrIFvkeLo/view?usp=sharing",
            "https://drive.google.com/file/d/17HCfhh5wIW57QhO2yEfHS9LGZ_ZOnBUj/view?usp=sharing",
            "https://drive.google.com/file/d/1Y63UYkOiwB1-rGkAS4W7OaZCZf84_D_2/view?usp=sharing",
            "https://drive.google.com/file/d/1p5JEZNCGxbhX_XsybaCvKSD_h-4OPXpd/view?usp=sharing",
            "https://drive.google.com/file/d/1mj6qRoDPxWcdSClEKBOJryQN0fdrYfdP/view?usp=sharing",
            "https://drive.google.com/file/d/1F2nqVOJ3GPLrGKvYxWTEWz2bN2iPa0VC/view?usp=sharing",
            "https://drive.google.com/file/d/1Y436J8kVbnLyP0MUM6WIPNyaSaza5DVw/view?usp=sharing",
            "https://drive.google.com/file/d/1r4Yn4K7AqYwjdviQzO3TQIffqSZOyfgc/view?usp=sharing",
            "https://drive.google.com/file/d/1WhSLb4IW5a3vT9-nWEzhCWyZpE25ymAn/view?usp=sharing",
            "https://drive.google.com/file/d/1FypYpBADoxpeVsj9uKoLbyuBPclnswxP/view?usp=sharing",
            "https://drive.google.com/file/d/1D72eguL8edrByenUky0qyI9fVhHveFZF/view?usp=sharing",
            "https://drive.google.com/file/d/1tjhO93NOuV3TYpyQH01N0XhKP2r8z0Om/view?usp=sharing",
            "https://drive.google.com/file/d/1mIXwcjBNOHBd_4nH9qU32ayJmuyOxtZo/view?usp=sharing",
            "https://drive.google.com/file/d/1I2SFhCWO9M3trGQFuefzdKYSk4US-qS9/view?usp=sharing",
            "https://drive.google.com/file/d/1134vFOpuoyUDBzYcTgK0jVtKJ_dSGWw_/view?usp=sharing",
            "https://drive.google.com/file/d/1SnxBNkRzO6hzWJZmhFpYTc6Dlrrgt3Xd/view?usp=sharing",
            "https://drive.google.com/file/d/14ni28pOtynkGcn7sPgl1laJfw1av_sJK/view?usp=sharing",
            "https://drive.google.com/file/d/1PdGYFhTGI-1v9PKJGZ6xwE08aANJEJ_Q/view?usp=sharing",
            "https://drive.google.com/file/d/11IBk9tQuxwsUprrjzuTzhmpxw6USJz9y/view?usp=sharing",
            "https://drive.google.com/file/d/1Eo0HBivTT_oeaedbIqkUnepjT-o76T6W/view?usp=sharing",
            "https://drive.google.com/file/d/1y_2rks36mZogig-JlssAwxjNtULE_pdc/view?usp=sharing",
            "https://drive.google.com/file/d/1rloGZlRELfjRJY5zo4a2KtE7zaHKlEmF/view?usp=sharing",
            "https://drive.google.com/file/d/1SiI34MjANiVXl9rhoGJuPbdidLWK5qWP/view?usp=sharing",
            "https://drive.google.com/file/d/1_NGMuL9XWKjqwZirGXOkzpo_eU-uBa2M/view?usp=sharing",
            "https://drive.google.com/file/d/1LiZ30m5EYbUPaVU5Iq9zAs0RAtZpXDxF/view?usp=sharing",
            "https://drive.google.com/file/d/1v_N3NzKJEn0QbhYwN4ojjD8MEpnD45QC/view?usp=sharing",
            "https://drive.google.com/file/d/1DJ_LLhLusiPF7yhIvDEzvjac-Y60wWTz/view?usp=sharing",
            "https://drive.google.com/file/d/1APuK6HzM-_VMt0-qpWkXs_bRkjdhHV2o/view?usp=sharing",
            "https://drive.google.com/file/d/1eR6zr_GZzSQWrkHAeFabwaDj6vuPF_YC/view?usp=sharing",
            "https://drive.google.com/file/d/11XfV_qgjKSgnrye049-9g33jgPnVRSvi/view?usp=sharing",
            "https://drive.google.com/file/d/1CdYTosb2eUN-wEFsmpZ6T5z8KWMO0Fto/view?usp=sharing",
            "https://drive.google.com/file/d/1pa0p7RNBkIvdWS0gy8eY7zH1Q8o7oQBk/view?usp=sharing",

    };

    private final String[] names = {
            "DU A unit 2009-10",
            "DU A unit 2010-11",
            "DU A unit 2011-12",
            "DU A unit 2012-13",
            "DU A unit 2013-14",
            "DU A unit 2014-15",
            "DU A unit 2015-16",
            "DU A unit 2016-17",
            "DU A unit 2017-18",
            "DU A unit 2018-19",
            "DU A unit 2019-20",
            "DU B unit 2010-11",
            "DU B unit 2011-12",
            "DU B unit 2012-13",
            "DU B unit 2013-14",
            "DU B unit 2014-15",
            "DU B unit 2015-16",
            "DU B unit 2016-17",
            "DU B unit 2017-18",
            "DU B unit 2018-19",
            "DU B unit 2019-20",
            "DU C unit 2006-07",
            "DU C unit 2010-11",
            "DU C unit 2011-12",
            "DU C unit 2012-13",
            "DU C unit 2013-14",
            "DU C unit 2014-15",
            "DU C unit 2015-16",
            "DU C unit 2016-17",
            "DU C unit 2017-18",
            "DU C unit 2018-19",
            "DU C unit 2019-20",
            "DU D unit 2010-11",
            "DU D unit 2011-12",
            "DU D unit 2012-13",
            "DU D unit 2013-14",
            "DU D unit 2014-15",
            "DU D unit 2016-17",
            "DU D unit 2017-18",
            "DU D unit 2018-19",
            "DU D unit 2019-20",
    };

    private final int[] image = {
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
            R.drawable.dhaka_univ_logo,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_du);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.du_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.uni_dhaka);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.du_list_view);
        MyListAdapter adapter = new MyListAdapter(AdmissionDhakaUniActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(AdmissionDhakaUniActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}