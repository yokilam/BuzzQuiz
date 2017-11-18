package nyc.c4q.buzzquiz;

import org.junit.Test;

import nyc.c4q.buzzquiz.util.ScoreConverter;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testScoreConverter() throws Exception {
        assertEquals("You’re a cookie! You’re easygoing, happy anywhere and great with all age groups.", ScoreConverter.converterScore(5));
    }


}