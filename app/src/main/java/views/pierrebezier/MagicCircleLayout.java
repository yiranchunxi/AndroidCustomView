package views.pierrebezier;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/7/3.
 */

public class MagicCircleLayout extends RelativeLayout {


    MagicCircleN view;

    Button animateBt;
    public MagicCircleLayout(Context context) {
        super(context);
    }

    public MagicCircleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MagicCircleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        view=findViewById(R.id.magic_circlen);

        animateBt=findViewById(R.id.animateBt);


        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                view.startAnimation();
            }
        });

    }
}
