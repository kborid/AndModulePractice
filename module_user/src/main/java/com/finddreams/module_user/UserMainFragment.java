package com.finddreams.module_user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.finddreams.module_base.base.BaseFragment;
import com.finddreams.module_base.event.LoginStateEvent;
import com.finddreams.module_base.utils.RouteManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by lx on 17-10-24.
 */
@Route(path = RouteManager.FRAGMENT_URL_USER_MAIN)
public class UserMainFragment extends BaseFragment {

    private TextView tv_login_state;

    @Override
    protected int getLayoutResId() {
        return R.layout.user_fragment_main;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        Button bt_login_state = mRootView.findViewById(R.id.bt_login);
        tv_login_state = mRootView.findViewById(R.id.tv_login_state);
        bt_login_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RouteManager.startLoginActivity();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginSuccess(LoginStateEvent event) {
        if (event.isSuccess) {
            tv_login_state.setText("已登录");
        }
    }

}
