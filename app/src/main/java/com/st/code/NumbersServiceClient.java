package com.st.code;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NumbersServiceClient extends AppCompatActivity {
    EditText editNumber;
    private NumbersService numberService = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_service_client);
        editNumber = (EditText) findViewById(R.id.editNumber);
    }

    public void connectToService(View v) {
        Intent intent = new Intent(this, NumbersService.class);
        bindService(intent, sConnection, Context.BIND_AUTO_CREATE);
    }

    public void disconnectFromService(View v) {
        unbindService(sConnection);
    }

    public void isEven(View v) {
        int num =  Integer.parseInt(editNumber.getText().toString());

        if( numberService.isEven(num))
            Toast.makeText(this, "Even Number", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Odd Number", Toast.LENGTH_LONG).show();

    }


    public void isPerfect(View v) {
        int num =  Integer.parseInt(editNumber.getText().toString());

        if( numberService.isPerfect(num))
            Toast.makeText(this, "Perect Number", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Not a perfect number", Toast.LENGTH_LONG).show();

    }


    private  ServiceConnection sConnection = new ServiceConnection() {


        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
             Log.d("Code", "onServiceConnected()");
             NumbersService.NumbersBinder mbinder = (NumbersService.NumbersBinder) binder;
             numberService = (NumbersService) mbinder.getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("Code", "onServiceDisconnected()");
        }
    };
}
