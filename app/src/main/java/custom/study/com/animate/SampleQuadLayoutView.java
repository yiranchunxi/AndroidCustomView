package custom.study.com.animate;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/26.
 */

public class SampleQuadLayoutView extends LinearLayout {

    SampleQuadView view;

    Button button;

    public SampleQuadLayoutView(Context context) {
        super(context);
    }

    public SampleQuadLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SampleQuadLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view=findViewById(R.id.sampleQuadView);
        button=findViewById(R.id.animateBt);


        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator objectAnimator=ObjectAnimator.ofInt(view,"dx",600);

                objectAnimator.setDuration(2000);



                objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator.setInterpolator(new LinearInterpolator());

                objectAnimator.start();

            }
        });
    }
}
