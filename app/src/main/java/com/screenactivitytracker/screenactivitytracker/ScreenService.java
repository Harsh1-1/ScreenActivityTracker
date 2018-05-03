package com.screenactivitytracker.screenactivitytracker;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class ScreenService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        ScreenEventReceiver mReceiver = new ScreenEventReceiver();
        registerReceiver(mReceiver, filter);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
