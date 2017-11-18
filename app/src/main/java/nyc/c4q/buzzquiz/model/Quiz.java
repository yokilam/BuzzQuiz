package nyc.c4q.buzzquiz.model;

/**
 * Created by yokilam on 11/14/17.
 */

public class Quiz {
    private String choiceOne, choiceTwo;
    private int image;
    private String imageLink;

    public Quiz(String choiceOne, String choiceTwo, int image) {
        this.choiceOne = choiceOne;
        this.choiceTwo = choiceTwo;
        this.image= image;
    }

    public String getChoiceOne() {
        return choiceOne;
    }

    public String getChoiceTwo() {
        return choiceTwo;
    }

    public int getImage() {
        return image;
    }

    public String getImageLink() {
        return imageLink;
    }
}
