package com.finddreams.module_home;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.finddreams.module_base.base.BaseFragment;
import com.finddreams.module_base.utils.RouteManager;

/**
 * Created by lx on 17-10-24.
 */
@Route(path = RouteManager.FRAGMENT_URL_HOME_MAIN)
public class HomeMainFragment extends BaseFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.home_fragment_main;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {

    }
}
