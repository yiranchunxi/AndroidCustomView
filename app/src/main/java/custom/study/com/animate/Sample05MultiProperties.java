package custom.study.com.animate;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import custom.study.com.R;
import custom.study.com.Utils;

/**
 * Created by Administrator on 2018/6/20.
 */

public class Sample05MultiProperties extends ConstraintLayout {

    Button animateBt;
    ImageView imageView;
    boolean animated;

    public Sample05MultiProperties(Context context) {
        super(context);
    }

    public Sample05MultiProperties(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample05MultiProperties(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);



       // imageView.setScaleX(0);
       // imageView.setScaleY(0);
       // imageView.setImageAlpha(0);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!animated){

                    imageView.animate()
                            .translationX(Utils.dpToPixel(200))
                            .rotation(360)
                            .scaleX(1)
                            .scaleY(1)
                            .alpha(1);
                }else{
                    imageView.animate()
                            .translationX(0)
                            .rotation(0)
                            .scaleX(0)
                            .scaleY(0)
                            .alpha(0);

                }

                animated = !animated;
            }
        });
    }
}
