package com.framgia.library.calendardayview.helper.swipeListeners;

/**
 * Created by Shasin on 05/01/2018.
 */

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class OnSwipeTouchListener implements OnTouchListener {

    private final GestureDetector gestureDetector;

    public OnSwipeTouchListener(Context ctx){
        gestureDetector = new GestureDetector(ctx, new GestureListener());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD_X = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD_X = 100;
        private static final int SWIPE_THRESHOLD_Y = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD_Y = 100;


    @Override
    public boolean onDown(MotionEvent e) {
    return true;
}

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            onClicked();
            return super.onSingleTapUp(e);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                Log.d("X-Direction2",String.valueOf(diffX));
                Log.d("Y-Direction2",String.valueOf(diffY));
                Log.d("X-Velocity2",String.valueOf(velocityX));
                Log.d("Y-Velocity2",String.valueOf(velocityY));

                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD_X && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD_X) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
//                        result = true;
                    }
                }
                else if (Math.abs(diffY) > SWIPE_THRESHOLD_Y && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD_Y) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    } else {
                        onSwipeTop();
                    }
//                    result = true;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }



    public void onSwipeRight() {
    }

    public void onSwipeLeft() {
    }

    public void onSwipeTop() {
    }

    public void onSwipeBottom() {
    }

    public void onClicked() {
    }
}