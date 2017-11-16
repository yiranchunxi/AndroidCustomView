package custom.study.com.fragment;

import android.media.MediaCodec;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/26.
 */

public abstract  class BaseFragment extends Fragment {


    protected View mContentView;

    protected abstract View setView();

    protected abstract  void initView();

    protected abstract  void onInitPresenters();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        if(mContentView!=null&&mContentView.getParent()!=null){
            ((ViewGroup)mContentView.getParent()).removeView(mContentView);

        }else{

            mContentView=setView();

            ButterKnife.bind(this,mContentView);

            initView();

            onInitPresenters();

        }
        return  mContentView;
    }

    public View findViewById(int id){
        return  mContentView.findViewById(id);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
