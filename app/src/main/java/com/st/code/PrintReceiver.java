package com.st.code;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PrintReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            Thread.sleep(1000);
        }
        catch(Exception ex) {}

       Log.d("Code", intent.getStringExtra("now"));
    }
}
