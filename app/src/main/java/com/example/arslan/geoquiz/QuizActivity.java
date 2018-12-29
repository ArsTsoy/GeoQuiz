package com.example.arslan.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    Button buttonNext, buttonPrevious, buttonTrue, buttonFalse;
    private TextView questionView;

    private int currentIndex = 0;

    private Question[] questionList = {
            new Question("fjhafkasf", true),
            new Question(this.getResources().getString(R.string.question_ocean), true),
//            new Question(this.getString(R.string.question_mideast), false),
//            new Question(getResources().getString(R.string.question_africa), false),
//            new Question(getResources().getString(R.string.question_kazakhstan), false)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        buttonNext = findViewById(R.id.nextButton);
        buttonPrevious = findViewById(R.id.previousButton);
        buttonTrue = findViewById(R.id.buttonTrue);
        buttonFalse = findViewById(R.id.buttonFalse);

        questionView = findViewById(R.id.question);

        Log.d("My Tag",String.valueOf(R.string.question_australia));
    }

    public void pressTrue(View view){
        checkAnswer(true);
        updateQuetion();
    }

    public void pressFalse(View view){
        checkAnswer(false);
        updateQuetion();
    }

    public void pressNext(View view){
        updateQuetion();
        Log.d("My Tag",String.valueOf(R.string.question_australia));
    }

    public void pressPrevious(View view){
        currentIndex = Math.abs((currentIndex - 1)%questionList.length);
    }


    private void updateQuetion(){
        currentIndex = (currentIndex + 1)%questionList.length;
        questionView.setText(questionList[currentIndex].getQuestion());
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = questionList[currentIndex].isAnswer();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.toast_true;
        } else {
            messageResId = R.string.toast_false;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }





}
