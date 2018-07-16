package custom.study.com.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
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

public class CameraRotateFixedView extends View {

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    Point point1=new Point(200,200);

    Point point2=new Point(200,600);

    Camera camera=new Camera();

    Matrix matrix=new Matrix();


    public CameraRotateFixedView(Context context) {
        super(context);
    }

    public CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {

        bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.reba);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int bitmapWidth=bitmap.getWidth();
        int bitmapHeight=bitmap.getHeight();
        int center1X = point1.x + bitmapWidth / 2;
        int center1Y = point1.y + bitmapHeight / 2;

        int center2X = point2.x + bitmapWidth / 2;
        int center2Y = point2.y + bitmapHeight / 2;
        camera.save();
        camera.rotateX(-30);
        camera.getMatrix(matrix);
        camera.setLocation(0,0,-18);
        camera.applyToCanvas(canvas);
        camera.restore();

        matrix.preTranslate(-center1X,-center1Y);
        matrix.postTranslate(center1X,center1Y);

        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,point1.x,point1.y,paint);

        canvas.restore();



        camera.save();
        camera.rotateY(-45);
        camera.getMatrix(matrix);
        camera.setLocation(0,0,-8);
        camera.applyToCanvas(canvas);
        camera.restore();

        matrix.preTranslate(-center2X,-center2Y);
        matrix.postTranslate(center2X,center2Y);

        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,point2.x,point2.y,paint);

        canvas.restore();
    }
}
