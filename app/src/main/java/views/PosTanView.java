package views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/7/4.
 */

public class PosTanView  extends View{

    private float currentValue ;     // 用于纪录当前的位置,取值范围[0,1]映射Path的整个长度

    private float[] pos;                // 当前点的实际位置
    private float[] tan;                // 当前点的tangent值,用于计算图片所需旋转的角度
    private Bitmap mBitmap;             // 箭头图片
    private Matrix mMatrix;             // 矩阵,用于对图片进行一些操作
    private int mViewWidth,mViewHeight;
    private Path path;
    private PathMeasure measure;

    private Paint paint;
    public PosTanView(Context context) {
        super(context);
    }

    public PosTanView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PosTanView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {

        pos=new float[2];
        tan=new float[2];

        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inSampleSize=2;
        mBitmap=BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher,options);

        mMatrix=new Matrix();

        path=new Path();



        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth=w/2;
        mViewHeight=h/2;
    }

    public void setCurrentValue(float currentValue) {
        this.currentValue = currentValue;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mViewWidth,mViewHeight);

        path.addCircle(0,0,mViewWidth*0.8f, Path.Direction.CW);
        measure=new PathMeasure(path,false);

        /*Log.e("test",measure.getLength()+"");
        measure.getPosTan(measure.getLength()*currentValue,pos,tan);

        mMatrix.reset();
        Log.e("test",pos[1]+"===="+pos[0]);
        //Math.atan2(tan[1],tan[0] 算出的是弧度
        float degrees= (float) (Math.atan2(tan[1],tan[0])*180/Math.PI);     // 计算图片旋转角度
        Log.e("test","degrees"+degrees);

        mMatrix.postRotate(degrees+90,mBitmap.getWidth()/2,mBitmap.getHeight()/2);


        mMatrix.postTranslate(pos[0]-mBitmap.getWidth()/2,pos[1]-mBitmap.getHeight()/2);

        canvas.drawPath(path,paint);
        canvas.drawBitmap(mBitmap,mMatrix,paint);*/



        // 获取当前位置的坐标以及趋势的矩阵
        measure.getMatrix(measure.getLength() * currentValue, mMatrix, PathMeasure.TANGENT_MATRIX_FLAG | PathMeasure.POSITION_MATRIX_FLAG);

        mMatrix.preTranslate(-mBitmap.getWidth() / 2, -mBitmap.getHeight() / 2);   // <-- 将图片绘制中心调整到与当前点重合(注意:此处是前乘pre)

        canvas.drawPath(path, paint);                                   // 绘制 Path
        canvas.drawBitmap(mBitmap, mMatrix, paint);

    }
}
