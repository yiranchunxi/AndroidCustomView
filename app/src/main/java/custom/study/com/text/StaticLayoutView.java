package custom.study.com.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/6/12.
 */

public class StaticLayoutView extends View {

    TextPaint textPaint=new TextPaint(Paint.ANTI_ALIAS_FLAG);

    String text="Hello\nHenCoder";

    StaticLayout staticLayout;

    public StaticLayoutView(Context context) {
        super(context);
    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {

        textPaint.setTextSize(60);

        staticLayout = new StaticLayout(text, textPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(50, 40);
        staticLayout.draw(canvas);
        canvas.restore();
    }
}
