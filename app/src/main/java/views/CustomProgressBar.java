package views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import custom.study.com.R;

/**
 * Created by Administrator on 2017/6/1.
 */

public class CustomProgressBar extends View {


    private int mFirstColor,mSecondColor,mCircleWidth,mSpeed;

    private Paint mPaint;
    private boolean isNext;
    private int mProgress;
    private int width;
    public CustomProgressBar(Context context) {
        //super(context);
        this(context,null);
    }
    public CustomProgressBar(Context context, AttributeSet attrs) {
       this(context,attrs,0);
    }
    public CustomProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a=context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomProgressBar,defStyleAttr,0);

        int n=a.getIndexCount();

        for(int i=0;i<n;i++){

            int attr=a.getIndex(i);
            switch (attr){

                case R.styleable.CustomProgressBar_firstColor:
                    mFirstColor=a.getColor(attr, Color.GREEN);
                    break;
                case R.styleable.CustomProgressBar_secondColor:
                    mSecondColor=a.getColor(attr,Color.RED);
                    break;

                case R.styleable.CustomProgressBar_circleWidth:

                    mCircleWidth=a.getDimensionPixelSize(attr,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20,getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomProgressBar_speed:
                    mSpeed=a.getInt(attr,20);
                    break;

            }

        }

        a.recycle();

        mPaint=new Paint();

        // 绘图线程

        // 绘图线程
        new Thread()
        {
            public void run()
            {
                while (true)
                {
                    mProgress++;
                    if (mProgress == 360)
                    {
                        mProgress = 0;
                        isNext=!isNext;
                    }
                    postInvalidate();
                    try
                    {
                        Thread.sleep(mSpeed);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            };
        }.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /*int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);

        if (modeWidth == MeasureSpec.EXACTLY) {
            width = sizeWidth;
        } else {//默认宽度
            width = 300;
        }

        setMeasuredDimension(width, width);*/
    }

    @Override
    protected void onDraw(Canvas canvas) {
       // super.onDraw(canvas);


        int centre=getWidth()/2;  // 获取圆心的x坐标

        int radius=centre-mCircleWidth/2;// 半径

       // mPaint.setStrokeWidth(mCircleWidth);// 设置圆环的宽度

        mPaint.setAntiAlias(true);// 消除锯齿

        mPaint.setStyle(Paint.Style.STROKE); // 设置空心
       /* * @param left   The X coordinate of the left side of the rectangle
                * @param top    The Y coordinate of the top of the rectangle
                * @param right  The X coordinate of the right side of the rectangle
        * @param bottom The Y coordinate of the bottom of the rectangle*/

        Log.e("custom",String.valueOf(centre-radius));
        Log.e("custom",String.valueOf(centre+radius));
        RectF oval=new RectF(centre-radius,centre-radius,centre+radius,centre+radius);// 用于定义的圆弧的形状和大小的界限
        canvas.drawRect(oval,mPaint);
        /*if(!isNext){
            // 第一颜色的圈完整，第二颜色跑
            mPaint.setColor(mFirstColor);// 设置圆环的颜色
            canvas.drawCircle(centre,centre,radius,mPaint);// 画出圆环
            mPaint.setColor(mSecondColor); // 设置圆环的颜色
            canvas.drawArc(oval,-90,mProgress, false,mPaint);
        }else{
            mPaint.setColor(mSecondColor); // 设置圆环的颜色
            canvas.drawCircle(centre, centre, radius, mPaint); // 画出圆环
            mPaint.setColor(mFirstColor); // 设置圆环的颜色
            canvas.drawArc(oval, -90, mProgress, false, mPaint); // 根据进度画圆弧

        }*/
    }
}
