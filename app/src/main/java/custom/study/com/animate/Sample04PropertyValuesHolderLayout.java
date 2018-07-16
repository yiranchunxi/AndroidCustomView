package custom.study.com.animate;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/21.
 * view.animate()
         .scaleX(1)
         .scaleY(1)
         .alpha(1);
 * 对于 ObjectAnimator，是不能这么用的。不过你可以使用 PropertyValuesHolder 来同时在一个动画中改变多个属性。
 */

public class Sample04PropertyValuesHolderLayout extends RelativeLayout {

    View view;

    Button animateBt;

    public Sample04PropertyValuesHolderLayout(Context context) {
        super(context);
    }

    public Sample04PropertyValuesHolderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample04PropertyValuesHolderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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
                PropertyValuesHolder holder1=PropertyValuesHolder.ofFloat("scaleX",0,1);
                PropertyValuesHolder holder2=PropertyValuesHolder.ofFloat("scaleY",0,1);
                PropertyValuesHolder holder3=PropertyValuesHolder.ofFloat("alpha",0,1);


                ObjectAnimator.ofPropertyValuesHolder(view,holder1,holder2,holder3).start();
            }
        });

    }
}
