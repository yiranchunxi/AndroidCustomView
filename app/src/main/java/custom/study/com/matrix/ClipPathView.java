package custom.study.com.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/14.
 */

public class ClipPathView extends View {


    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    Path path1=new Path();
    Path path2=new Path();
    Point point1=new Point(200,200);
    Point point2=new Point(200,600);

    public ClipPathView(Context context) {
        super(context);
    }

    public ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        //FillType 用来区分清除路径内还是外
        bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.reba);

        path1.addCircle(point1.x + 200, point1.y + 200, 150, Path.Direction.CCW);

        path2.setFillType(Path.FillType.INVERSE_WINDING);
        path2.addCircle(point2.x + 200, point2.y + 200, 150, Path.Direction.CCW);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.save();
        canvas.clipPath(path1);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        //canvas.drawPath(path1,paint);
        canvas.restore();

        canvas.save();
        canvas.clipPath(path2);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        //canvas.drawPath(path2,paint);
        canvas.restore();
    }
}
