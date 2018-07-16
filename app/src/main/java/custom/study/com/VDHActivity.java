package custom.study.com;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import views.VDHLayout;
import widget.MapContainer;

/**
 * Created by Administrator on 2017/6/26.
 */

public class VDHActivity extends Activity {

    private MapContainer map_container;
    private LinearLayout ll_a;
    private VDHLayout vdhl_container;
    private TextView drag_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vdhlayout);
        //mapView = (com.baidu.mapapi.map.TextureMapView) findViewById(R.id.mapView);

      //  mapView.onCreate(savedInstanceState); // 此方法必须重写
       // mBaiduMap=mapView.getMap();
        /*if (aMap == null) {
            aMap = mapView.getMap();
        }*/
        ll_a= (LinearLayout) findViewById(R.id.ll_a);
        map_container= (MapContainer) findViewById(R.id.map_container);
        map_container.setScrollView(ll_a);
        drag_bar= (TextView) findViewById(R.id.drag_bar);
        vdhl_container= (VDHLayout) findViewById(R.id.vdhl_container);

        vdhl_container.setEdgeListner(new VDHLayout.EdgeListner() {
            @Override
            public void edge(int type) {
                 if(type==0){

                     drag_bar.setText("top");
                 }else{

                     drag_bar.setText("bottom");
                 }
            }
        });
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
