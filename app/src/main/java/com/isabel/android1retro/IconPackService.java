package com.isabel.android1retro;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class IconPackService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("IconPackService", "Service bound");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("IconPackService", "Service started");
        return START_STICKY;
    }
}
