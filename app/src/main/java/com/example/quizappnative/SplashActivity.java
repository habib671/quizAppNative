package com.example.quizappnative;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

    public static List<String> catList = new ArrayList<>(); //This list will fetched from firebase
    private FirebaseFirestore fireStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView appName = findViewById(R.id.appName);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.blacklist);
        appName.setTypeface(typeface);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.myanim);
        appName.setAnimation(anim);

        fireStore = FirebaseFirestore.getInstance();
        new Thread(this::loadData).start();

    }

    private void loadData() {
        catList.clear();
        fireStore.collection("Quiz").
                document("Categories")
                .get().addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        DocumentSnapshot doc = task.getResult();
                        assert doc != null;
                        if (doc.exists()) {
                            long count = (long) doc.get("COUNT");
                            for (int i = 1; i <= count; i++) {
                                String categoryName = doc.getString("CAT" + i);
                                catList.add(categoryName);
                            }
                            //after fetching all the categories then we will intend to start quiz activity
                            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(SplashActivity.this, "No Category Document Exists", Toast.LENGTH_LONG).show();
                        }
                        SplashActivity.this.finish();
                    } else {
                        Toast.makeText(SplashActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}