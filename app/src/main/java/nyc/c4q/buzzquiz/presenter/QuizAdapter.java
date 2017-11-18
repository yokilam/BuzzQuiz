package nyc.c4q.buzzquiz.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

import nyc.c4q.buzzquiz.ChoiceListener;
import nyc.c4q.buzzquiz.R;
import nyc.c4q.buzzquiz.model.Quiz;
import nyc.c4q.buzzquiz.view.QuizViewHolder;

/**
 * Created by yokilam on 11/15/17.
 */

public class QuizAdapter extends RecyclerView.Adapter<QuizViewHolder> {
    private List<Quiz> quizList;

    private ChoiceListener choiceListener;

    public QuizAdapter(List<Quiz> quizList, ChoiceListener choiceListener) {
        this.quizList = quizList;
        this.choiceListener = choiceListener;
    }

    @Override
    public QuizViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quiz_itemview, parent, false);

        return new QuizViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(QuizViewHolder holder, final int position) {
        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);

                if (checkedRadioButton.isChecked()) {
                    choiceListener.onChoiceSelected(quizList.get(position), Integer.valueOf((String) checkedRadioButton.getTag()));
                }
            }
        });
        holder.onBind(quizList.get(position));
    }

    @Override
    public int getItemCount() {
        return quizList.size();
    }

    public void addItem(Quiz quiz) {
        quizList.add(quiz);
//        notifyDataSetChanged();
        notifyItemInserted(quizList.size() - 1);
    }
}
