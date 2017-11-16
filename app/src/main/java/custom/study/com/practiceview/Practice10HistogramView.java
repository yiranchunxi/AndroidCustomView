package custom.study.com.practiceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/27.
 */

public class Practice10HistogramView extends View {

    Paint paint;
    public Practice10HistogramView(Context context) {
        super(context);
        paint=new Paint();
    }

    public Practice10HistogramView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
    }

    public Practice10HistogramView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画背景
        canvas.drawColor(Color.parseColor("#ED6C00"));
        //画纵坐标
        paint.setColor(Color.WHITE);
        canvas.drawLine(25,25,25,400,paint);
        //画横坐标
        canvas.drawLine(25,400,700,400,paint);

        //画人名
        paint.setAntiAlias(true);
        paint.setTextSize(18);
        canvas.drawText("Proyo",50,425,paint);

        canvas.drawText("CB",150,425,paint);

        canvas.drawText("ICS",250,425,paint);
        canvas.drawText("JB",350,425,paint);
        canvas.drawText("KITKAT",450,425,paint);
        canvas.drawText("L",550,425,paint);
        canvas.drawText("m",650,425,paint);


        //画矩形
        paint.setColor(Color.GREEN);

        canvas.drawRect(50,395,125,400,paint);
        canvas.drawRect(150,380,225,400,paint);
        canvas.drawRect(250,380,325,400,paint);
        canvas.drawRect(350,300,425,400,paint);
        canvas.drawRect(450,200,525,400,paint);
        canvas.drawRect(550,100,625,400,paint);
        canvas.drawRect(650,50,725,400,paint);
    }
}
