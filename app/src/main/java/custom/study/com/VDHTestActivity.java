package custom.study.com;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;



import views.VDHLayout;
import views.VDHLayoutTest;
import widget.MapContainer;

/**
 * Created by Administrator on 2017/6/26.
 */

public class VDHTestActivity extends Activity {

    private MapContainer map_container;
    private VDHLayoutTest vdhl_container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vdhlayout_test);

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();

    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}
