package widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2017/6/20.
 */

public class MapContainer extends LinearLayout {
    private LinearLayout scrollView;
    public MapContainer(Context context) {
        super(context);
    }

    public MapContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MapContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollView(LinearLayout scrollView) {
        this.scrollView = scrollView;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {  //如果抬起手指
            scrollView.requestDisallowInterceptTouchEvent(false);  //拦截
         } else {
            scrollView.requestDisallowInterceptTouchEvent(true);  //不拦截
        }
        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
