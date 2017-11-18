package nyc.c4q.buzzquiz.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;

import nyc.c4q.buzzquiz.ChoiceListener;
import nyc.c4q.buzzquiz.QuizTwo;
import nyc.c4q.buzzquiz.presenter.QuizAdapter;
import nyc.c4q.buzzquiz.QuizOne;
import nyc.c4q.buzzquiz.R;
import nyc.c4q.buzzquiz.model.Quiz;
import nyc.c4q.buzzquiz.util.ScoreConverter;
import nyc.c4q.buzzquiz.util.ScoreConverter2;

public class QuizActivity extends AppCompatActivity implements ChoiceListener {
    private ArrayList<Quiz> quizList;

    private QuizAdapter quizAdapter;

    private int score;

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView topicQuestion= findViewById(R.id.topic);

        Intent intent= getIntent();
        int quizSelected= intent.getIntExtra("quiz", 0);
        String topic = intent.getStringExtra("topic");

        quizList = new ArrayList<>();
        if (quizSelected == 1) {
            quizList.add(new Quiz(QuizOne.choiceOne[0], QuizOne.choiceTwo[0], QuizOne.picture[0]));
            topicQuestion.setText(topic);
        } else {
            quizList.add(new Quiz(QuizTwo.choiceOne[0], QuizTwo.choiceTwo[0], QuizTwo.picture[0]));
            topicQuestion.setText(topic);
        }


        RecyclerView quizRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        quizAdapter = new QuizAdapter(quizList, this);
        quizRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        quizRecyclerView.setAdapter(quizAdapter);
    }

    @Override
    public void onChoiceSelected(Quiz quiz, int choice) {
        Intent intent= getIntent();
        int quizSelected= intent.getIntExtra("quiz", 0);
        String message = choice == 1 ? quiz.getChoiceOne() : quiz.getChoiceTwo();
        if(quizSelected==1) {

            if (quizList.size() < QuizOne.choiceOne.length) {
                int n = quizList.size();
                quizAdapter.addItem(new Quiz(QuizOne.choiceOne[n], QuizOne.choiceTwo[n], QuizOne.picture[n]));

                if (choice == 1) {
                    score++;
                    Log.e("score: ", "" + score);
                } else {
                    score--;
                    Log.e("score: ", "" + score);
                }
            } else {
                showResult(score);
            }
            Log.e("testing", message + choice);
        } else if(quizSelected == 2){

            if (quizList.size() < QuizTwo.choiceOne.length) {
                int n = quizList.size();
                quizAdapter.addItem(new Quiz(QuizTwo.choiceOne[n], QuizTwo.choiceTwo[n], QuizTwo.picture[n]));

                if (choice == 1) {
                    score++;
                    Log.e("score: ", "" + score);
                } else {
                    score--;
                    Log.e("score: ", "" + score);
                }
            } else {
                showResult(score);
                score=0;
            }
            Log.e("testing", message + choice);
        }
    }

    public void showResult(int score) {
        AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
        LayoutInflater inflater = QuizActivity.this.getLayoutInflater();

        builder.setMessage("Your result is: ");

        builder.setView(inflater.inflate(R.layout.activity_alertdialog, null))
                .setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        quizList.clear();
                        Intent intent= new Intent(QuizActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        resultTextView = dialog.findViewById(R.id.result_view);

        Intent intent= getIntent();
        int quizSelected= intent.getIntExtra("quiz", 0);
        if(quizSelected== 1){
            String result = ScoreConverter.converterScore(score);
            resultTextView.setText(result);
        } else {
            Log.e("score", ""+score);
            String result = ScoreConverter2.converterScore(score);
            resultTextView.setText(result);
        }

        //String result = ScoreConverter.converterScore(score);
        //resultTextView.setText(result);
    }
}

