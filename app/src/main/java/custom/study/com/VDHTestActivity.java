package custom.study.com;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.baidu.mapapi.map.BaiduMap;

import views.VDHLayout;
import views.VDHLayoutTest;
import widget.MapContainer;

/**
 * Created by Administrator on 2017/6/26.
 */

public class VDHTestActivity extends Activity {
    private com.baidu.mapapi.map.TextureMapView mapView;
    private BaiduMap mBaiduMap;
    private MapContainer map_container;
    private VDHLayoutTest vdhl_container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vdhlayout_test);
        mapView = (com.baidu.mapapi.map.TextureMapView) findViewById(R.id.mapView);

        map_container= (MapContainer) findViewById(R.id.map_container);
        vdhl_container= (VDHLayoutTest) findViewById(R.id.vdhl_container);
        map_container.setScrollView(vdhl_container);
        mBaiduMap=mapView.getMap();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mapView!=null){
            mapView.onPause();
        }
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        if(mapView!=null){
            mapView.onResume();
        }
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(mapView!=null){
            mapView.onSaveInstanceState(outState);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mapView!=null){

            mapView.onDestroy();
        }

    }
}
