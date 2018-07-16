package custom.study.com.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/12.
 */

public class LightingColorFilterView extends View {

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    public LightingColorFilterView(Context context) {
        super(context);
    }

    public LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {

        bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.reba);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 第一个 LightingColorFilter：去掉红色部分
        paint.setColorFilter(new LightingColorFilter(0x00ffff, 0x000000));
        canvas.drawBitmap(bitmap,0,0,paint);

        // 第二个 LightingColorFilter：增强绿色部分
        paint.setColorFilter(new LightingColorFilter(0xffffff,0x003000));
        canvas.drawBitmap(bitmap,0,bitmap.getHeight()+100,paint);
    }
}
