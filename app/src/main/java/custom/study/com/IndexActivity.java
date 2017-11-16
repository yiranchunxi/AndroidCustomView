package custom.study.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/28.
 */

public class IndexActivity extends Activity {

    @Nullable @Bind(R.id.btn_drawxxx)
    Button btn_drawxxx;

    @Nullable @Bind(R.id.btn_paint) Button btn_paint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_index);
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
    }
}
