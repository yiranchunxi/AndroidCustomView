package custom.study.com.practiceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/26.
 */

public class Practice5DrawOvalView extends View {
    Paint paint;
    public Practice5DrawOvalView(Context context) {
        super(context);
        paint=new Paint();
    }

    public Practice5DrawOvalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
    }

    public Practice5DrawOvalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
    }
   /* 如题，这二个函数的直接传坐标的方法要求手机SDK版本在21以上才行，21以下的是没有效果的，
    要兼容低版本的话需要使用参数比较少的重载方法，
    先 new RectF，传入坐标，
    然后再将 Rectf 传入 draw 方法。这个问题在教程里没有提到，
    新手可能会不知道该怎么处理。*/
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 练习内容：使用 canvas.drawOval() 方法画椭圆

        paint.setStyle(Paint.Style.FILL);
        RectF rectF=new RectF(50,50,350,200);
        canvas.drawOval(rectF,paint);
        //canvas.drawOval(50,50,350,200,paint);

        paint.setStyle(Paint.Style.STROKE);

        canvas.drawOval(50,400,350,550,paint);
    }
}
