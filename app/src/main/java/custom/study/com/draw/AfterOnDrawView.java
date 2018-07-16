package custom.study.com.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/6/19.
 */

public class AfterOnDrawView extends AppCompatImageView {

    public static final boolean DEBUG=true;

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

    public AfterOnDrawView(Context context) {
        super(context);
    }

    public AfterOnDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AfterOnDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setColor(Color.parseColor("#FFC107"));
        paint.setTextSize(28);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(DEBUG){
            // 在 debug 模式下绘制出 drawable 的尺寸信息
            Drawable drawable=getDrawable();
            canvas.save();
            canvas.concat(getImageMatrix());
            Rect bounds=drawable.getBounds();
            String inch=bounds.width()+"x"+bounds.height();
            canvas.drawText(inch,20,40,paint);
            canvas.restore();

        }
    }
}
