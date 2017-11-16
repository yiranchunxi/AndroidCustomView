package views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/7/19.
 */

public class TestEventLinearLayout extends LinearLayout {


    public TestEventLinearLayout(Context context) {
        super(context);
    }

    public TestEventLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestEventLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
       // return super.dispatchTouchEvent(ev);
       // boolean b=super.dispatchTouchEvent(ev);
        return true;
       // return false;
        /*boolean a=onInterceptTouchEvent(ev);
        return a;*/
       // return onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
       // return super.onInterceptTouchEvent(ev);
      //  return false;
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                return false;
            default:
                return true;

        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("test.html","1111");
        return super.onTouchEvent(event);
       // return false;
    }
}
