package custom.study.com.practiceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/26.
 */

public class Practice1DrawColorView extends View {
    Paint paint=new Paint();
    Path path=new Path();
    public Practice1DrawColorView(Context context) {
        super(context);
    }

    public Practice1DrawColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice1DrawColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     *  图形简单时，使用 drawCircle() drawRect() 等方法来直接绘制；图形复杂时，使用 drawPath() 来绘制自定义图形。
      */


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE); //来把绘制模式改为画线模式。
        paint.setStrokeWidth(20); // 线条宽度为 20 像素
        paint.setAntiAlias(true);
        //paint.setTextSize(32);
        canvas.drawRect(100,100,300,300,paint);
        canvas.drawColor(Color.parseColor("#88880000"));

        paint.setStrokeWidth(2);

        path.lineTo(100,100);
        path.rLineTo(100,0);

        canvas.drawPath(path,paint);

        path.moveTo(200,200);

        path.quadTo(300,10,400,200);

        canvas.drawPath(path,paint);
        // 练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色
        // 黄色： Color.YELLOW
    }
}
