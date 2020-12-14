package com.example.quizappnative.quizActivities;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.R;
import com.example.quizappnative.adapterModels.QuizSetsAdapter;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;


public class QuizSetsActivity extends AppCompatActivity {

    private GridView setsGridView;
    private FirebaseFirestore fireStore;
    public static int category_id;
    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_sets);

        Toolbar toolbar = findViewById(R.id.quiz_set_toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CATEGORY");
        category_id = getIntent().getIntExtra("CATEGORY_ID", 1);
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setsGridView = findViewById(R.id.setsGridView);

        loadingDialog = new Dialog(QuizSetsActivity.this);
        loadingDialog.setContentView(R.layout.quiz_loading_progress_bar);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.round_corner);
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingDialog.show();

        fireStore = FirebaseFirestore.getInstance();

        loadSets();

        /*setsAdapterClass adapterClass = new setsAdapterClass(6);
        setsGridView.setAdapter(adapterClass);*/

    }

    //firebase theke num of set load korbe
    private void loadSets() {
        fireStore.collection("Quiz").
                document("CAT" + category_id)
                .get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot doc = task.getResult();

                assert doc != null;
                if (doc.exists()) {

                    long sets = (long) doc.get("SETS");
                    QuizSetsAdapter adapterClass = new QuizSetsAdapter((int) sets);
                    setsGridView.setAdapter(adapterClass);

                } else {
                    Toast.makeText(QuizSetsActivity.this, "No CAT Document Exists", Toast.LENGTH_LONG).show();
                    finish();
                }
            } else {
                Toast.makeText(QuizSetsActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
            }
            loadingDialog.cancel();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            QuizSetsActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}