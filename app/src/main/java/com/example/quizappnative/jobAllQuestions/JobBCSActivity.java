package com.example.quizappnative.jobAllQuestions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.WebViewActivity;
import com.example.quizappnative.adapterModels.MyListAdapter;

import java.util.Objects;

public class JobBCSActivity extends AppCompatActivity {

    private final String[] links = {
            "https://drive.google.com/file/d/1IeZvjufZYphmkwuZaDapt4HBla4dRFw4/view?usp=drivesdk",
            "https://drive.google.com/file/d/1-IIJO5LG_iufkuCuavTWuojWy7jXgSmh/view?usp=drivesdk",
            "https://drive.google.com/file/d/1eaFFqdR76UsH5n06oOYDXhfEhCcxs3SP/view?usp=drivesdk",
            "https://drive.google.com/file/d/1m6rSSoDd23Kj-mj_hAC-M9cfFhR4WOXs/view?usp=drivesdk",
            "https://drive.google.com/file/d/1RtFzdULvgUNAUoW6OKJN5wt5D1SJvvcW/view?usp=drivesdk",
            "https://drive.google.com/file/d/12qnQAu1qkLH9tolcGjtq1bqsWXm7Tbbe/view?usp=drivesdk",
            "https://drive.google.com/file/d/1XbapS5BHX4cxXMpuYFuspCI5yGnz60HH/view?usp=drivesdk",
            "https://drive.google.com/file/d/1fdeirU5qa2O2z4ItCJUwdCJ81ho5wduO/view?usp=drivesdk",
            "https://drive.google.com/file/d/1foljU5bcp96xXIfWRijhefOuzYJI8AAZ/view?usp=drivesdk",
            "https://drive.google.com/file/d/10JQAl24fe-Yxn5BOjTYXR7qaX_49BtJ2/view?usp=drivesdk",
            "https://drive.google.com/file/d/1JMwBH-s0wPQ8lA7uWKo5xyBOOv0CkPmi/view?usp=drivesdk",
            "https://drive.google.com/file/d/1EJxKWweEmRF8J3AHpy6izuRCgKInb7im/view?usp=drivesdk",
            "https://drive.google.com/file/d/1USfNjgfm5LBjjdcUOoP9cQymiEyUC3xU/view?usp=drivesdk",
            "https://drive.google.com/file/d/1IlKHa0HQX8m8ZmZg4pKuxKUYirJvCRiA/view?usp=drivesdk",
            "https://drive.google.com/file/d/1mAX1Pj2HSVSzsD2E4Dr-1DwCGReHwqKg/view?usp=drivesdk",
            "https://drive.google.com/file/d/10YOS66JdGs_0Lw71QzU_2fNmwtt37qUb/view?usp=drivesdk",
            "https://drive.google.com/file/d/1ioAuX02eFVeDSrxI2uG1ZqVE0pInNBtT/view?usp=drivesdk",
            "https://drive.google.com/file/d/1qucojtrvXSnwsf74QJc2D5Fd9mXm3wj6/view?usp=drivesdk",
            "https://drive.google.com/file/d/1svHY1z-F3OhhT-w9tbQ4PChqMpu729_j/view?usp=drivesdk",
            "https://drive.google.com/file/d/1OgmmxZCZU6sgpH3M99tXnNJ-zYaulloj/view?usp=drivesdk",
            "https://drive.google.com/file/d/1xoX8CoVAh0Zf_D01pWEB9SbKCvPvo9ux/view?usp=drivesdk",
            "https://drive.google.com/file/d/1ID3EhRZ2RkfI5_aBKUamRULdavc0btDo/view?usp=drivesdk",
            "https://drive.google.com/file/d/1iOUHQuTxGyOO0HfsPPX8uX8tJKUsp9Uc/view?usp=drivesdk",
            "https://drive.google.com/file/d/1_DCPHeTxRFeq8uEzGIUZgNZ7_bUI-EZH/view?usp=drivesdk",
            "https://drive.google.com/file/d/1lIrmKDhL-3rlaIIwwBKAHqeP2d6h5qVe/view?usp=drivesdk",
            "https://drive.google.com/file/d/1Z5rOn0Lu_mAvfiQLaMzQWGKek4GT5G3B/view?usp=drivesdk",
            "https://drive.google.com/file/d/1dEpHGyrcp956YF2WwDbrAy26BEQc5GL6/view?usp=drivesdk",
            "https://drive.google.com/file/d/1UIuD85DuBLguPmJLWQ8LVZGJR9GRODFB/view?usp=drivesdk",
            "https://drive.google.com/file/d/1Whtad0i68yk1kLxm9tLwgR5zpAM3pl_K/view?usp=drivesdk",
            "https://drive.google.com/file/d/1p5ny5y9kwE7vyhhGTbD_ZqA6GuG3W2vW/view?usp=drivesdk",

    };

    private final String[] names = {
            " BCS 10",
            " BCS 11",
            " BCS 12",
            " BCS 13",
            " BCS 14",
            " BCS 15",
            " BCS 16",
            " BCS 17",
            " BCS 18",
            " BCS 19",
            " BCS 20",
            " BCS 21",
            " BCS 22",
            " BCS 23",
            " BCS 24",
            " BCS 25",
            " BCS 26",
            " BCS 27",
            " BCS 28",
            " BCS 29",
            " BCS 30",
            " BCS 31",
            " BCS 32",
            " BCS 33",
            " BCS 34",
            " BCS 35",
            " BCS 36",
            " BCS 37",
            " BCS 38",
            " BCS 39",
    };

    private final int[] image = {
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
            R.drawable.office_meeting,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcs_job);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.bcs_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.bcs);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up List view
        ListView listView = findViewById(R.id.bcs_list_view);
        MyListAdapter adapter = new MyListAdapter(JobBCSActivity.this, image, names, links);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(JobBCSActivity.this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.NAME_KEY, names[position]);
            intent.putExtra(WebViewActivity.LINK_KEY, links[position]);
            startActivity(intent);
        });
    }
}