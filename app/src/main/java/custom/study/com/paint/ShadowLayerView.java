package custom.study.com.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/6/12.
 */

public class ShadowLayerView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);


    public ShadowLayerView(Context context) {
        super(context);
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {


        paint.setShadowLayer(10, 0, 0, Color.RED);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setTextSize(120);
        canvas.drawText("Hello HenCoder", 50, 200, paint);
    }
}
