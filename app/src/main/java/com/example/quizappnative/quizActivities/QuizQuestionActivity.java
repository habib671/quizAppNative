package com.example.quizappnative.quizActivities;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizappnative.R;
import com.example.quizappnative.adapterModels.QuizQuestionModel;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.quizappnative.quizActivities.QuizSetsActivity.category_id;

public class QuizQuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question, qCount, timer;
    private Button option1,option2,option3,option4;
    private List<QuizQuestionModel> questionList;
    private int quesNum;
    private  CountDownTimer countDownTimer;
    private int score;
    private FirebaseFirestore fireStore;
    private int setNo;
    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        question = findViewById(R.id.question);
        qCount = findViewById(R.id.qCount);
        timer = findViewById(R.id.timer);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        option1.setOnClickListener(this);
        option2. setOnClickListener( this);
        option3.setOnClickListener(this);
        option4.setOnClickListener( this);

        loadingDialog= new Dialog((QuizQuestionActivity.this));
        loadingDialog.setContentView(R.layout.quiz_loading_progress_bar);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.round_corner);
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingDialog.show();

        setNo = getIntent().getIntExtra("SETNO",1);
        fireStore = FirebaseFirestore.getInstance();

        getQuestionList();
        score=0;
    }
    private void getQuestionList(){
        questionList = new ArrayList<>();
       /* questionList.add(new Question("What is android view group?","A - Collection of views and other child views", "B - Base class of building blocks","C - Layouts","D - None of the Above",1));
        questionList.add(new Question("What is the application class in android?","A - A class that can create only an object", "B - Anonymous class","C - Java class","D - Base class for all classes",4));
        questionList.add(new Question("Parent class of Activity?","A-object?", "B-contentView","C-viewGroup","D-contextThemeWrapper",4));
        questionList.add(new Question("What are the indirect Direct subclasses of Activity?","A-launcherActivity", "B-preferenceActivity","C- tabActivity","D-all of the above",4));
        questionList.add(new Question("Which component is not activated by an Intent?","A-activity", "B-services","C-contentProvider","D-broadcastReceiver",3));
*/

        fireStore.collection("Quiz").document("CAT" + category_id)
               .collection("SET" + setNo)
               .get().addOnCompleteListener(task -> {
                   if (task.isSuccessful()) {
                       QuerySnapshot questions = task.getResult();
                       assert questions != null;
                       for (QueryDocumentSnapshot doc : questions) {
                           questionList.add(new QuizQuestionModel(doc.getString("QUESTION"),
                                   doc.getString("A"),
                                   doc.getString("B"),
                                   doc.getString("C"),
                                   doc.getString("D"),
                                   Integer.parseInt(Objects.requireNonNull(doc.getString("ANSWER")))
                           ));
                       }
                       setQuestion();

                   }

                   else {
                       Toast.makeText(QuizQuestionActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                   }
                   loadingDialog.cancel();

               });

    }
    private  void setQuestion(){
        timer.setText(String.valueOf(10));
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOptionA());
        option2.setText(questionList.get(0).getOptionB());
        option3.setText(questionList.get(0).getOptionC());
        option4.setText(questionList.get(0).getOptionD());

        qCount.setText(1 +"/"+ questionList.size());

        startTimer();
        quesNum=0;

    }
    private  void startTimer(){
        countDownTimer = new CountDownTimer(12000,1000) {
            @Override
            public void onTick(long l) {
                if(l < 10000 )
                timer.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                changeQuestion();
            }
        };
        countDownTimer.start();
    }
    public void onClick(View v){
        int selectedOption = 0;
        switch(v.getId()){
            case R.id.option1:
                selectedOption=1;
                break;
            case R.id.option2:
                selectedOption=2;
                break;
            case R.id.option3:
                selectedOption=3;
                break;
            case R.id.option4:
                selectedOption=4;
                break;
            default:
        }
        countDownTimer.cancel();
        checkAnswer(selectedOption,v);
    }
    private void checkAnswer(int selectedOption,View view){

        if(selectedOption == questionList.get(quesNum).getCorrectAns()){
            //RIght answer
            view.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            score += 1;
            System.out.println(score);
        }
        else{
            //wrong answer
            view.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            switch ((questionList.get(quesNum).getCorrectAns())){
                case 1:
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3:
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4:
                    option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
            }
        }
        Handler handler = new Handler();
        handler.postDelayed(this::changeQuestion,2000);

    }

    private void changeQuestion(){
        if(quesNum < questionList.size() -1){
            //last ques eta
            quesNum++;
            playAnim(question,0,0);
            playAnim(option1,0,1);
            playAnim(option2,0,2);
            playAnim(option3,0,3);
            playAnim(option4,0,4);

            qCount.setText((quesNum + 1) + "/"+ questionList.size());
            timer.setText(String.valueOf(10));
            startTimer();
        }
        else{
            //score activity te niye jabe-go to score activity
            Intent intent = new Intent(QuizQuestionActivity.this, QuizScoreActivity.class);
            intent.putExtra("SCORE", score + "/" + questionList.size());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //clear all the prev activity (back hobena)
            startActivity(intent);
            QuizQuestionActivity.this.finish();
        }
    }
    private void playAnim(final View view, final int value, final int viewNum){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100).
                setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if(value==0){
                    switch (viewNum){
                        case 0:
                            ((TextView) view).setText(questionList.get(quesNum).getQuestion());
                            break;
                        case 1:
                            ((Button)view).setText(questionList.get(quesNum).getOptionA());
                            break;
                        case 2:
                            ((Button)view).setText(questionList.get(quesNum).getOptionB());
                            break;
                        case 3:
                            ((Button)view).setText(questionList.get(quesNum).getOptionC());
                            break;
                        case 4:
                            ((Button)view).setText(questionList.get(quesNum).getOptionD());
                            break;
                    }
                    if(viewNum !=0 ){
                        view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#F5F5F5")));
                    }

                    playAnim(view,1,viewNum);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countDownTimer.cancel();
    }
}