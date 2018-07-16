package custom.study.com.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/14.
 */

public class CameraRotateView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 100);
    Point point2 = new Point(200, 600);

    Camera camera=new Camera();

    public CameraRotateView(Context context) {
        super(context);
    }

    public CameraRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {

        bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.reba);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        camera.save();
        camera.rotateX(45);
        camera.setLocation(0, 0, -18);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.drawBitmap(bitmap,point1.x,point1.y,paint);
        canvas.restore();

        canvas.save();
        camera.save();
        camera.rotateY(-45);
        camera.setLocation(0, 0, -18);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
