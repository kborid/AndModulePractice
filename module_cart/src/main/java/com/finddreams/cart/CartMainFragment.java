package com.finddreams.cart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.finddreams.module_base.base.BaseFragment;
import com.finddreams.module_base.entrties.TestBean;
import com.finddreams.module_base.event.LoginStateEvent;
import com.finddreams.module_base.utils.RouteManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by lx on 17-10-24.
 */
@Route(path = RouteManager.FRAGMENT_URL_CART_MAIN)
public class CartMainFragment extends BaseFragment {
    TextView tv_loginstate;
    TextView tvGoodname;
    Button btGotoGooddetail;

    @Override
    protected int getLayoutResId() {
        return R.layout.cart_fragment_main;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        tvGoodname = mRootView.findViewById(R.id.tv_goodname);
        tv_loginstate = mRootView.findViewById(R.id.tv_loginstate);
        btGotoGooddetail = mRootView.findViewById(R.id.bt_goto_gooddetail);
        final String goodName = tvGoodname.getText().toString();
        btGotoGooddetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestBean testBean = new TestBean();
                testBean.setName("MacBook Pro");
                testBean.setDetail("MacBook Pro, make in USA, personal computer, popular!!");
                testBean.setPrice(20000);
                RouteManager.startGoodDetailActivity(getActivity(), goodName, testBean);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginSuccess(LoginStateEvent event) {
        if (event.isSuccess) {
            tv_loginstate.setText("已登录");
        }
    }
}
