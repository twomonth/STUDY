package com.twomonth.study;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.twomonth.base.utils.BaseInit;
import com.twomonth.study.net.NetWork;

public class MineApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new MineApplicationObserver());
        BaseInit.dialogXInit(this);
        BaseInit.loggerInit(BuildConfig.DEBUG);
        NetWork.init(BuildConfig.DEBUG);
    }
}
