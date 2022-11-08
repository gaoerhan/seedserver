package com.seedreality.seedserver;

import android.app.Application;

public class SeedApplication extends Application {

    private static Application mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Application getContext(){
        return mContext;
    }
}
