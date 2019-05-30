package com.finddreams.modulepractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.finddreams.module_base.base.BaseActivity;
import com.finddreams.module_base.utils.RouteManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.finddreams.module_base.utils.RouteManager.FRAGMENT_URL_MAIN;

public class MainActivity extends BaseActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData(@Nullable Bundle savedInstanceState) {
        initViewPager();
        setListener();
        viewPager.setCurrentItem(1);
    }

    private void initViewPager() {
        List<Fragment> fragmentList = new ArrayList<>();
        for (String url : FRAGMENT_URL_MAIN) {
            fragmentList.add(RouteManager.getMainFragment(url));
        }
        viewPager.setOffscreenPageLimit(fragmentList.size());
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragmentList));
    }

    private void setListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.getChildAt(position).performClick();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = 0;
                switch (checkedId) {
                    case R.id.rb_home:
                        index = 0;
                        break;
                    case R.id.rb_find:
                        index = 1;
                        break;
                    case R.id.rb_cart:
                        index = 2;
                        break;
                    case R.id.rb_user:
                        index = 3;
                        break;
                }
                viewPager.setCurrentItem(index, true);
            }
        });
    }
}
