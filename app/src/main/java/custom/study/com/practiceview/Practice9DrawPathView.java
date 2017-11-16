package custom.study.com.practiceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/26.
 */

public class Practice9DrawPathView extends View {

    Paint paint;
    Path  path;
    public Practice9DrawPathView(Context context) {
        super(context);
        paint=new Paint();
        path=new Path();
    }

    public Practice9DrawPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
        path=new Path();
    }

    public Practice9DrawPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
        path=new Path();
    }

    //drawPath() 一般是在绘制组合图形时才会用到的。 addArc() 只是一个直接使用了 forceMoveTo = true 的简化版 arcTo()
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //练习内容：使用 canvas.drawPath() 方法画心形

        path.addArc(200,200,400,400,-225,225);
        path.arcTo(400,200,600,400,-180,225,false);
        //path.arcTo(400,200,600,400,-180,225,false);

        path.lineTo(400, 542);
        canvas.drawPath(path,paint);
    }
}
