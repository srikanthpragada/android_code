package com.st.code;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class TimeChangeReceiver extends BroadcastReceiver {
    public TimeChangeReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
         Log.d("Code", "New Time : " +  new Date().toString());
    }
}
