package custom.study.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import views.SlideCutListView;

/**
 * Created by Administrator on 2017/6/7.
 */

public class EventDispatchActivity extends FragmentActivity implements SlideCutListView.RemoveListener

{

    private SlideCutListView slideCutListView ;

    private ArrayAdapter<String> adapter;
    private List<String> dataSourceList = new ArrayList<String>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dispatch_event);

        init();
    }

    private void init() {
        slideCutListView= (SlideCutListView) findViewById(R.id.slideCutListView);

        slideCutListView.setmRemoveListener(this);

        for(int i=0;i<20;i++){

            dataSourceList.add("滑动删除"+i);

        }

        adapter=new ArrayAdapter<String>(this,R.layout.item_dispatch_event,R.id.list_item,dataSourceList);

        slideCutListView.setAdapter(adapter);


        slideCutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(EventDispatchActivity.this, dataSourceList.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void removeItem(SlideCutListView.RemoveDirection direction, int position) {
        adapter.remove(adapter.getItem(position));

        switch (direction){

            case RIGHT:
                Toast.makeText(this, "向右删除  "+ position, Toast.LENGTH_SHORT).show();
                break;
            case LEFT:
                Toast.makeText(this, "向左删除  "+ position, Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

    }
}
