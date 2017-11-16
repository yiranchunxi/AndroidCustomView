package custom.study.com.practiceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/26.
 */

public class Practice7DrawArcView extends View {

    Paint paint;
    public Practice7DrawArcView(Context context) {
        super(context);
        paint=new Paint();
    }

    public Practice7DrawArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
    }

    public Practice7DrawArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint=new Paint();


    }
    /**   r=a(1-sinθ)
     * drawArc() 是使用一个椭圆来描述弧形的。
    left, top, right, bottom 描述的是这个弧形所在的椭圆；
    startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
    sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，
    如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。*/
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
       // canvas.drawArc(200, 100, 800, 500, 20, 140, false, paint); // 绘制弧形
        canvas.drawArc(50,50,200,150,30,90,false,paint);


        canvas.drawArc(50,50,200,150,0,-90,false,paint);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawArc(50,200,300,400,30,90,true,paint);

        canvas.drawArc(50,200,300,400,-30,-90,true,paint);

        canvas.drawArc(50,400,300,600,-120,-150,false,paint);

        canvas.drawArc(50,600,300,800,-120,-150,true,paint);


        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        paint.setColor(Color.parseColor("#ED6C00"));
        //paint.setAntiAlias(true);
        RectF rectF=new RectF(getWidth()/2-200,getHeight()/2-200,getWidth()/2+200,getHeight()/2+200);

        //canvas.drawArc(rectF,0,360,false,paint);
        paint.setStrokeWidth(0);
        canvas.drawArc(rectF,0,360,false,paint);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(0);
        canvas.drawCircle(getWidth()/2+200,getHeight()/2,10,paint);
    }
}
