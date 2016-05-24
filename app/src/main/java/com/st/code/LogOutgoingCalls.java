package com.st.code;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class LogOutgoingCalls extends BroadcastReceiver {
    public LogOutgoingCalls() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String phone =  intent.getStringExtra( Intent.EXTRA_PHONE_NUMBER);
        Log.d("Code", "Calling " + phone);
        // bar call
        intent.putExtra(Intent.EXTRA_PHONE_NUMBER,(String) null);
    }
}
