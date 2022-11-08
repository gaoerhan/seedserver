package com.seedreality.seedserver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {

    static final String ACTION = "android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent in) {

        if (in.getAction().equals(ACTION)) {
            Intent intent = new Intent(SeedApplication.getContext(), SeedService.class);
            SeedApplication.getContext().startService(intent);
        }
    }
}
