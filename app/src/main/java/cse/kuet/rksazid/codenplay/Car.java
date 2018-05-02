package cse.kuet.rksazid.codenplay;

import android.widget.Button;

/**
 * Created by ASUS on 12/29/2016.
 */

public class Car {
    private static final int UP_WINDOW = 2;
    private static final int LEFT_WINDOW = 4;
    private static final int RIGHT_WINDOW = 6;
    private static final int DOWN_WINDOW = 8;
    Button car;
    int front = RIGHT_WINDOW;

    public Car(Button car){
        this.car = car;
    }

    public void setFront(int front){
        this.front = front;
    }


}
