package custom.study.com.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/14.
 */

public class ClipRectView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public ClipRectView(Context context) {
        super(context);
    }

    public ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {

        bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.reba);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left=(getWidth()-bitmap.getWidth())/2;

        int top=(getHeight()-bitmap.getHeight())/2;


        canvas.save();

        canvas.clipRect(left+50,top+50,left+300,top+300);
        canvas.drawBitmap(bitmap,left,top,paint);
        canvas.restore();

    }
}
