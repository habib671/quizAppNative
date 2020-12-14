package com.example.quizappnative;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quizappnative.jobQuestions.AllBankJobsActivity;
import com.example.quizappnative.quizActivities.QuizCategoryActivity;
import com.example.quizappnative.readingMaterials.BooksBDStudyActivity;
import com.example.quizappnative.readingMaterials.BooksBanglaActivity;
import com.example.quizappnative.readingMaterials.BooksEnglishActivity;
import com.example.quizappnative.readingMaterials.BooksIntAffairActivity;
import com.example.quizappnative.readingMaterials.BooksMathsActivity;
import com.example.quizappnative.readingMaterials.BooksEngLiterActivity;
import com.example.quizappnative.sscQuestions.SSCMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_main_activity);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
    }

    //Setting menu for Actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            openSearch();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    //Launching other activities
    private void openSearch() {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
    }

    public void openQuiz(View view) {
        Intent intent = new Intent(MainActivity.this, QuizCategoryActivity.class);
        startActivity(intent);
    }

    public void openSSCQuestions(View view) {
        Intent intent = new Intent(MainActivity.this, SSCMainActivity.class);
        startActivity(intent);
    }

    public void openHSCQuestions(View view) {
        //Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        //startActivity(intent);
    }

    public void openAdmissionQuestions(View view) {
        //Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        //startActivity(intent);
    }


    public void openBCSQuestions(View view) {
        //Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        //startActivity(intent);
    }

    public void openBanksQuestions(View view) {
        Intent intent = new Intent(MainActivity.this, AllBankJobsActivity.class);
        startActivity(intent);
    }

    public void openGovtJobsQuestions(View view) {
        //Intent intent = new Intent(MainActivity.this, JobsGovtQuesActivity.class);
        //startActivity(intent);
    }

    public void openCSEJobsQuestions(View view) {
        //Intent intent = new Intent(MainActivity.this, JobsCSEQuesActivity.class);
        //startActivity(intent);
    }

    public void openEEEJobsQuestions(View view) {
        //Intent intent = new Intent(MainActivity.this, JobsEEEQuesActivity.class);
        //startActivity(intent);
    }

    public void openBengaliBooks(View view) {
        Intent intent = new Intent(MainActivity.this, BooksBanglaActivity.class);
        startActivity(intent);
    }

    public void openEnglishBooks(View view) {
        Intent intent = new Intent(MainActivity.this, BooksEnglishActivity.class);
        startActivity(intent);
    }

    public void openMathBooks(View view) {
        Intent intent = new Intent(MainActivity.this, BooksMathsActivity.class);
        startActivity(intent);
    }

    public void openBDBooks(View view) {
        Intent intent = new Intent(MainActivity.this, BooksBDStudyActivity.class);
        startActivity(intent);
    }

    public void openEngLiteratureBooks(View view) {
        Intent intent = new Intent(MainActivity.this, BooksEngLiterActivity.class);
        startActivity(intent);
    }

    public void openIntAffairsBooks(View view) {
        Intent intent = new Intent(MainActivity.this, BooksIntAffairActivity.class);
        startActivity(intent);
    }

    public void openGenKnwBooks(View view) {
        //Intent intent = new Intent(MainActivity.this, GKBooksActivity.class);
        //startActivity(intent);
    }

    public void openGeographyBooks(View view) {
        //Intent intent = new Intent(MainActivity.this, GeoBooksActivity.class);
        //startActivity(intent);
    }

    public void openNoitikotaBooks(View view) {
        //Intent intent = new Intent(MainActivity.this, NoitikotaBooksActivity.class);
        //startActivity(intent);
    }

    public void openMentalAbilityBooks(View view) {
        //Intent intent = new Intent(MainActivity.this, MetalAbilityBooksActivity.class);
        //startActivity(intent);
    }

    public void openComputerITBooks(View view) {
        //Intent intent = new Intent(MainActivity.this, ComputerITBooksctivity.class);
        //startActivity(intent);
    }

    public void openBoardBooks(View view) {
        //Intent intent = new Intent(MainActivity.this, BoardBooksctivity.class);
        //startActivity(intent);
    }

    public void openLargeBooks(View view) {
        //Intent intent = new Intent(MainActivity.this, LargeBooksActivity.class);
        //startActivity(intent);
    }

    public void openMixedBooks(View view) {
        //Intent intent = new Intent(MainActivity.this, MixedBooksctivity.class);
        //startActivity(intent);
    }
    //Launching other activities

}
