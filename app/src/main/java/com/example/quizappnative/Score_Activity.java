package com.example.quizappnative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score_Activity extends AppCompatActivity {

    private TextView scoreTV;
    private Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_);

        scoreTV = findViewById(R.id.scoreTV);
        done = findViewById(R.id.doneTV);

        String score_str = getIntent().getStringExtra("SCORE");
        scoreTV.setText(score_str);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Score_Activity.this,MainActivity.class);
                Score_Activity.this.startActivity(intent);
                Score_Activity.this.finish();
            }
        });
    }
}