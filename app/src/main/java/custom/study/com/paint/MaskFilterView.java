package custom.study.com.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/12.
 */

public class MaskFilterView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    public MaskFilterView(Context context) {
        super(context);
    }

    public MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.reba);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter
        // 第一个：NORMAL
        paint.setMaskFilter(new BlurMaskFilter(50,BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(bitmap, 100, 50, paint);

        // 第二个：INNER
        paint.setMaskFilter(new BlurMaskFilter(50,BlurMaskFilter.Blur.INNER));
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, 50, paint);

        // 第三个：OUTER
        paint.setMaskFilter(new BlurMaskFilter(50,BlurMaskFilter.Blur.OUTER));
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() + 100, paint);

        // 第四个：SOLID
        paint.setMaskFilter(new BlurMaskFilter(50,BlurMaskFilter.Blur.SOLID));
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, bitmap.getHeight() + 100, paint);
    }
}