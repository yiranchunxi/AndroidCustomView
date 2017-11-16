package custom.study.com.practiceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/26.
 */

public class Practice3DrawRectView extends View {

    private Paint paint;
    public Practice3DrawRectView(Context context) {
        super(context);
        paint=new Paint();
    }

    public Practice3DrawRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
    }

    public Practice3DrawRectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);

        canvas.drawRect(100,100,500,500,paint);


        paint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(100,600,500,1000,paint);


        canvas.drawRoundRect(600,100,800,1000,50,50,paint);
    }
}
