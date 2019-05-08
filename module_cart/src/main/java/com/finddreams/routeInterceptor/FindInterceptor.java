package com.finddreams.routeInterceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.finddreams.module_base.utils.RouteManager;

@Interceptor(priority = 1)
public class FindInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        System.out.println("FindInterceptor process");
        if (postcard.getPath().equals(RouteManager.ACTIVITY_URL_GOODDETAIL)) {
            System.out.println("find interceptor!!!");
        }
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {
        System.out.println("FindInterceptor init");
    }
}
