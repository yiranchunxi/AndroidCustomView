package custom.study.com.animate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import custom.study.com.R;

/**
 * Created by Administrator on 2018/6/20.
 */

public class Sample02Rotation extends RelativeLayout {

    Button animateBt;

    ImageView imageView;

    int state = 0;

    public Sample02Rotation(Context context) {
        super(context);
    }

    public Sample02Rotation(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample02Rotation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);



        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                /*switch (state){

                    case 0:
                        imageView.animate().rotation(180);
                        break;

                    case 1:
                        imageView.animate().rotation(0);
                        break;

                    case 2:
                        imageView.animate().rotationX(180);
                        break;

                    case 3:
                        imageView.animate().rotationX(0);
                        break;
                    case 4:
                        imageView.animate().rotationY(180);
                        break;

                    case 5:
                        imageView.animate().rotationY(0);
                        break;
                }

                state++;

                if (state == 6) {
                    state = 0;
                }*/

                /*switch (state) {
                    case 0:
                        imageView.animate().alpha(0);
                        break;
                    case 1:
                        imageView.animate().alpha(1);
                        break;
                }
                state++;
                if (state == 2) {
                    state = 0;
                }*/

                switch (state) {
                    case 0:
                        imageView.animate().scaleX(1.5f);
                        break;
                    case 1:
                        imageView.animate().scaleX(1);
                        break;
                    case 2:
                        imageView.animate().scaleY(.5f);
                        break;
                    case 3:
                        imageView.animate().scaleY(1);
                        break;
                }
                state++;
                if (state == 4) {
                    state = 0;
                }
            }
        });
    }
}
