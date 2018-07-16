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
import custom.study.com.fragment.CustomFragment10;
import custom.study.com.fragment.CustomFragment11;
import custom.study.com.fragment.CustomFragment4;
import custom.study.com.fragment.PageFragment;

/**
 * Created by Administrator on 2017/7/28.
 */

public class PaintActivity extends FragmentActivity {

    @Nullable
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Nullable
    @Bind(R.id.magic_indicator)
    MagicIndicator magic_indicator;
    private static final String[] CHANNELS = new String[14];
    List<Fragment> fragmentContainter = new ArrayList<Fragment>();
    private CustomFragment10 fg=new CustomFragment10();
    private CustomFragment11 fg1=new CustomFragment11();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        CHANNELS[0] = "LinearGradientView";
        CHANNELS[1]="RadialGradientView";
        CHANNELS[2]="BitmapShaderView";
        CHANNELS[3]="ComposerShaderView";
        CHANNELS[4]="ColorFilterView";
        CHANNELS[5]="ColorMatrixColorfilterView";
        CHANNELS[6]="XfermodeView";
        CHANNELS[7]="StrokeCapView";
        CHANNELS[8]="StrokeJoinView";
        CHANNELS[9]="pathEffect";
        CHANNELS[10]="ShadowLayerView";
        CHANNELS[11]="MaskFilterView";
        CHANNELS[12]="FillPathView";
        CHANNELS[12]="TextPathView";
        ButterKnife.bind(this);
        initViewPager();
        initMagicIndicator();
    }

    public void initViewPager() {
        fragmentContainter.add(fg);
        fragmentContainter.add(fg1);
        fragmentContainter.add(PageFragment.newInstance(R.layout.bitmap_shader_view));
        fragmentContainter.add(PageFragment.newInstance(R.layout.compost_shader_view));
        fragmentContainter.add(PageFragment.newInstance(R.layout.color_filter_view));
        fragmentContainter.add(PageFragment.newInstance(R.layout.color_matrix_view));
        fragmentContainter.add(PageFragment.newInstance(R.layout.xfermode_view));
        fragmentContainter.add(PageFragment.newInstance(R.layout.stroke_cap_view));
        fragmentContainter.add(PageFragment.newInstance(R.layout.stroke_join_view));
        fragmentContainter.add(PageFragment.newInstance(R.layout.path_effect_view));
        fragmentContainter.add(PageFragment.newInstance(R.layout.shadow_layer_view));
        fragmentContainter.add(PageFragment.newInstance(R.layout.mask_filter_view));
        fragmentContainter.add(PageFragment.newInstance(R.layout.fill_path_view));
        fragmentContainter.add(PageFragment.newInstance(R.layout.text_path_view));
        viewPager.setAdapter(new android.support.v4.app.FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
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
