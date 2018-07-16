package views;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import custom.study.com.R;
import custom.study.com.animate.SampleQuadView;

/**
 * Created by Administrator on 2018/6/26.
 */

public class PosTanLayoutView extends LinearLayout {

    PosTanView view;

    Button button;

    public PosTanLayoutView(Context context) {
        super(context);
    }

    public PosTanLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PosTanLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view=findViewById(R.id.pos_tan);
        button=findViewById(R.id.animateBt);


        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(view,"currentValue",0,1);

                objectAnimator.setDuration(5000);



                objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
                objectAnimator.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator.setInterpolator(new LinearInterpolator());

                objectAnimator.start();

            }
        });
    }
}
