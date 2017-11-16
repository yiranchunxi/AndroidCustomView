package views;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/**
 * Created by Administrator on 2017/6/6.
 */

public class SlideCutListView extends ListView {


    private final String TAG="SlideCutListView";
    /**
     * 屏幕宽度
     */
    private int screenWidth;

    /**
     * 滑动类
     */
    private Scroller scroller;
    /**
     * 认为是用户滑动的最小距离
     */
    private int mTouchSlop;
    private static final int SNAP_VELOCITY = 600;

    /**
     * 用来指示item滑出屏幕的方向,向左或者向右,用一个枚举值来标记
     */
    private RemoveDirection removeDirection;

    // 滑动删除方向的枚举值
    public enum RemoveDirection {
        RIGHT, LEFT;
    }

    /**
     *  移除item后的回调接口
     */
    private RemoveListener mRemoveListener;


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
     * 手指按下X的坐标
     */
    private int downX;
    /**
     * 手指按下Y的坐标
     */
    private int downY;

    /**
     * 当前滑动的ListView　position
     */
    private int slidePosition;

    /**
     * ListView的item
     */
    private View itemView;

    /**
     * 是否响应滑动，默认为不响应
     */
    private boolean isSlide = false;
    public SlideCutListView(Context context) {
        this(context, null);
    }

