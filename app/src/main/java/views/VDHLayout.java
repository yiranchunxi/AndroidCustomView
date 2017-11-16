package views;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/6/26.
 * clampViewPositionHorizontal,clampViewPositionVertical可以在该方法中对child移动的边界进行控制，
 * left , top 分别为即将移动到的位置，
 * 比如横向的情况下，我希望只在ViewGroup的内部移动，
 * 即：最小>=paddingleft，
 * 最大<=ViewGroup.getWidth()-paddingright-child.getWidth。
 *
 */

public class VDHLayout extends LinearLayout {

    private ViewDragHelper mDragger;
    private View mDragView,B;

    private Point mAutoBackOriginPos = new Point();

    private EdgeListner listner;
    public VDHLayout(Context context) {
        this(context, null);
    }

    public VDHLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VDHLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mDragger=ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return child==mDragView||child==B;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
               /* final int leftBound=getPaddingLeft();
                final int rightBound=getWidth()-child.getWidth()-leftBound;
                final int newLeft=Math.min(Math.max(left,leftBound),rightBound);
                return newLeft;*/
                return  left;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
             /*   final int topBound=getPaddingTop();
                final int botBound=mAutoBackOriginPos.y-topBound;
                final int newTop=Math.min(Math.max(top,topBound),botBound);
                return newTop;*/
                return  top;
            }

            @Override
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
              //  super.onViewPositionChanged(changedView, left, top, dx, dy);


            }

            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
               // super.onViewReleased(releasedChild, xvel, yvel);
                 Log.e("test.html",yvel+"===="+mDragView.getY());

               /* if (releasedChild ==mDragView&&mDragView!=null)
                {

                    if(yvel>0){
                        //向下滑
                        if(yvel>3000){
                            mDragger.settleCapturedViewAt(mAutoBackOriginPos.x, mAutoBackOriginPos.y);
                            invalidate();
                        }else{
                            if(mDragView.getY()>getHeight()/2){

                                mDragger.settleCapturedViewAt(mAutoBackOriginPos.x, mAutoBackOriginPos.y);
                                invalidate();

                            }else{

                                mDragger.settleCapturedViewAt(mAutoBackOriginPos.x,0);
                                invalidate();
                            }
                        }
                    }else if(yvel<0){
                        //向上滑
                        if(Math.abs(yvel)>3000){
                            mDragger.settleCapturedViewAt(mAutoBackOriginPos.x,0);
                            invalidate();
                        }else{


                            if(mDragView.getY()>getHeight()/2){

                                mDragger.settleCapturedViewAt(mAutoBackOriginPos.x, mAutoBackOriginPos.y);
                                invalidate();

                            }else{

                                mDragger.settleCapturedViewAt(mAutoBackOriginPos.x,0);
                                invalidate();
                            }

                        }
                    }else {

                        if(mDragView.getY()>getHeight()/2){

                            mDragger.settleCapturedViewAt(mAutoBackOriginPos.x, mAutoBackOriginPos.y);
                            invalidate();

                        }else{

                            mDragger.settleCapturedViewAt(mAutoBackOriginPos.x,0);
                            invalidate();
                        }
                    }

                }*/
            }

            @Override
            public int getViewHorizontalDragRange(View child)
            {
                return getMeasuredWidth()-child.getMeasuredWidth();
            }

            @Override
            public int getViewVerticalDragRange(View child)
            {
                return getMeasuredHeight()-child.getMeasuredHeight();
            }
        });
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
       // A.setY(getHeight());
        mAutoBackOriginPos.x =mDragView.getLeft();
        mAutoBackOriginPos.y = mDragView.getTop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return  mDragger.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        try {


            mDragger.processTouchEvent(event);



        }catch (Exception e){
            e.printStackTrace();
        }
        return  true;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mDragView = getChildAt(1);
        B= getChildAt(0);


    }
    @Override
    public void computeScroll()
    {
        if(mDragger.continueSettling(true))
        {
            invalidate();
        }else{

           if(mDragView.getY()==0){
               if(listner!=null){
                   listner.edge(0);
               }
           }else if(mDragView.getY()==mAutoBackOriginPos.y){
               if(listner!=null){
                   listner.edge(1);
               }
           }
        }

    }

    public interface EdgeListner{

        void edge(int type);
    }

    public void setEdgeListner(EdgeListner l){

        this.listner=l;
    }
}
