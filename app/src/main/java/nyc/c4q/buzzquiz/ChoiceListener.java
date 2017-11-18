package nyc.c4q.buzzquiz;

import nyc.c4q.buzzquiz.model.Quiz;

/**
 * Created by yokilam on 11/16/17.
 */

public interface ChoiceListener {
    void onChoiceSelected(Quiz quiz, int choice);
}
