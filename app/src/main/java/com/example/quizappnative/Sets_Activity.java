package com.example.quizappnative;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.print.PrinterId;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class Sets_Activity extends AppCompatActivity {

    private GridView setsGridView;
    private FirebaseFirestore firestore;
    public static int category_id;
    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets_);

        Toolbar toolbar = findViewById(R.id.setToolbar);
        setSupportActionBar(toolbar);

        String title = getIntent().getStringExtra("CATEGORY");
        category_id = getIntent().getIntExtra("CATEGORY_ID",1);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setsGridView = findViewById(R.id.setsGridView);

        loadingDialog = new Dialog(Sets_Activity.this);
        loadingDialog.setContentView(R.layout.loading_progress_bar);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.progress_background);
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingDialog.show();

        firestore = FirebaseFirestore.getInstance();

        loadSets();

        /*setsAdapterClass adapterClass = new setsAdapterClass(6);
        setsGridView.setAdapter(adapterClass);*/

    }
    //firebase theke num of set load korbe
    private void loadSets(){
        firestore.collection("Quiz").
                document("CAT" + String.valueOf(category_id))
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();

                    if (doc.exists()) {

                        long sets = (long) doc.get("SETS");
                        setsAdapterClass adapterClass = new setsAdapterClass((int) sets);
                        setsGridView.setAdapter(adapterClass);

                    } else {
                        Toast.makeText(Sets_Activity.this, "No CAT Document Exists", Toast.LENGTH_LONG).show();
                        finish();
                    }
                } else {
                    Toast.makeText(Sets_Activity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
                loadingDialog.cancel();
            }
                });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Sets_Activity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}