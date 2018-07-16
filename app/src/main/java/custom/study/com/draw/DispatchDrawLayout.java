package custom.study.com.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2018/6/19.
 */

public class DispatchDrawLayout extends LinearLayout {

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

    Pattern pattern=new Pattern();
    public DispatchDrawLayout(Context context) {
        super(context);
    }

    public DispatchDrawLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchDrawLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        pattern.draw(canvas);
    }

    private  class Pattern{

        private static final  float PATTERN_RATIO=5f/6;

        Paint patternPaint=new Paint(Paint.ANTI_ALIAS_FLAG);


        Pattern.Spot[] spots;

        {
            patternPaint.setColor(Color.parseColor("#A0E91E63"));
        }

        public Pattern() {

            spots=new Pattern.Spot[4];

            spots[0] = new Pattern.Spot(0.24f, 0.3f, 0.026f);
            spots[1] = new Pattern.Spot(0.69f, 0.25f, 0.067f);
            spots[2] = new Pattern.Spot(0.32f, 0.6f, 0.067f);
            spots[3] = new Pattern.Spot(0.62f, 0.78f, 0.083f);
        }


        private void draw(Canvas canvas){

            int repitition=(int) Math.ceil((float) getWidth() / getHeight());

            for(int i=0;i<spots.length*repitition;i++){

                Pattern.Spot spot=spots[i%spots.length];
                canvas.drawCircle(i / spots.length * getHeight() * PATTERN_RATIO + spot.relativeX * getHeight(), spot.relativeY * getHeight(), spot.relativeSize * getHeight(), patternPaint);
            }

        }

        private class Spot{

            private  float relativeX;
            private  float relativeY;

            private  float relativeSize;


            public Spot(float relativeX, float relativeY, float relativeSize) {
                this.relativeX = relativeX;
                this.relativeY = relativeY;
                this.relativeSize = relativeSize;
            }
        }
    }
}
