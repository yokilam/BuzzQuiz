package nyc.c4q.buzzquiz.util;

/**
 * Created by yokilam on 11/18/17.
 */

public class ScoreConverter2 {

    public static String converterScore(int score) {
        String result = "?";
        if(score>= 5) {
            result = "You’re a Nerd! You’re an individual of vast intelligence and curiosity coupled with a natural knack for academics and discovery. ";
        } else if (score >= 3) {
            result = "You’re a Geek! Where Pop Culture is the name of the game and Comic-Con's is your jam! ";
        } else if (score <= 2) {
            result = "You’re a dork! Someone who is endearing fashion.";
        }
        return result;
    }
}
