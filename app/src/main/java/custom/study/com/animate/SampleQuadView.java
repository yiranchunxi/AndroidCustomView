package custom.study.com.animate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/6/26.
 */

public class SampleQuadView  extends View{




    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);


    Path path=new Path();

    private int mItemWaveLength = 600; //波长
    private int dx;

    public SampleQuadView(Context context) {
        super(context);
    }

    public SampleQuadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SampleQuadView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {

        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }


    public void setDx(int dx) {
        this.dx = dx;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        path.reset();

        int oriY=300;

        int halfLengtg=mItemWaveLength/2;

        path.moveTo(-mItemWaveLength+dx,oriY);


        for(int i=-mItemWaveLength;i<getWidth()+mItemWaveLength;i+=mItemWaveLength){

            path.rQuadTo(halfLengtg/2,-100,halfLengtg,0);
            path.rQuadTo(halfLengtg/2,100,halfLengtg,0);


        }

        path.lineTo(getWidth(),getHeight());
        path.lineTo(0,getHeight());
        path.close();


        canvas.drawPath(path,paint);
    }
}
