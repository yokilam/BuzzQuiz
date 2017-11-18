package nyc.c4q.buzzquiz.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import nyc.c4q.buzzquiz.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView quizTwoImage = findViewById(R.id.quizTwo_image);

        Picasso.with(getApplicationContext())
                .load("http://static.magiquiz.com/wp-content/uploads/2015/09/nerd-geek-dork-feature-806x421.jpg")
//                .resize(
//                        300,300)
                .into(quizTwoImage);

        final Intent intent = new Intent(this, QuizActivity.class);
        Button quizOne = findViewById(R.id.quiz01);
        Button quizTwo = findViewById(R.id.quiz02);

        quizOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("quiz", 1);
                intent.putExtra("topic", "What dessert are you?");
                startActivity(intent);

            }
        });

        quizTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("quiz", 2);
                intent.putExtra("topic", "Dork, Nerd or Geek?");
                startActivity(intent);
            }
        });
    }
}
