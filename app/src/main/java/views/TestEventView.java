package views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/7/19.
 */

public class TestEventView extends View {


    public TestEventView(Context context) {
        super(context);
    }

    public TestEventView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestEventView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
        //return false;
        //return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);
        return  true;
    }


}
