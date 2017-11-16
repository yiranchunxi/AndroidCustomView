package custom.study.com;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.nineoldandroids.view.ViewHelper;

import views.MagicCircle;

/**
 * Created by Administrator on 2017/5/31.
 */

public class MainActivity extends FragmentActivity {


   // private views.MagicCircle magic_circle;
    private final String TAG="MainActivity";
    private LinearLayout  ll_b;
    private LinearLayout  ll_a;
    private RelativeLayout rl_conainer;
    private View drag_bar;
    private int mLastY;
    private static final int SNAP_VELOCITY = 600;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom7);
       // magic_circle= (MagicCircle) findViewById(R.id.magic_circle);

       // magic_circle.startAnimation();
        ll_a= (LinearLayout) findViewById(R.id.ll_a);
        ll_b= (LinearLayout) findViewById(R.id.ll_b);
        rl_conainer= (RelativeLayout) findViewById(R.id.rl_container);
        drag_bar=findViewById(R.id.drag_bar);


        drag_bar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                addVelocityTracker(event);
                int y = (int) event.getRawY();

                Log.d(TAG, "onTouchEvent");
                Log.d(TAG,  rl_conainer.getTop()+"dif"+rl_conainer.getBottom());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        Log.d(TAG, "ACTION_DOWN");
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        Log.d(TAG,y+"--");
                        //判断是否超出父容器

                        if(mLastY<rl_conainer.getTop()+v.getHeight()){
                            setVisibleHeight(0,ll_a);
                            ViewHelper.setY(v,rl_conainer.getTop());

                        }else if(mLastY>rl_conainer.getBottom()-v.getHeight()){
                            setVisibleHeight(rl_conainer.getBottom()-v.getHeight(),ll_a);
                            ViewHelper.setY(v,rl_conainer.getBottom()-v.getHeight());

                        }else{
                            int deltaY = y - mLastY;
                            Log.e(TAG,deltaY+"");
                            int translationY = (int)ViewHelper.getTranslationY(v) + deltaY;
                            if(deltaY>=0){
                                setVisibleHeight((int) (v.getY()+v.getHeight()),ll_a);
                            }else{
                                setVisibleHeight((int) (v.getY()),ll_a);
                            }

                            ViewHelper.setTranslationY(v, translationY);


                        }
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        Log.d(TAG, "ACTION_UP");
                     //   setVisibleHeight((int) (v.getY()+v.getHeight()),ll_a);

                        int velocityX=getScrollVelocity();
                        Log.d(TAG, "ACTION_UP:"+velocityX);
                        if(velocityX>=0){
                            smoothScrollTo(ll_a.getBottom(),rl_conainer.getBottom());
                            smoothScrollToBar(ll_a.getBottom(),rl_conainer.getBottom()-v.getHeight());
                        }else if(velocityX<0){
                            smoothScrollTo(ll_a.getBottom(),0);
                            smoothScrollToBar(ll_a.getBottom(),0);
                        }

                        recycVelocityTracker();
                        break;
                    }
                    default:
                        break;
                }


                mLastY = y;
                return true;
            }
        });


    }
    private void smoothScrollTo(int originHeight,int destHeight) {

        ValueAnimator animator=ValueAnimator.ofInt(originHeight, destHeight);
        animator.setDuration(300).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                setVisibleHeight((int) animation.getAnimatedValue(),ll_a);


            }

        });

        animator.start();

    }
    private void smoothScrollToBar(int originHeight,int destHeight) {

        ValueAnimator animator=ValueAnimator.ofInt(originHeight, destHeight);
        animator.setDuration(300).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {

                ViewHelper.setY(drag_bar, (int) animation.getAnimatedValue());
            }

        });

        animator.start();

    }
    public void setVisibleHeight(int height,View v) {
        if (height < 0) height = 0;
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) v .getLayoutParams();
        lp.height = height;
        v.setLayoutParams(lp);
    }

    /**
     * 速度追踪对象
     * VelocityTracker 是一个跟踪触摸事件滑动速度的帮助类，
     * 用于实现flinging以及其它类似的手势。
     * 它的原理是把触摸事件 MotionEvent 对象传递给VelocityTracker的addMovement(MotionEvent)方法，
     * 然后分析MotionEvent 对象在单位时间类发生的位移来计算速度。
     * 你可以使用getXVelocity() 或getXVelocity()获得横向和竖向的速率到速率时，
     * 但是使用它们之前请先调用computeCurrentVelocity(int)来初始化速率的单位 。
     */
    private VelocityTracker velocityTracker;
    /**
     * 添加用户的速度跟踪器
     * @param event
     */
    private  void addVelocityTracker(MotionEvent event){

        if(velocityTracker==null){
            velocityTracker= VelocityTracker.obtain();
        }

        velocityTracker.addMovement(event);
    }

    /**
     * 获取X方向的滑动速度,大于0向右滑动，反之向左
     * @return
     */
    private int getScrollVelocity(){

        velocityTracker.computeCurrentVelocity(1000);
        int velocity=(int) velocityTracker.getYVelocity();
        return  velocity;
    }

    /**
     * 移除用户速度跟踪器
     */
    private  void recycVelocityTracker(){

        if(velocityTracker!=null){

            velocityTracker.recycle();
            velocityTracker=null;
        }

    }
}
