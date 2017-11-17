package custom.study.com.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/7/28.
 */

public class Practice02RadialGradientView extends View {


    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice02RadialGradientView(Context context) {
        super(context);
    }

    public Practice02RadialGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02RadialGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        Log.e("test",getWidth()/2+"===="+getHeight()/2);
        paint.setShader(new RadialGradient(getWidth()/2,300,200,Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"),Shader.TileMode.CLAMP));
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth()/2,getHeight()/2,200,paint);
    }



}
