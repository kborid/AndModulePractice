package com.finddreams.module_base.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    private static final String IS_SUPPORT_HIDE_STATE = "IS_SUPPORT_HIDE_STATE";

    protected View mRootView;
    private boolean isInitialized = false;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println(getClass().getSimpleName() + ":" + "onAttach()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println(getClass().getSimpleName() + ":" + "onCreateView()");
        mRootView = inflater.inflate(getLayoutResId(), null);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println(getClass().getSimpleName() + ":" + "onViewCreated()");
        if (savedInstanceState == null) {
            if (!isHidden()) {
                isInitialized = true;
                initEventAndData(null);
            }
        } else {
            boolean isSupportHidden = savedInstanceState.getBoolean(IS_SUPPORT_HIDE_STATE);
            if (!isSupportHidden) {
                isInitialized = true;
                initEventAndData(savedInstanceState);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println(getClass().getSimpleName() + ":" + "onSaveInstanceState()");
        outState.putBoolean(IS_SUPPORT_HIDE_STATE, isHidden());
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        System.out.println(getClass().getSimpleName() + ":" + "onHiddenChanged() hidden = " + hidden);
        if (!isInitialized && !hidden) {
            isInitialized = true;
            initEventAndData(null);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        System.out.println(getClass().getSimpleName() + ":" + "setUserVisibleHint() isVisibleToUser = " + isVisibleToUser);
        if (!isInitialized && isVisibleToUser) {
            isInitialized = true;
            initEventAndData(null);
        }
    }

    protected abstract int getLayoutResId();

    protected abstract void initEventAndData(Bundle savedInstanceState);
}
