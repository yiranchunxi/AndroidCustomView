package custom.study.com.practiceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/26.
 */

public class Practice2DrawCircleView extends View {

    private Paint paint;
    public Practice2DrawCircleView(Context context) {
        super(context);
        paint=new Paint();
    }

    public Practice2DrawCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
    }

    public Practice2DrawCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
    }
    //比如图形的颜色、空心实心这些，你不管是画圆还是画方都有可能用到的，这些信息则是统一放在 paint 参数里的。
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        //练习内容：使用 canvas.drawCircle() 方法画圆
        //一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        paint.setColor(Color.RED);
        canvas.drawCircle(200,200,100,paint);

        paint.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(200,600,100,paint);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(500,200,100,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(500,600,100,paint);
    }
}
