package com.finddreams.module_user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.finddreams.module_base.base.BaseActivity;
import com.finddreams.module_base.event.LoginStateEvent;
import com.finddreams.module_base.utils.RouteManager;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by lx on 17-10-25.
 */
@Route(path = RouteManager.ACTIVITY_URL_USER)
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    Button btLoginSuccess;
    Button btLoginFail;

    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.bt_login_success:
//                break;
//            case R.id.bt_login_fail:
//                break;
//        }
        int id = view.getId();
        if (id == R.id.bt_login_success) {
            EventBus.getDefault().post(new LoginStateEvent(true));
        } else if (id == R.id.bt_login_fail) {
            EventBus.getDefault().post(new LoginStateEvent(false));
        }
        finish();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.user_activity_login;
    }

    @Override
    protected void initEventAndData(@Nullable Bundle savedInstanceState) {
        btLoginSuccess = findViewById(R.id.bt_login_success);
        btLoginFail = findViewById(R.id.bt_login_fail);
        btLoginFail.setOnClickListener(this);
        btLoginSuccess.setOnClickListener(this);
        setTitle("登录模块");
    }
}
