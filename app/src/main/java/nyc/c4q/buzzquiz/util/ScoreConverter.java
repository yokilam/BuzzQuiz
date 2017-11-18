package nyc.c4q.buzzquiz.util;

/**
 * Created by yokilam on 11/15/17.
 */

public class ScoreConverter {

    public static String converterScore(int score) {
        String result = "?";
        if(score>= 5) {
            result = "You’re a cookie! You’re easygoing, happy anywhere and great with all age groups.";
        } else if (score >= 3) {
            result = "You’re a doughnut! You’re somewhere between hipster and stalwart, and always down for coffee.";
        } else if (score >= 2) {
            result = "You’re a cupcake! You love anything trendy and cool, and you always know where the party is.";
        } else if (score >= 0) {
            result = "You’re a scone! You love crafting, cozy evenings at home and a good pot of tea.";
        } else {
            result = "You are crumbs! You suck.";
        }
        return result;
    }
}
