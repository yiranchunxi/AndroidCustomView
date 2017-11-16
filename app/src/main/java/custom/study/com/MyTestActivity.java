package custom.study.com;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import views.MyLinearLayout;

/**
 * Created by Administrator on 2017/6/7.
 */

public class MyTestActivity  extends Activity{

    private Button button;
    private MyLinearLayout ll_container;
    private  final  String TAG="MyTestActivity";
    // 分别记录上次滑动的坐标
    private int mLastX = 0;
    private int mLastY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_test);

        ll_container= (MyLinearLayout) findViewById(R.id.ll_container);
        button= (Button) findViewById(R.id.button);
/*
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ll_container.requestDisallowInterceptTouchEvent(true);

                return  true;
            }
        });*/
    }





}
