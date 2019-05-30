package com.finddreams.module_gooddetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.finddreams.module_base.base.BaseActivity;
import com.finddreams.module_base.entrties.TestBean;
import com.finddreams.module_base.utils.ModuleRouteService;
import com.finddreams.module_base.utils.RouteManager;

/**
 * Created by liuxiang on 2017/10/24.
 */
@Route(path = RouteManager.ACTIVITY_URL_GOODDETAIL)
public class GoodDetailActivity extends BaseActivity {

    @Autowired()
    String goodName;

    @Autowired(name = "detail")
    TestBean testBean;

    TextView tvGoodName;
    TextView tv_address;

    @Override
    protected int getLayoutResId() {
        return R.layout.gooddetail_activity_main;
    }

    @Override
    protected void initEventAndData(@Nullable Bundle savedInstanceState) {
        tvGoodName = findViewById(R.id.tv_good_name);
        tv_address = findViewById(R.id.tv_address);
        setTitle("商品详情模块");
        Bundle bundle = getIntent().getExtras();
        if (null != bundle) {
            String goodName = bundle.getString("goodName");
            TestBean testBean = (TestBean) bundle.getSerializable("detail");
            System.out.println(goodName);
            System.out.println(testBean);
            if (null != testBean) {
                tvGoodName.setText(testBean.getName());
                tvGoodName.append("\n");
                tvGoodName.append(testBean.getDetail());
            }
        }
        tv_address.setText("用户所在地址:" + ModuleRouteService.getUserAddress("123"));
    }
}
