package custom.study.com.measure;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;


/**
 * Created by Administrator on 2018/6/21.
 */

public class Sample01SquareImageView extends AppCompatImageView {



    public Sample01SquareImageView(Context context) {
        super(context);
    }

    public Sample01SquareImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01SquareImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width=getMeasuredWidth();

        int height=getMeasuredHeight();

        if(width>height){
            width=height;
        }else{
            height=width;
        }

        setMeasuredDimension(width,height);
    }
}
