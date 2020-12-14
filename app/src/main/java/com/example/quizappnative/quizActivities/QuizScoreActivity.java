package com.example.quizappnative.quizActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizappnative.MainActivity;
import com.example.quizappnative.R;

public class QuizScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);

        TextView scoreTV = findViewById(R.id.scoreTV);
        Button done = findViewById(R.id.doneTV);

        String score_str = getIntent().getStringExtra("SCORE");
        scoreTV.setText(score_str);

        done.setOnClickListener(view -> {
            Intent intent = new Intent(QuizScoreActivity.this, MainActivity.class);
            QuizScoreActivity.this.startActivity(intent);
            QuizScoreActivity.this.finish();
        });
    }
}