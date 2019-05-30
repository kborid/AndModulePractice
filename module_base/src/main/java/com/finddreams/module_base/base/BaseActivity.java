package com.finddreams.module_base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ARouter.getInstance().inject(this);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        initEventAndData(savedInstanceState);
    }

    protected abstract int getLayoutResId();

    protected abstract void initEventAndData(@Nullable Bundle savedInstanceState);
}
