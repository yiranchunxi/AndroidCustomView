package custom.study.com.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/14.
 */

public class MatrixTranslateView extends View {

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(200, 600);

    Matrix matrix=new Matrix();

    public MatrixTranslateView(Context context) {
        super(context);
    }

    public MatrixTranslateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MatrixTranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.reba);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        canvas.save();
        //canvas与操作步骤相反 如先trans 后rotate  写为先rotate后trans
        matrix.reset();
        matrix.postRotate(45,point1.x+bitmapWidth/2,point1.y+bitmapHeight/2);
        matrix.postTranslate(  200,0);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,point1.x,point1.y,paint);

        canvas.restore();

        canvas.save();
        matrix.reset();
        //matrix.postRotate(45,point2.x+bitmapWidth/2,point2.y+bitmapHeight/2);
        matrix.postSkew(-0.5f, 0, point2.x + bitmapWidth / 2, point2.y + bitmapHeight / 2);
        matrix.postTranslate(200, 0);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
