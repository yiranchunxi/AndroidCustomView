package custom.study.com.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/12.
 */

public class ColorMatrixColorFilterView extends View {

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

    Bitmap bitmap;

    public ColorMatrixColorFilterView(Context context) {
        super(context);
    }

    public ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    {
        bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.reba);
        // 使用 setColorFilter() 设置一个 ColorMatrixColorFilter
        // 用 ColorMatrixColorFilter.setSaturation() 把饱和度去掉
        //颜色矩阵
        ColorMatrix colorMatrix=new ColorMatrix();
        colorMatrix.setSaturation(0);

        ColorFilter colorFilter=new ColorMatrixColorFilter(colorMatrix);

        paint.setColorFilter(colorFilter);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,paint);
    }
}
