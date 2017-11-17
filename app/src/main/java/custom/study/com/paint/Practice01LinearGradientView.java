package custom.study.com.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/28.
 */

public class Practice01LinearGradientView extends View {

    private int type=1;
    Paint paint;
    Shader shader;
    public Practice01LinearGradientView(Context context) {
        super(context);
        paint=new Paint();
    }

    public Practice01LinearGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
    }

    public Practice01LinearGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
    }
    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.reset();

        if(type==1){
            shader=new LinearGradient(100,100,150,150, Color.parseColor("#E91E63"),Color.parseColor("#2196F3"),Shader.TileMode.CLAMP);
        }else if(type==2){
            shader=new LinearGradient(100,100,150,150, Color.parseColor("#E91E63"),Color.parseColor("#2196F3"),Shader.TileMode.MIRROR);
        }else if(type==3) {
            shader = new LinearGradient(100, 100, 150, 150, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);
        }

        paint.setShader(shader);
       // canvas.drawCircle(300,300,200,paint);
        canvas.drawRect(100,100,300,300,paint);
    }

    public void setType(int type) {
        this.type = type;
    }

}
