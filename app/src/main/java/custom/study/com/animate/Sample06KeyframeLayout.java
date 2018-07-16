package custom.study.com.animate;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/21.
 */

public class Sample06KeyframeLayout extends RelativeLayout {

    Sample08ObjectAnimatorView view;

    Button animateBt;


    public Sample06KeyframeLayout(Context context) {
        super(context);
    }

    public Sample06KeyframeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample06KeyframeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view=findViewById(R.id.objectAnimatorView);
        animateBt=findViewById(R.id.animateBt);


        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Keyframe keyframe1=Keyframe.ofFloat(0,0);

                Keyframe keyframe2=Keyframe.ofFloat(0.5f,100);
                Keyframe keyframe3=Keyframe.ofFloat(0.7f,90);
                Keyframe keyframe4=Keyframe.ofFloat(1,60);

                PropertyValuesHolder propertyValuesHolder=PropertyValuesHolder.ofKeyframe("progress",keyframe1,keyframe2,keyframe3,keyframe4);

                ObjectAnimator objectAnimator=ObjectAnimator.ofPropertyValuesHolder(view,propertyValuesHolder);
                objectAnimator.setDuration(5000);
                objectAnimator.setInterpolator(new FastOutSlowInInterpolator());
                objectAnimator.start();
            }
        });

    }
}
