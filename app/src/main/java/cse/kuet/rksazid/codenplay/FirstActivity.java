package cse.kuet.rksazid.codenplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class FirstActivity extends Activity {

    Animation fadeIn,fadeOut;
    ImageView codeNplayView;
    Button codeTheWorldView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Make Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first);

        codeNplayView = (ImageView) findViewById(R.id.codeNplayImageView);
        codeTheWorldView = (Button) findViewById(R.id.codeTheWorld);

        //Initialize Animation
        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);

        //Override fade In animationListener
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                codeNplayView.startAnimation(fadeOut);
                codeTheWorldView.startAnimation(fadeOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //Override fade out animationListener
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                //After fade in & fade out occurred the thread sleep in 500 ms & then start next MainActivity
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(FirstActivity.this,MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //Start the fade in animation
        codeTheWorldView.setVisibility(View.VISIBLE);
        codeNplayView.startAnimation(fadeIn);
        codeTheWorldView.startAnimation(fadeIn);
    }
}
