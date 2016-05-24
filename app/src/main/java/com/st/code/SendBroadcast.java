package com.st.code;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class SendBroadcast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendbroadcast);
    }

    public void send(View v) {
       Intent intent  = new Intent("com.st.code.PRINT");
       intent.putExtra("now", new Date().toString());
       this.sendBroadcast(intent);  // publish message
       Log.d("Code","Back in SendBroadcast");
    }

}
