package custom.study.com.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/6/19.
 */

public class AfterOnDrawForegroundView extends AppCompatImageView {

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

    public AfterOnDrawForegroundView(Context context) {
        super(context);
    }

    public AfterOnDrawForegroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AfterOnDrawForegroundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    {
        paint.setTextSize(60);
    }


    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);

        paint.setColor(Color.parseColor("#f44336"));

        canvas.drawRect(0, 40, 200, 120, paint);
        paint.setColor(Color.WHITE);
        canvas.drawText("New", 20, 100, paint);
    }
}
