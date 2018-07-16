package custom.study.com.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/6/19.
 */

public class BeforeOnDrawView extends AppCompatTextView {

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

    RectF bounds=new RectF();

    public BeforeOnDrawView(Context context) {
        super(context);
    }

    public BeforeOnDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeOnDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {

        paint.setColor(Color.parseColor("#FFC107"));
    }


    @Override
    protected void onDraw(Canvas canvas) {

        Layout layout=getLayout();

        bounds.left=layout.getLineLeft(1);
        bounds.top=layout.getLineTop(1);
        bounds.right=layout.getLineRight(1);
        bounds.bottom=layout.getLineBottom(1);
        canvas.drawRect(bounds,paint);
        bounds.left = layout.getLineLeft(layout.getLineCount() - 4);
        bounds.right = layout.getLineRight(layout.getLineCount() - 4);
        bounds.top = layout.getLineTop(layout.getLineCount() - 4);
        bounds.bottom = layout.getLineBottom(layout.getLineCount() - 4);
        canvas.drawRect(bounds, paint);

        super.onDraw(canvas);
    }
}
