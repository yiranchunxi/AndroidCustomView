package custom.study.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.jaeger.library.StatusBarUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/28.
 */

public class IndexActivity extends Activity {

    @Nullable @Bind(R.id.btn_drawxxx)
    Button btn_drawxxx;

    @Nullable @Bind(R.id.btn_paint) Button btn_paint;

    @Nullable @Bind(R.id.btn_text) Button btn_text;

    @Nullable @Bind(R.id.btn_matrix) Button btn_matrix;


    @Nullable @Bind(R.id.btn_draw) Button btn_draw;

    @Nullable @Bind(R.id.btn_animate) Button btn_animate;

    @Nullable @Bind(R.id.btn_views) Button btn_views;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_index);
        StatusBarUtil.setColor(IndexActivity.this, getResources().getColor(R.color.colorPrimaryRed),0);

        ButterKnife.bind(this);

        btn_drawxxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IndexActivity.this,CustomViewActivity.class);
                startActivity(intent);
            }
        });


        btn_paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IndexActivity.this,PaintActivity.class);
                startActivity(intent);
            }
        });


        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IndexActivity.this,TextActivity.class);
                startActivity(intent);
            }
        });


        btn_matrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IndexActivity.this,MatrixActivity.class);
                startActivity(intent);
            }
        });
        btn_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IndexActivity.this,DrawActivity.class);
                startActivity(intent);
            }
        });

        btn_animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IndexActivity.this,AnimateActivity.class);
                startActivity(intent);
            }
        });


        btn_views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IndexActivity.this,ViewsActivity.class);
                startActivity(intent);
            }
        });

    }
}
