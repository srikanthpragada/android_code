package com.st.code;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class NumbersService extends Service {
    public NumbersService() {
    }

    @Override
    public void onCreate() {
        Log.d("Service", "onCreate()");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d("Service", "onDestroy()");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
         Log.d("Service", "onBind()");
         return  new NumbersBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("Service", "onUnbind()");
        return super.onUnbind(intent);
    }

    public boolean isEven(int number) {
        return  number % 2 == 0 ;
    }

    public boolean isPerfect(int number) {

        int sum = 0;
        for (int i =1; i <= number/2; i ++)
        {
            if ( number % i == 0 )
                 sum += i;
        }

        return  sum == number;
    }


    public class NumbersBinder extends Binder {
         public NumbersService  getService() {
             return  NumbersService.this;
         }
    }
}
