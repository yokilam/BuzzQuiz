package nyc.c4q.buzzquiz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.BounceInterpolator;

import com.sdsmdg.harjot.rotatingtext.RotatingTextWrapper;
import com.sdsmdg.harjot.rotatingtext.models.Rotatable;

import nyc.c4q.buzzquiz.view.MainActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        final RotatingTextWrapper rotatingTextWrapper = (RotatingTextWrapper) findViewById(R.id.custom_switcher);
        rotatingTextWrapper.setSize(60);

        final Rotatable rotatable = new Rotatable(Color.parseColor("#fefefe"), 1500, " Crazy", "Boring", "Stupid");
        rotatable.setSize(55);
        rotatable.setAnimationDuration(1000);

        rotatingTextWrapper.setContent("", rotatable);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(Splash.this, MainActivity.class);
                startActivity(intent);

            }
        },7000);

    }
}
