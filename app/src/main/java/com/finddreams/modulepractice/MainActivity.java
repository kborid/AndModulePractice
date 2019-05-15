package com.finddreams.modulepractice;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.finddreams.module_base.base.BaseActivity;
import com.finddreams.module_base.utils.RouteManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.finddreams.module_base.utils.RouteManager.FRAGMENT_URL_MAIN;

/**
 * Created by lx on 17-10-24.
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    @Override
    protected int getResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        initViewPager();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rb_find:
                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rb_cart:
                        viewPager.setCurrentItem(2, false);
                        break;
                    case R.id.rb_user:
                        viewPager.setCurrentItem(3, false);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initViewPager() {
        List<Fragment> fragmentList = new ArrayList<>();
        for (String url : FRAGMENT_URL_MAIN) {
            fragmentList.add(RouteManager.getMainFragment(url));
        }
        viewPager.setOffscreenPageLimit(fragmentList.size());
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragmentList));
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
    }
}
