package custom.study.com.animate;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/20.
 */

public class Sample03OfObjectLayout extends RelativeLayout {

    Sample03OfObjectView view;
    Button animateBt;

    public Sample03OfObjectLayout(Context context) {
        super(context);
    }

    public Sample03OfObjectLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample03OfObjectLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Sample03OfObjectView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);


        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator objectAnimator=ObjectAnimator.ofObject(view,"position",new PointFEvaluator()
                ,new PointF(0,0),new PointF(1,1));

                objectAnimator.setInterpolator(new LinearInterpolator());
                objectAnimator.setDuration(2000);
                objectAnimator.start();


            }
        });
    }


    private class PointFEvaluator implements TypeEvaluator<PointF>{

        PointF newPoint = new PointF();
        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {

            float x=startValue.x+((endValue.x-startValue.x)*fraction);

            float y=startValue.y+((endValue.y-startValue.y)*fraction);

            newPoint.set(x,y);

            return newPoint;
        }
    }
}
