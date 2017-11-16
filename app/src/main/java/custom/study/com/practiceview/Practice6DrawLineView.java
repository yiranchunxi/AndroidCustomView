package custom.study.com.practiceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/26.
 */

public class Practice6DrawLineView extends View {

    Paint paint;
    public Practice6DrawLineView(Context context) {
        super(context);
        paint=new Paint();
    }

    public Practice6DrawLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
    }

    public Practice6DrawLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 练习内容：使用 canvas.drawLine() 方法画直线
        paint.setStrokeWidth(20);
        canvas.drawLine(100,100,500,500,paint);

        float[] points = {20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120, 120, 150, 20, 250, 20, 150, 20, 150, 120, 250, 20, 250, 120, 150, 120, 250, 120};
        canvas.drawLines(points, paint);
    }
}
