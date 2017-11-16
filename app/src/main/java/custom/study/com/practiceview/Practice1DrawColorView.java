package custom.study.com.practiceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/26.
 */

public class Practice1DrawColorView extends View {
    public Practice1DrawColorView(Context context) {
        super(context);
    }

    public Practice1DrawColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice1DrawColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#ED6C00"));

        // 练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色
        // 黄色： Color.YELLOW
    }
}
