package custom.study.com.fragment;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import custom.study.com.R;

/**
 * Created by Administrator on 2017/7/26.
 */

public class CustomFragment11 extends BaseFragment {


  //  @Nullable @Bind(R.id.radialGradientView) custom.study.com.paint.Practice01LinearGradientView radialGradientView;
    @Override
    protected View setView() {
        return View.inflate(getActivity(), R.layout.fragment_customview11, null);
    }

    @Override
    protected void initView() {

    }


    @Override
    protected void onInitPresenters() {

    }
}
