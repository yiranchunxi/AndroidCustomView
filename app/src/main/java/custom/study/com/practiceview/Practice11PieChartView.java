package custom.study.com.practiceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/27.
 */

public class Practice11PieChartView extends View {

    Paint paint;
    public Practice11PieChartView(Context context) {
        super(context);
        paint=new Paint();
    }

    public Practice11PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
    }

    public Practice11PieChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //综合练习
        //练习内容：使用各种 Canvas.drawXXX() 方法画饼图

         paint.setColor(Color.BLUE);
         RectF rectF=new RectF(getWidth()/2-200,getHeight()/2-200,getWidth()/2+200,getHeight()/2+200);
         canvas.drawArc(rectF,75,105,true,paint);

         paint.setColor(Color.GREEN);
         canvas.drawArc(rectF,15,60,true,paint);

         paint.setColor(Color.GRAY);
         canvas.drawArc(rectF,5,10,true,paint);

         paint.setColor(Color.parseColor("#FF00FF"));

         canvas.drawArc(rectF,-5,10,true,paint);

         paint.setColor(Color.YELLOW);
         canvas.drawArc(rectF,-60,55,true,paint);

         RectF rectF1=new RectF(getWidth()/2-210,getHeight()/2-210,getWidth()/2+190,getHeight()/2+190);

        paint.setColor(Color.RED);
        canvas.drawArc(rectF1,-180,120,true,paint);
    }
}
