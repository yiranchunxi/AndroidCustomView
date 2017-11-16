package custom.study.com;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/6/9.
 */

public class AnimationActivity  extends Activity{

    private Button animation_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom6);

        animation_btn= (Button) findViewById(R.id.button4);

        animation_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimate();
            }
        });
    }

    private  void performAnimate(){

        ViewWrapper wrapper=new ViewWrapper(animation_btn);
        ObjectAnimator.ofInt(wrapper,"width",500).setDuration(5000).start();
    }

    private static  class ViewWrapper{


        private View mTarget;
        public ViewWrapper(View target){
            mTarget=target;
        }

        public int getWidth(){

            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width){

            mTarget.getLayoutParams().width=width;
            mTarget.requestLayout();
        }
    }
}
