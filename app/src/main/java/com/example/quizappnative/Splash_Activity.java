package com.example.quizappnative;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Splash_Activity extends AppCompatActivity {

    private TextView appName;
    public static List<String> catList = new ArrayList<>(); //firebase theke ei list a fetc hbe
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

        appName = findViewById(R.id.appName);
        Typeface typeface = ResourcesCompat.getFont(this,R.font.blacklist);
        appName.setTypeface(typeface);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.myanim);
        appName.setAnimation(anim);

        firestore = FirebaseFirestore.getInstance();

        new Thread(new Runnable() {
            @Override
            public void run() {
          /*      try {
                    //sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                loadData();
                /*Intent intent = new Intent(Splash_Activity.this,MainActivity.class);
                startActivity(intent);
                Splash_Activity.this.finish();*/
            }
        }).start();

    }
    private void loadData(){
        catList.clear();
        firestore.collection("Quiz").
                document("Categories")
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot doc = task.getResult();
                    if (doc.exists()){
                        long count =(long) doc.get("COUNT");
                        for(int i=1 ; i <= count; i++){
                            String categoryName = doc.getString("CAT" + String.valueOf(i));
                            catList.add(categoryName);
                        }
                        //after fetching all the categories then we will intend to start quiz activity
                        Intent intent = new Intent(Splash_Activity.this,MainActivity.class);
                        startActivity(intent);
                        Splash_Activity.this.finish();

                    }
                    else{
                        Toast.makeText(Splash_Activity.this,"No Category Document Exists",Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
                else
                {
                    Toast.makeText(Splash_Activity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}