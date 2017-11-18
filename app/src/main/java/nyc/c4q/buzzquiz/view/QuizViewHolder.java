package nyc.c4q.buzzquiz.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import nyc.c4q.buzzquiz.R;
import nyc.c4q.buzzquiz.model.Quiz;

/**
 * Created by yokilam on 11/15/17.
 */

public class QuizViewHolder extends RecyclerView.ViewHolder {
    private ImageView quizImage;
    private RadioButton choiceOne;
    private RadioButton choiceTwo;
    public RadioGroup radioGroup;

    public QuizViewHolder(final View itemView) {
        super(itemView);

        quizImage = (ImageView) itemView.findViewById(R.id.imageView);
        choiceOne = (RadioButton) itemView.findViewById(R.id.choiceOne);
        choiceTwo = (RadioButton) itemView.findViewById(R.id.choiceTwo);
        radioGroup = (RadioGroup) itemView.findViewById(R.id.radioGroup);

//      Toast.makeText(itemView.getContext(), ""+ score, Toast.LENGTH_LONG).show();
    }

    //RadioGroup, setOnChecked on RadioGroup

    public void onBind(Quiz quiz) {
        choiceOne.setText(quiz.getChoiceOne());
        choiceTwo.setText(quiz.getChoiceTwo());
        quizImage.setImageResource(quiz.getImage());
    }
}
