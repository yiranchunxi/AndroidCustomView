package views;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import custom.study.com.R;

/**
 * Created by Administrator on 2017/5/31.
 * Canvas(画布)，Paint(画笔)，Path(路径)！
 */

public class CustomTitleView extends View{
    /**
     * 文本
     */
    private String mTitleText;
    /**
     * 文本的颜色
     */
    private int mTitleTextColor;
    /**
     * 文本的大小
     */
    private int mTitleTextSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound;
    private Paint mPaint;
    public CustomTitleView(Context context) {
        this(context, null);
    }

    public CustomTitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray a=context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView,defStyleAttr,0);

         int n=a.getIndexCount();
        /**
         * 获得我们所定义的自定义样式属性
         */
        for (int i = 0; i < n; i++)
        {
            int attr = a.getIndex(i);
            switch (attr)
            {
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    // 默认颜色设置为黑色
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;

            }

        }
        a.recycle();


        mPaint=new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mBound=new Rect();
        mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitleText=randomText();

                postInvalidate();
            }
        });
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
      //  super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //standard code
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        int width,height;

        if(widthMode==MeasureSpec.EXACTLY){

            width=widthSize;
        }else{

            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
            float textWidth=mBound.width();
            int desired= (int) (getPaddingLeft()+textWidth+getPaddingRight());
            width=desired;
        }

        if(heightMode==MeasureSpec.EXACTLY){
            height=heightSize;
        }else{

            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);

            float textheight=mBound.height();

            int desired= (int) (getPaddingTop()+textheight+getPaddingBottom());

            height=desired;
        }


        setMeasuredDimension(width,height);
    }


    @Override
    protected void onDraw(Canvas canvas) {
       // super.onDraw(canvas);

        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);

        Log.e("custom","getMeasuredWidth():"+getMeasuredWidth());
        Log.e("custom","getMeasuredHeight():"+getMeasuredHeight());

        Log.e("custom","getWidth():"+getWidth());
        Log.e("custom","getHeight():"+getHeight());

        Log.e("custom","mBound.width():"+mBound.width());
        Log.e("custom","mBound.width():"+mBound.width());
        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText,getWidth()/2-mBound.width()/2,getHeight()/2+mBound.height()/2,mPaint);
    }


    private  String randomText(){

        Random random=new Random();
        Set<Integer> set=new HashSet<>();

        while(set.size()<4){
            int randomset=random.nextInt(10);
            set.add(randomset);
        }


        StringBuffer sb=new StringBuffer();

        for(Integer i:set){

            sb.append(""+i);
        }

        return sb.toString();
    }
}

