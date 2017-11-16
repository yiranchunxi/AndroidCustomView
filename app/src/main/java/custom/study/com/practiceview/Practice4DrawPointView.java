package custom.study.com.practiceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/26.
 */

public class Practice4DrawPointView extends View {
    Paint paint;
    public Practice4DrawPointView(Context context) {
        super(context);
        paint=new Paint();
    }

    public Practice4DrawPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
    }

    public Practice4DrawPointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //  练习内容：使用 canvas.drawPoint() 方法画点
        //  一个圆点，一个方点
        //  圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        paint.setStrokeWidth(20);

        paint.setStrokeCap(Paint.Cap.ROUND);

        canvas.drawPoint(250,250,paint);

        paint.setStrokeWidth(20);
        paint.setStrokeCap(Paint.Cap.SQUARE);


        canvas.drawPoint(350,350,paint);


        /*
        同样是画点，它和 drawPoint() 的区别是可以画多个点。
        pts 这个数组是点的坐标，每两个成一对；
        offset 表示跳过数组的前几个数再开始记坐标；
        count 表示一共要绘制几个点。说这么多你可能越读越晕，*/
        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        //canvas.drawPoints(points,paint);
        canvas.drawPoints(points,2,10,paint);
    }
}