    public SlideCutListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlideCutListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        screenWidth=((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
        scroller=new Scroller(context);
        mTouchSlop= ViewConfiguration.get(getContext()).getScaledTouchSlop();

    }



    /**
     *
     * 当ListView item滑出屏幕，回调这个接口
     * 我们需要在回调方法removeItem()中移除该Item,然后刷新ListView
     *
     * @author xiaanming
     *
     */
    public interface RemoveListener {
        public void removeItem(RemoveDirection direction, int position);
    }


    /**
     *  移除item后的回调接口
     */
    public void setmRemoveListener(RemoveListener removeListener){

        this.mRemoveListener=removeListener;
    }

    /**
     * 分发事件，主要做的是判断点击的是那个item, 以及通过postDelayed来设置响应左右滑动事件
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {


        Log.e(TAG,"dispatchTouchEvent");
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:{
                addVelocityTracker(ev);
               // 假如scroller滚动还没有结束，我们直接返回
                if(!scroller.isFinished()){
                    Log.e(TAG,String.valueOf("hehe1:"+super.dispatchTouchEvent(ev)));
                    return  super.dispatchTouchEvent(ev);
                }

                downX= (int) ev.getX();
                downY= (int) ev.getY();

                slidePosition=pointToPosition(downX,downY);
                // 无效的position, 不做任何处理

                if(slidePosition== AdapterView.INVALID_POSITION){
                    Log.e(TAG,String.valueOf("hehe2:"+super.dispatchTouchEvent(ev)));
                    return  super.dispatchTouchEvent(ev);

                }
                // 获取我们点击的item view
                itemView=getChildAt(slidePosition-getFirstVisiblePosition());

                break;
            }

            case MotionEvent.ACTION_MOVE:{
                Log.e(TAG,"dispatchTouchEvent:ACTION_MOVE");
                Log.e(TAG,"dispatchTouchEvent"+getScrollVelocity());
                Log.e(TAG,"dispatchTouchEvent"+ev.getX());
                if(Math.abs(getScrollVelocity())>SNAP_VELOCITY||(Math.abs(ev.getX()-downX)>mTouchSlop&&Math.abs(ev.getY()-downY)<mTouchSlop)){

                    isSlide=true;

                }

                break;


            }

            case MotionEvent.ACTION_UP:{
                Log.e(TAG,"dispatchTouchEvent:ACTION_UP");
                recycVelocityTracker();

                break;
            }



        }


        return super.dispatchTouchEvent(ev);
    }

    /**
     * 处理我们拖动ListView item的逻辑
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e(TAG,"onTouchEvent");
        if(isSlide&&slidePosition!=AdapterView.INVALID_POSITION){
            //调用该方法，一旦底层View收到touch的action后调用这个方法
            // 那么父层View就不会再调用onInterceptTouchEvent了，也无法截获以后的action。
            requestDisallowInterceptTouchEvent(true);

            addVelocityTracker(ev);

            final int action=ev.getAction();

            int x= (int) ev.getX();
            Log.e(TAG,"onTouchEvent"+ev.getX());
            switch (action){

                case MotionEvent.ACTION_DOWN:


                    break;



                case MotionEvent.ACTION_MOVE:

                MotionEvent cancelEvent=MotionEvent.obtain(ev);
                    //|	如果相对应位都是0，则结果为0，否则为1
                    /**
                     * 在设计设置页面的滑动开关时，如果不监听ACTION_CANCEL，在滑动到中间时，如果你手指上下移动，
                     * 就是移动到开关控件之外，则此时会触发ACTION_CANCEL，而不是ACTION_UP，造成开关的按钮停顿在中间位置。

                         意思就是，当用户保持按下操作，并从你的控件转移到外层控件时，会触发ACTION_CANCEL，建议进行处理～

                         当前的手势被中断，不会再接收到关于它的记录。
                         推荐将这个事件作为 ACTION_UP 来看待，但是要区别于普通的 ACTION_UP

                         话说回来，平常还真碰不到这个事件，习惯上就直接当 ACTION_UP 处理了就
                     */
                    cancelEvent.setAction(MotionEvent.ACTION_CANCEL|(ev.getActionIndex()<<MotionEvent.ACTION_POINTER_INDEX_SHIFT)); //?????

                    onTouchEvent(cancelEvent);

                    int deltaX=downX-x;
                    downX=x;

                    //手指拖动itemView滚动 deltaX大于0向左滚动，小于0向右滚
                    Log.e(TAG,"ACTION_MOVE:"+deltaX);
                    itemView.scrollBy(deltaX,0);
                    //拖动的时候ListView不滚动
                    return  true;


                case MotionEvent.ACTION_UP:

                    int velocityX=getScrollVelocity();

                    if(velocityX>SNAP_VELOCITY){

                       scrollRight();
                    }else if(velocityX<-SNAP_VELOCITY){

                       scrollLeft();
                    }else{

                       scrollByDistanceX();

                    }

                     recycVelocityTracker();
                    // 手指离开的时候就不响应左右滚动
                    isSlide=false;
                    break;
            }

        }

        //否则直接交给ListView来处理onTouchEvent事件
        return super.onTouchEvent(ev);
    }

    /**
     * 添加用户的速度跟踪器
     * @param event
     */
    private  void addVelocityTracker(MotionEvent event){

        if(velocityTracker==null){
            velocityTracker=VelocityTracker.obtain();
        }

        velocityTracker.addMovement(event);
    }

    /**
     * 获取X方向的滑动速度,大于0向右滑动，反之向左
     * @return
     */
    private int getScrollVelocity(){

        velocityTracker.computeCurrentVelocity(1000);
        int velocity=(int) velocityTracker.getXVelocity();
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


    /**
     * 往右滑动，getScrollX()返回的是左边缘的距离，就是以View左边缘为原点到开始滑动的距离，所以向右边滑动为负值
     */
    private  void scrollRight(){

        removeDirection=RemoveDirection.RIGHT;
        final int delta=(screenWidth+itemView.getScrollX());
        // 调用startScroll方法来设置一些滚动的参数，我们在computeScroll()方法中调用scrollTo来滚动item
        scroller.startScroll(itemView.getScrollX(),0,-delta,0,Math.abs(delta));

        // 刷新itemView

        postInvalidate();
    }

    /**
     * 向左滑动，根据上面我们知道向左滑动为正值
     */
    private  void scrollLeft(){

        removeDirection=RemoveDirection.LEFT;

        final int delta=(screenWidth-itemView.getScrollX());

        // 调用startScroll方法来设置一些滚动的参数，我们在computeScroll()方法中调用scrollTo来滚动item

        scroller.startScroll(itemView.getScrollX(),0,delta,0,Math.abs(delta));
        // 刷新itemView
        postInvalidate();
    }

    /**
     * 根据手指滚动itemView的距离来判断是滚动到开始位置还是向左或者向右滚动
     */
    private  void scrollByDistanceX(){
        // 如果向左滚动的距离大于屏幕的二分之一，就让其删除
        if(itemView.getScrollX()>=screenWidth/2){
            scrollLeft();
        }else if(itemView.getScrollX()<=-screenWidth/2){

            scrollRight();
        }else{
            // 滚回到原始位置,为了偷下懒这里是直接调用scrollTo滚动
            itemView.scrollTo(0,0);
        }

    }

    @Override
    public void computeScroll() {
        //super.computeScroll();
        // 调用startScroll的时候scroller.computeScrollOffset()返回true
        Log.e(TAG,"computeScroll");
        if(scroller.computeScrollOffset()){
            // 让ListView item根据当前的滚动偏移量进行滚动
            itemView.scrollTo(scroller.getCurrX(),scroller.getCurrY());

            postInvalidate();

            // 滚动动画结束的时候调用回调接口
            if(scroller.isFinished()){

                if(mRemoveListener==null){

                    throw new NullPointerException("RemoveListener is null, we should called setRemoveListener()");
                }

                itemView.scrollTo(0,0);

                mRemoveListener.removeItem(removeDirection,slidePosition);
            }
        }

    }
}
