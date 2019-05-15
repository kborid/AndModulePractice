package com.finddreams.module_base.utils;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.finddreams.module_base.entrties.TestBean;

/**
 * Created by lx on 17-10-24.
 * 路由URL管理类
 */

public class RouteManager {
    public static final String FRAGMENT_URL_HOME_MAIN = "/home/main";
    public static final String FRAGMENT_URL_FIND_MAIN = "/find/main";
    public static final String FRAGMENT_URL_CART_MAIN = "/cart/main";
    public static final String FRAGMENT_URL_USER_MAIN = "/user/main";
    public static final String[] FRAGMENT_URL_MAIN = {
            FRAGMENT_URL_HOME_MAIN,
            FRAGMENT_URL_FIND_MAIN,
            FRAGMENT_URL_CART_MAIN,
            FRAGMENT_URL_USER_MAIN
    };

    public static final String ACTIVITY_URL_GOODDETAIL = "/gooddetail/main";
    public static final String ACTIVITY_URL_USER = "/user/login";

    public static final String SERVICE_URL_USER = "/user/service";

    public static Fragment getMainFragment(String url) {
        return (Fragment) ARouter.getInstance().build(url).navigation();
    }

//    public static Fragment getHomeFragment() {
//        return (Fragment) ARouter.getInstance().build(FRAGMENT_URL_HOME_MAIN).navigation();
//    }
//
//    public static Fragment getFindFragment() {
//        return (Fragment) ARouter.getInstance().build(FRAGMENT_URL_FIND_MAIN).navigation();
//    }
//
//    public static Fragment getCartFragment() {
//        return (Fragment) ARouter.getInstance().build(FRAGMENT_URL_CART_MAIN).navigation();
//    }
//
//    public static Fragment getUserFragment() {
//        return (Fragment) ARouter.getInstance().build(FRAGMENT_URL_USER_MAIN).navigation();
//    }

    /**
     * 跳转到商品详情的页面
     *
     * @param goodName
     */
    public static void startGoodDetailActivity(Context context, String goodName, TestBean bean) {
        ARouter.getInstance().build(ACTIVITY_URL_GOODDETAIL)
                .withString("goodName", goodName)
                .withSerializable("detail", bean)
                .navigation(context, new NavCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        super.onFound(postcard);
                        System.out.println("onFound()");
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        System.out.println("onArrival()");
                    }
                });
    }

    public static void startLoginActivity() {
        ARouter.getInstance().build(ACTIVITY_URL_USER).navigation();
    }
}
