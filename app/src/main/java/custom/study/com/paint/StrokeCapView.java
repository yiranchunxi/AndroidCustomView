package custom.study.com.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/6/12.
 */

public class StrokeCapView extends View {

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

    public StrokeCapView(Context context) {
        super(context);
    }

    public StrokeCapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StrokeCapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {

        paint.setStrokeWidth(40);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        paint.setStrokeCap(Paint.Cap.BUTT);

        canvas.drawLine(50,50,400,50,paint);


        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(50,100,400,100,paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(50,150,400,150,paint);
    }
}
