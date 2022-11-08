package com.seedreality.seedserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class SeedService extends Service {
    private static String TAG = "SeedService";
    static {
        System.loadLibrary("seedserver");
    }
    private int count;
    @Override
    public void onCreate() {
        Log.e(TAG,"TrackingService is create");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //dosomething
        new Thread(()->{
            try {
                while (true){
                    Thread.sleep(10000);
                    Log.e(TAG,"TrackingService do something:" + (count++));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new TrackBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    class TrackBinder extends Track.Stub {

        public String getData(){

            return stringFromJNI();
        }//通过Binder实例将service中的方法暴露出去
    }


    public native String stringFromJNI();
}
