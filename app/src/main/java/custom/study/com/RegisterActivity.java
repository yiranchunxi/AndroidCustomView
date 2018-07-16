package custom.study.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import custom.study.com.bean.EventData;
import custom.study.com.fragment.RegisterFragment1;
import custom.study.com.fragment.RegisterFragment2;
import custom.study.com.fragment.RegisterFragment3;
import views.MyViewPager;
import widget.BusProvider;

/**
 * Created by Administrator on 2018/7/13.
 */

public class RegisterActivity extends AppCompatActivity {


    @Nullable
    @Bind(R.id.guidePageViewPage)
    MyViewPager viewPager;

    private List<Fragment> tabFragments;
    private int current_postion;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        tabFragments = new ArrayList<>();

        tabFragments.add(RegisterFragment1.newInstance("", ""));
        tabFragments.add(RegisterFragment2.newInstance("", ""));
        tabFragments.add(RegisterFragment3.newInstance("",""));

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return tabFragments.get(position);
            }

            @Override
            public int getCount() {
                return tabFragments.size();
            }
        });


        BusProvider.getInstance().register(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        BusProvider.getInstance().unregister(this);
    }

    @Subscribe
    public void LoginSuccessSend(EventData data){

          current_postion=(int)data.getContent();
          viewPager.setCurrentItem(current_postion,true);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if(current_postion==0){
                finish();
            }else{
                current_postion--;
                viewPager.setCurrentItem(current_postion,true);
            }
            return true;
        }

        return super.onKeyDown(keyCode,event);
    }
}

