package com.screenactivitytracker.screenactivitytracker;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class ScreenEventReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
        } else if(intent.getAction().equals(Intent.ACTION_USER_PRESENT)){
            KeyguardManager keyguardManager=(KeyguardManager)context.getSystemService(Context.KEYGUARD_SERVICE);
            if(Build.VERSION.SDK_INT>=22){
                if(!keyguardManager.isDeviceLocked()){
                    Log.e("status","phone unlocked");
                }else{
                    Log.e("status","phone locked");
                }
            }else{
                if(!keyguardManager.isKeyguardLocked()){
                    Log.e("status","phone unlocked");
                }else{
                    Log.e("status","phone locked");
                }
            }
        }else if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
            Log.e("status","in screen off");
        }
    }

}