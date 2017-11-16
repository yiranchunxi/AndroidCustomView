package custom.study.com;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/7/18.
 */

public class TouchActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touchlayout);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
       // return  true;
       // return  false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
