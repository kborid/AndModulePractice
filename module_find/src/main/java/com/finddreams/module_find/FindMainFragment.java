package com.finddreams.module_find;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.finddreams.module_base.base.BaseFragment;
import com.finddreams.module_base.utils.RouteManager;

/**
 * Created by lx on 17-10-24.
 */
@Route(path = RouteManager.FRAGMENT_URL_FIND_MAIN)
public class FindMainFragment extends BaseFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.find_fragment_main;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {

    }
}
