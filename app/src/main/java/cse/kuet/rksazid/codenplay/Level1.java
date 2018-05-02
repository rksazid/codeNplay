package cse.kuet.rksazid.codenplay;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;

public class Level1 extends Activity {

    Button planeView,compile;
    Button tiles1,tiles2,tiles3,tiles4,tiles5,tiles6;
    EditText codeWindow;
    Boolean flag = true;
    String[] code,match;
    String string;
    Animation shake;
    Drawable car;
    Point pre,p1,p2,p3,p4,p5,p6;
    Animation translationPlane;
    RotateAnimation rotateAnimation;
    int i = 0,j = 0,k = 0,m = 0,count = 0,f;
    float delta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Make Fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_level1);

        shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);

        setShakeListener();

        planeView = (Button) findViewById(R.id.planeview);
        compile = (Button) findViewById(R.id.compileButton);
        tiles1 = (Button) findViewById(R.id.tiles1);
        tiles2 = (Button) findViewById(R.id.tiles2);
        tiles3 = (Button) findViewById(R.id.tiles3);
        tiles4 = (Button) findViewById(R.id.tiles4);
        tiles5 = (Button) findViewById(R.id.tiles5);
        tiles6 = (Button) findViewById(R.id.tiles6);
        codeWindow = (EditText) findViewById(R.id.codewindow);

        j = 0;
        i = 0;
        k = 0;
        code = new String[15];
        match = new String[15];

        match[0] = "car.go()";
        match[1] = "car.go()";
        match[2] = "car.left()";
        match[3] = "car.go()";
        match[4] = "car.go()";
        match[5] = "car.right()";
        match[6] = "car.go()";
        match[7] = "car.go()";

       // Log.d("Point2 Info","pointX :"+p[0].x+" pointY :"+p[0].y);

        compile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afterClickTask();


            }

        });
    }

    void afterClickTask(){
        if(flag){
            p1 = getCenterPointOfView(planeView);
            p2 = getCenterPointOfView(tiles1);
            p3 = getCenterPointOfView(tiles2);
            p4 = getCenterPointOfView(tiles3);
            p5 = getCenterPointOfView(tiles4);
            p6 = getCenterPointOfView(tiles5);
            delta = (p2.x - p1.x)+(p6.x-p1.x);

            string = codeWindow.getText().toString();

            for(f = 0;f<12;f++){
                code[f] = "";
            }

            for( m = 0,count = 0; m<string.length();m++,count++){
                for(;string.charAt(m)!='\n';m++){
                    code[count] += string.charAt(m);
                }
            }
            flag = false;
        }

        Log.d("Point1 Info","pointX :"+code[0]);
        Log.d("Point2 Info","pointX :"+match[0]);
        // Log.d("Point3 Info","pointX :"+p3.x);
        // Log.d("Point4 Info","pointX :"+p4.x);
        //  while(i++<8) {

        if (code[i].equals(match[i])) {
            switch (i) {
                case 0:
                    translationPlane = new TranslateAnimation(j, (p2.x - p1.x), 0, 0);
                    translationPlane.setFillAfter(true);
                    translationPlane.setDuration(500);
                    j += (p2.x - p1.x);
                   // setListen0();
                    planeView.startAnimation(translationPlane);
                    break;
                case 1:
                    translationPlane = new TranslateAnimation(j, (p3.x - p1.x), 0, 0);
                    translationPlane.setFillAfter(true);
                    translationPlane.setDuration(500);
                    j += (p3.x - p2.x);
                    planeView.startAnimation(translationPlane);
                    break;
                case 2:
                    car = getResources().getDrawable(R.drawable.policecar2);
                    planeView.setBackground(car);
                    break;
                case 3:
                    translationPlane = new TranslateAnimation(j, j, 0, p4.y - p3.y);
                    translationPlane.setFillAfter(true);
                    translationPlane.setDuration(500);
                    k += (p4.y - p3.y);
                    planeView.startAnimation(translationPlane);
                    break;
                case 4:
                    translationPlane = new TranslateAnimation(j, j, k, p5.y - p1.y);
                    translationPlane.setFillAfter(true);
                    translationPlane.setDuration(500);
                    k += (p5.y - p4.y);
                    planeView.startAnimation(translationPlane);
                    break;
                case 5:
                    car = getResources().getDrawable(R.drawable.policecar);
                    planeView.setBackground(car);
                    break;
                case 6:
                    translationPlane = new TranslateAnimation(j, p6.x - p1.x, p5.y - p1.y, p5.y - p1.y);
                    translationPlane.setFillAfter(true);
                    translationPlane.setDuration(500);
                    j += (p6.x - p5.x);
                    planeView.startAnimation(translationPlane);
                    break;
                case 7:
                    translationPlane = new TranslateAnimation(j, delta, p5.y - p1.y, p5.y - p1.y);
                    translationPlane.setFillAfter(true);
                    translationPlane.setDuration(500);
                    planeView.startAnimation(translationPlane);
                    break;
                default:

                    break;
            }
            ++i;
        } else {
            noMatch();
            // break;
        }
        // }
    }

    private void  setShakeListener(){
        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                planeView.startAnimation(translationPlane);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void setListen0(){
        translationPlane.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void noMatch() {
        planeView.startAnimation(shake);
        car = getResources().getDrawable(R.drawable.policecar);
        planeView.setBackground(car);
        translationPlane = new TranslateAnimation(0, 0, 0, 0);
        i = 0;
        j = 0;
        k = 0;
        string = "";
        for( m = 0,count = 0; m<string.length();m++,count++){
            for(;string.charAt(m)!='\n';m++){
                code[count] += string.charAt(m);
            }
        }
    }

    private Point getCenterPointOfView(View view){
        int[] location = new int[2];
        view.getLocationInWindow(location);
        int x = location[0] + view.getWidth()/2;
        int y = location[1] + view.getHeight()/2;
        return new Point(x,y);
    }
}
