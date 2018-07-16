package custom.study.com;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import custom.study.com.fragment.PageFragment;

/**
 * Created by Administrator on 2018/6/14.
 */

public class AnimateActivity extends FragmentActivity {



    @Nullable
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Nullable
    @Bind(R.id.magic_indicator)
    MagicIndicator magic_indicator;
    private static final String[] CHANNELS = new String[14];
    List<Fragment> fragmentContainter = new ArrayList<Fragment>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        CHANNELS[0] = "Sample01Translation";
        CHANNELS[1]="Sample02Rotation";
        CHANNELS[2]="Sample05MultiProperties";
        CHANNELS[3]="Sample06Duration";
        CHANNELS[4]="Sample07Interpolator";
        CHANNELS[5]="Sample08ObjectAnimatorLayout";
        CHANNELS[6]="CustomPractice";
        CHANNELS[7]="Sample01ArgbEvaluatorLayout";
        CHANNELS[8]="Sample03OfObjectView";
        CHANNELS[9]="Sample04PropertyValuesHolderLayout";
        CHANNELS[10]="Sample05AnimatorSetLayout";
        CHANNELS[11]="Sample06KeyframeLayout";
        CHANNELS[12]="Sample01SquareImageView";
        CHANNELS[13]="SampleQuadLayoutView";
        ButterKnife.bind(this);
        initViewPager();
        initMagicIndicator();
    }

    public void initViewPager() {

        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_translation));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_rotate));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_multiproperties));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_duration));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_interpolator));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_object));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_animate_view));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_argb_evaluator));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_pointf_object));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_property_values_holder));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_animator_set));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_keyframe));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_measure));
        fragmentContainter.add(PageFragment.newInstance(R.layout.sample_quad));
        viewPager.setAdapter(new android.support.v4.app.FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentContainter.get(position);

            }

            @Override
            public int getCount() {
                return fragmentContainter.size();
            }

        });
    }

    public void initMagicIndicator() {

        CommonNavigator commonNavigator = new CommonNavigator(this);



        //commonNavigator.setAdjustMode(false);

        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return CHANNELS != null && CHANNELS.length > 0 ? CHANNELS.length : 0;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setNormalColor(Color.parseColor("#666666"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#ff8903"));
                simplePagerTitleView.setTextSize(15);
                simplePagerTitleView.setText(CHANNELS[index]);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                //indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
               /* indicator.setYOffset(UIUtil.dip2px(context, 3));*/
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                indicator.setColors(Color.parseColor("#ff8903"));

                // indicator.setLineWidth(100);
                return indicator;
            }
        });

        magic_indicator.setNavigator(commonNavigator);
        //设置分隔栏
       /* LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        titleContainer.setDividerPadding(UIUtil.dip2px(this, 12));
        titleContainer.setDividerDrawable(getResources().getDrawable(R.drawable.shape_simple_splitter));*/
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                magic_indicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                magic_indicator.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                magic_indicator.onPageScrollStateChanged(state);
            }
        });
    }
}
