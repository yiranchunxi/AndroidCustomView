package custom.study.com.fragment;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import custom.study.com.R;

/**
 * Created by Administrator on 2017/7/26.
 */

public class CustomFragment10 extends BaseFragment {

    @Nullable @Bind(R.id.btn_clamp)
    Button btn_clamp;

    @Nullable @Bind(R.id.btn_mirror) Button btn_mirror;

    @Nullable @Bind(R.id.btn_repaeat) Button btn_repeat;

    @Nullable @Bind(R.id.linearGradientView) custom.study.com.paint.Practice01LinearGradientView linearGradientView;
    @Override
    protected View setView() {
        return View.inflate(getActivity(), R.layout.fragment_customview10, null);
    }

    @Override
    protected void initView() {

        btn_clamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearGradientView.setType(1);
                linearGradientView.invalidate();
            }
        });

        btn_mirror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearGradientView.setType(2);
                linearGradientView.invalidate();
            }
        });

        btn_repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearGradientView.setType(3);
                linearGradientView.invalidate();
            }
        });

    }

    @Override
    protected void onInitPresenters() {

    }
}
