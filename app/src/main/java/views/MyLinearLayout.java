package views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by Administrator on 2017/6/8.
 */

public class MyLinearLayout extends LinearLayout {
    private static final String TAG = MyLinearLayout.class.getSimpleName();

    private Scroller mScroller;
    public MyLinearLayout(Context context) {
        this(context, null, 0);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "dispatchTouchEvent ACTION_UP");
                break;

            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onInterceptTouchEvent ACTION_MOVE");
                return  true;


            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onInterceptTouchEvent ACTION_UP");
                break;

            default:
                break;
        }

        return false;
    }

    // 手指最后在View中的坐标。
    private int mLastX;
    private int mLastY;

    // 手指按下时View的相对坐标。
    private int mDownViewX;
    private int mDownViewY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        // 第一步，记录手指在view的坐标。
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                if (!mScroller.isFinished()) { // 如果上次的调用没有执行完就取消。
                    mScroller.abortAnimation();
                }
                Log.e(TAG, "onTouchEvent ACTION_DOWN");
                // 记录View相对于初始位置的滚动坐标。
                mDownViewX = getScrollX();
                mDownViewY = getScrollY();

                // 更新手指此时的坐标。
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouchEvent ACTION_MOVE");
                // 计算手指此时的坐标和上次的坐标滑动的距离。
                int dy = y - mLastY;
                int dx = x - mLastX;

                // 更新手指此时的坐标。
                mLastX = x;
                mLastY = y;

                // 滑动相对距离。
                scrollBy(-dx, -dy);

                Log.e("test.html",getScrollX()+"============="+getScrollY());
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent ACTION_UP");
                // XY都从滑动的距离回去，最后一个参数是多少毫秒内执行完这个动作。
                mScroller.startScroll(getScrollX(), getScrollY(), -getScrollX(), -getScrollY());
                invalidate();
               // scrollTo(mDownViewX, mDownViewY);
                break;

            default:
                break;
        }

        return true;
    }


    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept)
    {
        Log.e(TAG, "requestDisallowInterceptTouchEvent ");
       // super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    /**
     * 这个方法在调用了invalidate()后被回调。
     */
    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) { // 计算新位置，并判断上一个滚动是否完成。
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();// 再次调用computeScroll。
        }
    }
}
