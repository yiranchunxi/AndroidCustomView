package custom.study.com.fragment;

import android.view.View;

import custom.study.com.R;

/**
 * Created by Administrator on 2017/7/26.
 */

public class CustomFragment3 extends BaseFragment {


    @Override
    protected View setView() {
        return View.inflate(getActivity(), R.layout.fragment_customview3, null);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onInitPresenters() {

    }
}
