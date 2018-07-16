package custom.study.com.matrix;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/14.
 */

public class FlipboardView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Camera camera = new Camera();
    int degree;
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 180);


    public FlipboardView(Context context) {
        super(context);
    }

    public FlipboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.reba);

        animator.setDuration(2500);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    @SuppressWarnings("unused")
    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth=bitmap.getWidth();
        int bitmapHeight=bitmap.getHeight();

        int centerX=getWidth()/2;

        int centerY=getHeight()/2;

        int x=centerX-bitmapWidth/2;

        int y=centerY-bitmapHeight/2;


        // 第一遍绘制：上半部分 clipRect 保留上半部分
        canvas.save();

        canvas.clipRect(0,0,getWidth(),centerY);
        canvas.drawBitmap(bitmap,x,y,paint);
        canvas.restore();


        // 第二遍绘制：下半部分
        canvas.save();

        if (degree < 90) {
            //保留下半部分
            canvas.clipRect(0, centerY, getWidth(), getHeight());
        } else {
            //保留上半部分
            canvas.clipRect(0, 0, getWidth(), centerY);
        }
        camera.save();

        canvas.translate(centerX, centerY);
        camera.rotateX(degree);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        camera.restore();

        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();
    }
}
