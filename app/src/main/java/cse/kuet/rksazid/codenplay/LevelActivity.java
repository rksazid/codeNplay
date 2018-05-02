package cse.kuet.rksazid.codenplay;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class LevelActivity extends Activity {

    Button level1,level2,level3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make Fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_level);

        level1 = (Button) findViewById(R.id.level1Button);
        level2 = (Button) findViewById(R.id.level2Button);
        level3 = (Button) findViewById(R.id.level3Button);

        final Animation myAnimationlevel = AnimationUtils.loadAnimation(this,R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2,20);
        myAnimationlevel.setInterpolator(interpolator);

        //For level 1
        myAnimationlevel.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Intent intent1 = new Intent(LevelActivity.this, Level1.class);
                LevelActivity.this.startActivity(intent1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        level1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        level1.startAnimation(myAnimationlevel);
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_MOVE:

                        break;
                }
                return false;
            }
        });

        //For level 2

    }
}
